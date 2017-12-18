package com.example.lorence.learnrxandroid;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/*
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

/**
 * @Run: https://github.com/ReactiveX/RxAndroid#binaries
 * Find the lastest version from here
 *
 * @Run:
 *
 */
@SuppressWarnings("ALL")
public class DemoActivity extends AppCompatActivity {

  /**
   * Whether or not the system UI should be auto-hidden after
   * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
   */
  private static final boolean AUTO_HIDE = true;

  /**
   * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
   * user interaction before hiding the system UI.
   */
  private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

  private Subscription mSubscription;

  /**
   * Some older devices needs a small delay between UI widget updates
   * and a change of the status and navigation bar.
   */
  private static final int UI_ANIMATION_DELAY = 300;
  private final Handler mHideHandler = new Handler();
  private View mContentView;
  private final Runnable mHidePart2Runnable = new Runnable() {
    @SuppressLint("InlinedApi")
    @Override
    public void run() {
      // Delayed removal of status and navigation bar

      // Note that some of these constants are new as of API 16 (Jelly Bean)
      // and API 19 (KitKat). It is safe to use them, as they are inlined
      // at compile-time and do nothing on earlier devices.
      mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
  };
  private View mControlsView;
  private final Runnable mShowPart2Runnable = new Runnable() {
    @Override
    public void run() {
      // Delayed display of UI elements
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null) {
        actionBar.show();
      }
      mControlsView.setVisibility(View.VISIBLE);
    }
  };
  private boolean mVisible;
  private final Runnable mHideRunnable = new Runnable() {
    @Override
    public void run() {
      hide();
    }
  };
  /**
   * Touch listener to use for in-layout UI controls to delay hiding the
   * system UI. This is to prevent the jarring behavior of controls going away
   * while interacting with activity UI.
   */
  private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
      if (AUTO_HIDE) {
        delayedHide(AUTO_HIDE_DELAY_MILLIS);
      }
      return false;
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_demo);

    mVisible = true;
    mControlsView = findViewById(R.id.fullscreen_content_controls);
    mContentView = findViewById(R.id.fullscreen_content);

    // Set up the user interaction to manually show or hide the system UI.
    mContentView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        toggle();
      }
    });

    // Upon interacting with UI controls, delay any scheduled hide()
    // operations to prevent the jarring behavior of controls going away
    // while interacting with the UI.
    findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

    // Create an Observable that emits 1 to 5
    Observable.just(1, 2, 3, 4, 5);

    // Sometimes we want to refine specific event only to be emitted by observable
    // Solution in here: Using another operator called filter()
    Observable<Integer> observable = Observable
        .just(1, 2, 3, 4, 5)
        .filter(new Func1<Integer, Boolean>() {
          @Override
          public Boolean call(Integer integer) {
            //check if the number is odd? If the number is odd return true, to emmit that object.
            return integer % 2 != 0;
          }
        });

    // Create observer
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

    Observer<Integer> observer = new Observer<Integer>() {
      @Override
      public void onCompleted() {
        System.out.println("All data emitted.");
      }

      @Override
      public void onError(Throwable e) {
        System.out.println("Error received: " + e.getMessage());
      }

      @Override
      public void onNext(Integer integer) {
        System.out.println("New data received: " + integer);
      }
    };

    /**
     * In many cases you don’t care about onCompleted() or onError(). So instead of using Observer<T>
     * we can use a simpler class to define what to do during onNext() using Action1 class.
     */

    Action1<Integer> onNextAction = new Action1<Integer>() {
      @Override
      public void call(Integer s) { // This is equivalent to onNext()
        System.out.println(s);
      }
    };

    /**
     * Here, onCall() is equivalent to onNext() in our first approach.
     */
    mSubscription = observable
        .subscribeOn(Schedulers.io())               // Observable will run on IO thread.
        .observeOn(AndroidSchedulers.mainThread())  // Observer will run on main thread.
        .subscribe(observer);                       // subscribe the observer

    /*
     * Unsubscribe:
      *
      * In android this is essential that you call unsubscribe in onDesrtoy() of your activity/fragment to
      * release the connection between observer and observable. Otherwise, it may call memory leak.
     */
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    // Trigger the initial hide() shortly after the activity has been
    // created, to briefly hint to the user that UI controls
    // are available.
    delayedHide(100);
  }

  private void toggle() {
    if (mVisible) {
      hide();
    } else {
      show();
    }
  }

  private void hide() {
    // Hide UI first
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.hide();
    }
    mControlsView.setVisibility(View.GONE);
    mVisible = false;

    // Schedule a runnable to remove the status and navigation bar after a delay
    mHideHandler.removeCallbacks(mShowPart2Runnable);
    mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
  }

  @SuppressLint("InlinedApi")
  private void show() {
    // Show the system bar
    mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    mVisible = true;

    // Schedule a runnable to display UI elements after a delay
    mHideHandler.removeCallbacks(mHidePart2Runnable);
    mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
  }

  /**
   * Schedules a call to hide() in [delay] milliseconds, canceling any
   * previously scheduled calls.
   */
  private void delayedHide(int delayMillis) {
    mHideHandler.removeCallbacks(mHideRunnable);
    mHideHandler.postDelayed(mHideRunnable, delayMillis);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // Unsubscribe both subscriptions.
    mSubscription.unsubscribe();
  }
}
