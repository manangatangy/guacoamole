package com.wolfie.sample.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolfie.sample.view.activity.BaseActivity.KeyboardVisibility;

/**
 * Created by david on 28/09/16.
 */

public interface Presenter {

    void onCreate(Bundle savedInstanceState);

    /**
     * Should be called in the view's (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Should be called in the view's (Activity or Fragment) onPause() method.
     */
    void pause();


    /**
     * Should be called in the view's (Activity or Fragment) onDestroy() method.
     */
    void onDestroy();

    /**
     * Method to save presenter state. It should be called in the view's onSavedInstanceState() method
     */
    void onSaveState(Bundle outState);

    /**
     * Method to restore presenter state. It should be called in the view's onViewStateRestored() method
     */
    void onRestoreState(@Nullable Bundle savedState);

    /**
     * Back pressed boolean.
     * @return bool indicating whether OS should execute its default backpressedcode
     */
    boolean backPressed();

    /**
     * Home pressed boolean.
     * @return bool indicating whether OS should execute its default home pressed action
     */
    boolean homeAsUpPressed();

    /**
     * A listener for keyboard visibility change events.
     */
    boolean onKeyboardVisibilityChanged(KeyboardVisibility keyboardVisibility);

}
