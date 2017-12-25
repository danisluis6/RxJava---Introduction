package com.example.lorence.rxtutorial.application;

import android.app.Application;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/25/2017
 */

/**
 * App will start in here before jumping Activity
 * @link https://proandroiddev.com/dagger-2-part-ii-custom-scopes-component-dependencies-subcomponents-697c1fa1cfc
 * @link https://www.youtube.com/watch?v=c0BMD30dbxE
 */

public class CakeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        DaggerApplicationComponent.builder().create();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
