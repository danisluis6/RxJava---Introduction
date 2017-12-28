package com.example.lorence.rxtutorial.utilities;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Utils {

    private static long sLastClickTime = 0;

    public static boolean isDoubleClick() {
        long clickTime = System.currentTimeMillis();
        if (clickTime - sLastClickTime < Constants.DOUBLE_CLICK_TIME_DELTA) {
            sLastClickTime = clickTime;
            return true;
        }
        sLastClickTime = clickTime;
        return false;
    }

    public static boolean isInternetOn(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static void clearFocusOnSearchView(View view) {
        if (view instanceof EditText) {
            if (view.isFocused()) {
                view.clearFocus();
            }
        }
    }

    public static boolean isVisibleSoftKeyBoardAndroid(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.isAcceptingText();
    }

    // Close keyboard in android
    public static void dimissKeyBoard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
