package com.wolfie.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wolfie.sample.view.activity.SimpleActivity;

public class SampleActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setupToolbar();
//        setupTitle("");
//        setupHomeUp();
//        setupBackArrowColour();
//        setupUpIndicator();
        setupFragment(SampleFragment.class.getName(), 0, null);
    }
}
