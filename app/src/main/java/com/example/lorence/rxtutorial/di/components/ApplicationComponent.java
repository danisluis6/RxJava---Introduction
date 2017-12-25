package com.example.lorence.rxtutorial.di.components;

import android.content.Context;

import com.example.lorence.rxtutorial.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

/**
 * @Component enable selected modules and used for performing dependency injection
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
