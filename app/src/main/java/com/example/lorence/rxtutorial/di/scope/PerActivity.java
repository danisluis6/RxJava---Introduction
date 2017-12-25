package com.example.lorence.rxtutorial.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
