package com.example.lorence.piggycoin.data.room;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 *
 * Created by lorence on 18/12/2017.
 */

@SuppressWarnings("ALL")
public class SessionManager {

    /**
     * Shared preferences file name
     */
    private static final String PREF_NAME = "iraMovies_sharedPref";
    /**
     * Shared preferences Instance
     */
    private static SessionManager instance;
    /**
     * Shared Preferences
     */
    private final SharedPreferences pref;
    /**
     * Editor for shared preferences
     */
    private final Editor editor;

    /**
     * Constructor
     *
     * @param context the context
     */
    private SessionManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.apply();
    }

    public static SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context);
        }
        return instance;
    }

}
