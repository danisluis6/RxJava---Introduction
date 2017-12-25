package com.example.lorence.rxtutorial.di.module;

import com.example.lorence.rxtutorial.di.scope.PerActivity;
import com.example.lorence.rxtutorial.api.CakeApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by lorence on 25/12/2017.
 */

@Module
public class CakeModule {

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

}
