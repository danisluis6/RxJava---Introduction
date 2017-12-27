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

    /**
     * AppComplicationModule  => pass Retrofit by method exposeRetrofit and convert Retrofit as parameter use it as CakeModule.
     * To access CakeModule. We need to use CakeComponent with relation is "dependencies".
     * In here: dependencies is Retrofit
     * So step for what:
     *
     * Step 1: In CakeModule, we will define Object to provide for other module. For example, ApplicationModule will provide @Object(Retrofit) for CakeModule
     *
     * Step 2: To CakeModule understand and use it as argument or parameter. We will use Component to communicate.
     * Typically, We will have two components in here: ApplicationComponent and CakeComponent.
     *
     * - ApplicationComponent: We will create one method with any name as (exposeObject => exposeRetrofit). In here, method will generate automatically. (Problem in here to
     * from is we need to initialize DaggerComponent in Application)
     *
     * - Dependencies ApplicationComponent with CakeComponent.
     * *** For example: ***
     *      @PerActivity
     *      @Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
     *      public interface CakeComponent {}
     *
     * Step 3: We will disable DaggerCakeComponent in MainActivity. Notice exposeRetrofit doesn't call.
     * - Crash Application. NullPointerException
     * - Clean Project => exposeRetrofit didn't call or activate.
     *
     * Find reason why Cash Application => CakePresenter is null pointer exception. Because, constructor of CakePresenter didn't initialize.
     * => Question ?? How to implement or initialize constructor.
     * * Normal ways: you will initialize in Constructor of Activity.
     * * In this situation, we use DaggerComponent and run DaggerComponent firstly. So, we just CakeComponent and create a method to inject(activity).
     * And @Inject(CakePresenter -> Object) -> Constructor is called and null pointer.
     * For example code:
     * @PerActivity
     * @Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
     *      public interface CakeComponent {
     *          void inject(MainActivity activity);
     *      }
     * And notice this line: .build().inject(this);
     *
     * Step 4: In CakePresenter:
     * @Inject protected CakeApiService mApiService; => Retrofit will get automatically from ApplicationComponent
     * => Retrofit exposeRetrofit(). This method will activate. Method that return Retrofit will be activated.
     *  Level 1. exposeRetrofit() => Retrofit.
     *  Level 1.1: => Retrofit() in ApplicationModule will be activated. Perfect, we will use
     *  Level 1.1.1: => provideRetrofit()
     *  Level 1.1.2: => provideRxJavaCallAdapterFactory()
     *  Level 1.1.3: => provideGsonConverterFactory()
     *  Level 1.1.4: => provideOkHttpClient1
     *
     * Step 5: In CakeModule
     * => DaggerComponent(Module(params -> Object))
     * - CakePresenter: I want to use this view. => @Inject protect MainView mView
     * - CakePresenter: I want to use CakeApiService => @Inject protect CakeApiService mApiService
     *
     * * CakeApiService
     *      - Invokes with Retrofit(Come from ApplicationComponent(Retrofit)) as Argument
     *      - Invokes with Context as Argument
     *
     * [ ------ MODE ------ ] Component -> Activity -> Module -> (View [@Inject])
     * [ ------ MODE ------ ] 
     * [ ------ MODE ------ ]
     *
     * * Example:
     */
    Retrofit exposeRetrofit();

    Context exposeContext();
}
