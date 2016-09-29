package com.wolfie.sample.presenter;

import com.wolfie.sample.view.BaseUi;
import com.wolfie.sample.presenter.DrawerPresenter.DrawerUi;

public class DrawerPresenter extends BasePresenter<DrawerUi> {

    public DrawerPresenter(DrawerUi drawerUi) {
        super(drawerUi);
    }

    @Override
    public boolean backPressed() {
        if (!getUi().isDrawerOpen()) {
            return true;        // Means: not consumed here
        }
        getUi().closeDrawer();
        return false;
    }

    public interface DrawerUi extends BaseUi {
        boolean isDrawerOpen();
        void closeDrawer();
    }

}
