package com.example.lorence.piggycoin.activities.home;

import android.os.Bundle;

import com.example.lorence.piggycoin.R;
import com.example.lorence.piggycoin.activities.BaseView;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/*
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

/**
 * @Run: https://github.com/ReactiveX/RxAndroid#binaries Find the lastest version from here
 * Get version RxJava
 * @Run: https://medium.com/@kevalpatel2106/code-your-next-android-app-using-rxjava-d1db30ac9fcc
 * Start with RxJava
 * @Run; https://www.youtube.com/watch?v=mcVXDXt1s3E
 * I'm done
 */
@SuppressWarnings("ALL")
public class HomeView extends BaseView implements IHomeView {

    private Subscription mSubscription;
    private Observable<String> mObservable;
    private Observer<String> mObserver;

    private HomePresenter mHomePresenter;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    @Override
    public int getLayoutResId() {
        return R.layout.activity_home;
    }



    @Override
    public void activityCreated() {
        mHomePresenter = new HomePresenter(mContext);
        mHomePresenter.attachView(this);

    }

    @Override
    public void showProgressDialog() {
        // TODO
//        ProgressDialog progress=new ProgressDialog(this);
//        progress.setContentView(R.layout.progressbar_ticket);
//        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD4D9D0")));
//        progress.setIndeterminate(false);
//        progress.setCancelable(false);
//        progress.show();
    }

    @Override
    public void hideProgressDialog() {

    }

}
