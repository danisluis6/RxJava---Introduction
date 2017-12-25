package com.example.lorence.rxtutorial.base;

import com.example.lorence.rxtutorial.mvp.view.BaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/25/2017
 */


/**
 * Explanation this technical:
 * Assumes:
 * MovieHome => IMovieView
 * HomeView => IHomeView
 * FavoriteView => IFavoriteView
 *
 * Problem in here: You will always use this method subscribe().
 * => Create base Interface for that.
 * (IMovieView) -> analyze -> (IMovieView extends BaseView) => receive IMovieView
 * (IFavoriteView) -> analyze -> (IFavoriteView extends BaseView) => receive IFavoriteView
 *
 * How to pass argument
 * Way 1: BasePresenter<V>
 * Way 2: BasePresenter<V extends BaseView>
 * @param <V>
 */
public class BasePresenter<V extends BaseView> {

    @Inject protected  V mView;

    protected V getView() {
        return mView;
    }

    protected <I>void subscribe(Observable<I> observable, Observer<I> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
