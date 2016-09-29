/**
 * (C) 2016. National Australia Bank [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of National Australia
 * Bank. Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package com.wolfie.sample;/**
 * (C) 2016. National Australia Bank [All rights reserved]. This product and related documentation
 * are protected by copyright restricting its use, copying, distribution, and decompilation. No part
 * of this product or related documentation may be reproduced in any form by any means without prior
 * written authorization of National Australia Bank. Unless otherwise arranged, third parties may
 * not have access to this product or related documents.
 */


import com.wolfie.sample.SamplePresenter.SampleUi;
import com.wolfie.sample.presenter.BasePresenter;
import com.wolfie.sample.view.BaseUi;

/**
 * Created by David Weiss on 29/09/2016.
 */
public class SamplePresenter<T extends SampleUi> extends BasePresenter<T> {


    public interface SampleUi extends BaseUi {

    }
    /*
        @Override
    public boolean backPressed() {
        if (!getUi().isSheetShowing()) {
            return true;
        }
        getUi().hideSheet(true);
        return false;
    }

    @Override
    public boolean homeAsUpPressed() {
        if (!getUi().isSheetShowing()) {
            return true;
        }
        getUi().hideSheet(true);
        return false;
    }

    public interface ActionSheetUi extends BaseUi {
        boolean isSheetShowing();
        void showSheet();
        void hideSheet(boolean isCancelled);    // Indicates if closed via back-button or cancel button
    }

     */
}
