package com.example.lorence.piggycoin;

import android.app.Application;

import com.example.lorence.piggycoin.data.retrofit.PigCoinWebAPIs;

/**
 * Created by lorence on 18/12/2017.
 *
 */

@SuppressWarnings("ALL")
public class PigCoinApplication extends Application {

    /**
     * Apply singleton in Android
     */
    private static PigCoinApplication sInstance;

    /**
     * EzFaxingWebAPIs
     */
    private PigCoinWebAPIs mIraMoviesWebAPIs;

    public static synchronized PigCoinApplication getInstance() {
        if (sInstance == null) {
            sInstance = new PigCoinApplication();
        }
        return sInstance;
    }

    public PigCoinWebAPIs getEzFaxingWebAPIs() {
        if (mIraMoviesWebAPIs == null) {
            mIraMoviesWebAPIs = PigCoinWebAPIs.Factory.create(sInstance);
        }
        return mIraMoviesWebAPIs;
    }

}
