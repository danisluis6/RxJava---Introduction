package com.example.lorence.rxtutorial.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

/**
 * @Provides define classes and methods which provide dependencies
 * Understand
 * - We need to parameter, so we define Constructor and get it from outside. In here, we want to get URL from outside
 * - Another, we have a lot of methods like
 */

@Module
public class ApplicationModule {

    private String mBaseUrl;
    private Context mContext;

    private ApplicationModule(Context context, String baseUrl) {
        mContext = context;
        mBaseUrl = baseUrl;
    }


    /**
     * When we use modules = ApplicationModule.class
     *
     * => provideGsonConverterFactory() means that provide object GsonConverterFactory
     * => In AppComponent: We can declare somethings about that as:
     * - GsonConverterFactory getGsonConverterFactory();
     * - GsonConverterFactory isGsonConverterFactory();
     * ...
     * Advance
     * - GsonConverterFactory getGsonConverterFactory(param...);
     * param can be
     * - Object Module
     * - Object that provide from another Module(no need to have dependencies)
     * - Object that provide from another Interface()
     * - Object that is class
     */
    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    /**
     * When we use modules = ApplicationModule.class
     *
     * => provideOkHttpClient1() means that provide object OkHttpClient
     * => In AppComponent: We can declare somethings about that as:
     * - OkHttpClient getOkHttpClient();
     * - OkHttpClient isOkHttpClient();
     * ...
     */
    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    /**
     * When we use modules = ApplicationModule.class
     *
     * => provideOkHttpClient2() means that provide object OkHttpClient
     * => In AppComponent: We can declare somethings about that as:
     * - OkHttpClient getOkHttpClient();
     * - OkHttpClient isOkHttpClient();
     * ...
     */
    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient provideOkHttpClient2() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    /**
     * When we use modules = ApplicationModule.class
     *
     * => provideRxJavaCallAdapterFactory() means that provide object RxJavaCallAdapterFactory
     * => In AppComponent: We can declare somethings about that as:
     * - RxJavaCallAdapterFactory getRxJavaCallAdapterFactory();
     * - RxJavaCallAdapterFactory isRxJavaCallAdapterFactory();
     * ...
     */
    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    /**
     * When we use modules = ApplicationModule.class
     *
     * => provideRetrofit() means that provide object Retrofit
     * => In AppComponent: We can declare somethings about that as:
     * - Retrofit getRetrofit();
     * - Retrofit isRetrofit();
     * ...
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
    }

    /**
     * When we use dependencies = ApplicationComponent.class
     *
     * Implement one or more method from parent interface.
     * For example:
     * - OkHttpClient getOkHttpClient();
     * - Retrofit isRetrofit();
     * - RxJavaCallAdapterFactory isRxJavaCallAdapterFactory();
     * - GsonConverterFactory getGsonConverterFactory();
     */

    /**
     * Provide Context object
     */
    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

}
