package com.example.lorence.piggycoin.preferences;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.example.lorence.piggycoin.R;

/**
 * Created by lorence on 19/12/2017.
 *
 * @Description: https://github.com/aosp-mirror/platform_frameworks_base/blob/master/core/java/android/app/ProgressDialog.java
 */

@SuppressWarnings("ALL")
public class ProgressDialog extends Dialog {

    /**
     * Activity context.
     */
    private final Activity mActivity;

    /**
     * Initiate dialog.
     *
     * @param context activity context
     */
    public ProgressDialog(Activity context) {
        super(context);
        mActivity = context;
        init(context);
    }

    /**
     * Initiate the views.
     */

    private void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.progressbar_ticker);
        setCancelable(false);
    }

    @Override
    public void show() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.dismiss();
        }
    }
}
