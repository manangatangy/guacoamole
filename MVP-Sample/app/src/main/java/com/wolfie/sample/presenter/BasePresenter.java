/**
 * (C) 2016. National Australia Bank [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of National Australia
 * Bank. Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package com.wolfie.sample.presenter;/**
 * (C) 2016. National Australia Bank [All rights reserved]. This product and related documentation
 * are protected by copyright restricting its use, copying, distribution, and decompilation. No part
 * of this product or related documentation may be reproduced in any form by any means without prior
 * written authorization of National Australia Bank. Unless otherwise arranged, third parties may
 * not have access to this product or related documents.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.wolfie.sample.view.BaseUi;
import com.wolfie.sample.view.activity.BaseActivity.KeyboardVisibility;

/**
 * Created by David Weiss on 29/09/2016.
 */
public abstract class BasePresenter<T extends BaseUi> implements Presenter {

//    @Inject
    public T mUi;

    protected boolean mPaused;

    protected T getUi() {
        return mUi;
    }

    @Override
    public boolean backPressed() {
        return true;
    }

    @Override
    public boolean homeAsUpPressed() {
        return true;
    }

    @Override
    public boolean onKeyboardVisibilityChanged(KeyboardVisibility keyboardVisibility) {
        return false;
    }

    /**
     * Useful to check before activating a callback on the fragment if there is a chance that the activity has been
     * paused, while waiting for the callback to complete.
     *
     * @return true if the associated fragment is in paused state.
     */
    protected boolean isPaused() {
        return mPaused;
    }

    public Context getContext() {
        return getUi().getContext();
    }

    @CallSuper
    @Override
    public void pause() {
        mPaused = true;
//        getUi().hideSoftKeyboard();
    }

    @CallSuper
    @Override
    public void resume() {
        mPaused = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onSaveState(Bundle outState) {
    }

    @Override
    public void onRestoreState(@Nullable Bundle savedState) {
    }

}
