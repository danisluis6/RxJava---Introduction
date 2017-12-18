package com.example.lorence.learnrxandroid;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

/**
 * @Run: https://github.com/ReactiveX/RxAndroid#binaries
 * Find the lastest version from here
 *
 * @Run: https://medium.com/@kevalpatel2106/code-your-next-android-app-using-rxjava-d1db30ac9fcc
 * Start with RxJava
 *
 * @Run; https://www.youtube.com/watch?v=mcVXDXt1s3E
 * I'm done
 *
 * @Run:
 */
@SuppressWarnings("ALL")
public class DemoActivity extends AppCompatActivity {

  private Subscription mSubscription;
  private Observable<String> observable;
  private Observer<String> observer;

  /**
   * Some older devices needs a small delay between UI widget updates
   * and a change of the status and navigation bar.
   */
  private static final int UI_ANIMATION_DELAY = 300;
  private final Handler mHideHandler = new Handler();
  private TextView mContentView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_demo);
    mContentView = (TextView) findViewById(R.id.fullscreen_content);
    /**
     * Sometimes we want to refine specific event only to be emitted by observable
     * Solution in here: Using another operator called filter()
     */
//    observable = Observable
//        .just(1, 2, 3, 4, 5)
//        .filter(new Func1<Integer, Boolean>() {
//          @Override
//          public Boolean call(Integer integer) {
//            //check if the number is odd? If the number is odd return true, to emmit that object.
//            return integer % 2 != 0;
//          }
//        });
    observable = Observable.just("Hello from RxAndroid,...");

    /*
     * In RxJava there are three callbacks you are going to receive in an observer.
     *
      * onNext() : This method will be called when there is any new data emitted by the observer.
      * The object that is emitted by the observable can be found in argument parameters of this callback.
      *
      * onError() : You will receive this callback whenever there is any error occurred on observable.
      * (After all the world is not perfect.)
      *
      * onComplete() : Whenever observable is done with emitting the data streams, you will receive this callback.
      * This indicates that there is no more data to emit.
     */

    observer = new Observer<String>() {
      @Override
      public void onCompleted() {
      }

      @Override
      public void onError(Throwable e) {
      }

      @Override
      public void onNext(String s) {
        mContentView.setText(s);
      }
    };
  }

  public void subscribeNow(View v) {
    /**
     * Here, onCall() is equivalent to onNext() in our first approach.
     */
    mSubscription = observable
        .subscribeOn(Schedulers.io())               // Observable will run on IO thread.
        .observeOn(AndroidSchedulers.mainThread())  // Observer will run on main thread.
        .subscribe(observer);                       // subscribe the observer
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    // Unsubscribe both subscriptions.
    mSubscription.unsubscribe();
  }
}
