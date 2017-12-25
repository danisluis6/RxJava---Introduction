package com.example.lorence.rxtutorial.mvp.presenter;

import com.example.lorence.rxtutorial.base.BasePresenter;
import com.example.lorence.rxtutorial.mvp.view.MainView;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/25/2017
 */

/**
 * With MVP: this of case and not the same with this.
 * Let see it
 *
 * Analyze 1:
 * MoviePresenter => attachView(IMoviesView)
 * MovieModel     => attachView(IMoviePresenter)
 *
 * Analyze 2:
 * Using interface to inject method to this class
 * MoviePresenter => IMoviePresenter
 * MovieModel     => IMovieModel
 *
 * Analyze 3:
 * extends from Interface
 *  IMoviePresenter extends LorenceInterface
 *  IMovieModel extends LorenceInterface
 *
 *  => Create method attachView(? view) => ? is V(one of type param)
 *  => We need pass argument for this method.
 *  At position method new method() <V> => Done now
 *
 */

/**
 * Back to this case
 */

public class CakePresenter extends BasePresenter<MainView>{
}
