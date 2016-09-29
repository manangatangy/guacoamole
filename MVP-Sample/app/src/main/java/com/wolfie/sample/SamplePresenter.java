package com.wolfie.sample;

import com.wolfie.sample.SamplePresenter.SampleUi;
import com.wolfie.sample.presenter.BasePresenter;
import com.wolfie.sample.view.BaseUi;

public class SamplePresenter extends BasePresenter<SampleUi> {

    public SamplePresenter(SampleUi sampleUi) {
        super(sampleUi);
    }

    public interface SampleUi extends BaseUi {

    }

}
