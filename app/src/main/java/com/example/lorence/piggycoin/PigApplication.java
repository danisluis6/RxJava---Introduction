package com.example.lorence.piggycoin;

import android.app.Application;

import com.example.lorence.piggycoin.data.retrofit.IraMovieWebAPIs;

/**
 * Created by lorence on 18/12/2017.
 */

public class PigApplication extends Application {

    /**
     * Apply singleton in Android
     */
    private static PigApplication sInstance;

    /**
     * EzFaxingWebAPIs
     */
    private IraMovieWebAPIs mIraMoviesWebAPIs;

    public static synchronized PigApplication getInstance() {
        if (sInstance == null) {
            sInstance = new PigApplication();
        }
        return sInstance;
    }

    public IraMovieWebAPIs getEzFaxingWebAPIs() {
        if (mIraMoviesWebAPIs == null) {
            mIraMoviesWebAPIs = IraMovieWebAPIs.Factory.create(sInstance);
        }
        return mIraMoviesWebAPIs;
    }

}
