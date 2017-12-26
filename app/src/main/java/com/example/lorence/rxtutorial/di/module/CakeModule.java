package com.example.lorence.rxtutorial.di.module;

import com.example.lorence.rxtutorial.di.scope.PerActivity;
import com.example.lorence.rxtutorial.data.api.CakeApiService;
import com.example.lorence.rxtutorial.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/26/2017
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }

}
