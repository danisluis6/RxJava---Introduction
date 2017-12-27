package com.example.lorence.rxtutorial.di.components;

import com.example.lorence.rxtutorial.di.module.CakeModule;
import com.example.lorence.rxtutorial.di.scope.PerActivity;
import com.example.lorence.rxtutorial.module.home.MainActivity;

import dagger.Component;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/25/2017
 */

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);

}
