package com.example.lorence.learnrxandroid;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/*
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

/**
 * @Run: https://github.com/ReactiveX/RxAndroid#binaries
 * Find the lastest version from here
 * @Run: https://medium.com/@kevalpatel2106/code-your-next-android-app-using-rxjava-d1db30ac9fcc
 * Start with RxJava
 * @Run; https://www.youtube.com/watch?v=mcVXDXt1s3E
 * I'm done
 * @Run:
 */
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
