package com.wolfie.sample.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.wolfie.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by david on 28/09/16.
 */

public abstract class SimpleActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fragment_container_activity)
    FrameLayout fragmentContainer;

    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        unbinder = ButterKnife.bind(this);
    }

    /**
     * Create the named fragment and add its view to the specified container.
     * If the containerViewId is 0, then the fragment_container_activity will be used.
     * If not null, the specified Bundle will be given to the fragment as args.
     */
    protected Fragment setupFragment(String fragClassName, @IdRes int containerViewId,
                                     @Nullable Bundle args) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragClassName);
        if (fragment == null) {
            fragment = Fragment.instantiate(this, fragClassName, args);
            if (containerViewId == 0) {
                containerViewId = R.id.fragment_container_activity;
            }
            getSupportFragmentManager().beginTransaction().add(containerViewId, fragment, fragClassName).commit();
        }
        return fragment;
    }

    /**
     * Remove the specified fragment from the activity state and its container.
     */
    protected void teardownFragment(String fragClassName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(fragClassName);
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
    }

//    @Override
//    public void showToolbar(boolean show) {
//        toolbar.setVisibility(show ? View.VISIBLE : View.GONE);
//    }
//
//    protected void setupToolbar(boolean inhibitElevationAdjust) {
//        toolbar.setTitleTextAppearance(this, R.style.AppTheme_Text_H1);
//        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.black));
//        if (inhibitElevationAdjust) {
//            fragmentContainer.setForeground(null);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                toolbar.setElevation(0f);
//            }
//        }
//        setSupportActionBar(toolbar);
//    }

    protected void setupTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setTitle(int resId) {
        getSupportActionBar().setTitle(resId);
    }
    protected void setupHomeUp(boolean homeAsUp) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUp);
    }

//    private void setupBackArrowColour() {
//        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        upArrow.setColorFilter(getResources().getColor(R.color.red_on_black), PorterDuff.Mode.SRC_ATOP);
//        getSupportActionBar().setHomeAsUpIndicator(upArrow);
//    }

    protected void setupUpIndicator(int resId) {
        getSupportActionBar().setHomeAsUpIndicator(resId);
    }

}
