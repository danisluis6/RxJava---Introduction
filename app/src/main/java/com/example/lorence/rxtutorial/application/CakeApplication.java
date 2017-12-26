package com.example.lorence.rxtutorial.application;

import android.app.Application;

import com.example.lorence.rxtutorial.di.components.ApplicationComponent;
import com.example.lorence.rxtutorial.di.components.DaggerApplicationComponent;
import com.example.lorence.rxtutorial.di.module.ApplicationModule;

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

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    /**
     * Using: ApplicationModule => we have two params as Context, URL
     * - Context: We get from BaseActivity
     * - URL: We get from BaseActivity
     * => We already have these params above
     */
    protected void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
