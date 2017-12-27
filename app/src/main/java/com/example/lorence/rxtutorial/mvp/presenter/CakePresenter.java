package com.example.lorence.rxtutorial.mvp.presenter;

import android.util.Log;

import com.example.lorence.rxtutorial.base.BasePresenter;
import com.example.lorence.rxtutorial.data.api.CakeApiService;
import com.example.lorence.rxtutorial.mapper.CakeMapper;
import com.example.lorence.rxtutorial.data.model.Cake;
import com.example.lorence.rxtutorial.data.api.response.CakesResponse;
import com.example.lorence.rxtutorial.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 * <p>
 * With MVP: this of case and not the same with this.
 * Let see it
 * <p>
 * Analyze 1:
 * MoviePresenter => attachView(IMoviesView)
 * MovieModel     => attachView(IMoviePresenter)
 * <p>
 * Analyze 2:
 * Using interface to inject method to this class
 * MoviePresenter => IMoviePresenter
 * MovieModel     => IMovieModel
 * <p>
 * Analyze 3:
 * extends from Interface
 * IMoviePresenter extends LorenceInterface
 * IMovieModel extends LorenceInterface
 * <p>
 * => Create method attachView(? view) => ? is V(one of type param)
 * => We need pass argument for this method.
 * At position method new method() <V> => Done now
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

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    /**
     * Involve with IraMovies. We will have the same structure with Dagger2
     * => We will have template_2
     * MVP
     * => CakeModule -/- CakeMapper
     */
    @Inject protected CakeApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;

    @Inject
    public CakePresenter() {
        Log.i("TAG", "CakePresenter -> CakePresenter(Constructor)");
    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakesResponse> cakesResponseObservable = mApiService.getCakes();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes " + e.getMessage());
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(cakesResponse);
        getView().onCakeLoaded(cakes);
    }
}
