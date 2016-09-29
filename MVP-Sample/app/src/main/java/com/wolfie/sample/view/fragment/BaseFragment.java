package com.wolfie.sample.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wolfie.sample.presenter.Presenter;
import com.wolfie.sample.view.BaseUi;
import com.wolfie.sample.view.activity.BaseActivity;
import com.wolfie.sample.view.activity.BaseActivity.KeyboardVisibility;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseUi {

    protected Activity mActivity;
    protected Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Normally the inject call would go here
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        if (getPresenter() != null) {
            getPresenter().onCreate(savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            if (getPresenter() != null) {
                getPresenter().onRestoreState(savedInstanceState);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().resume();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (getPresenter() != null) {
            getPresenter().onSaveState(outState);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().pause();
        }
//        hideBannerMessage();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
        super.onDestroy();
    }

    @Nullable
    public abstract Presenter getPresenter();

    /**
     * Should return true, to let the framework handle the back press.
     * If handled here, then return false.
     */
    public boolean onBackPressed() {
        if (getPresenter() != null) {
            return getPresenter().backPressed();
        }
        return false;
    }

    /**
     * Should return true, to let the framework handle the back press.
     * If handled here, then return false.
     */
    public boolean onHomeAsUpPressed() {
        if (getPresenter() != null) {
            return getPresenter().homeAsUpPressed();
        }
        return true;
    }

    public KeyboardVisibility getKeyboardVisibility() {
        KeyboardVisibility visibility = KeyboardVisibility.UNKNOWN;
        if (mActivity != null && mActivity instanceof BaseActivity) {
            return ((BaseActivity) mActivity).getKeyboardVisibility();
        }
        return visibility;
    }

    /**
     * A listener for keyboard visibility change events.
     */
    public boolean onKeyboardVisibilityChanged(KeyboardVisibility keyboardVisibility) {
        return getPresenter() != null && getPresenter().onKeyboardVisibilityChanged(keyboardVisibility);
    }

}
