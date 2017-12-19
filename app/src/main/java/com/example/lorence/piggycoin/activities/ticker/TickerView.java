package com.example.lorence.piggycoin.activities.ticker;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lorence.piggycoin.R;
import com.example.lorence.piggycoin.activities.BaseView;
import com.example.lorence.piggycoin.adapters.TickerAdapter;
import com.example.lorence.piggycoin.data.retrofit.response.Ticker;
import com.example.lorence.piggycoin.preferences.ProgressDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
public class TickerView extends BaseView implements ITickerView {

    private Subscription mSubscription;
    private Observable<String> mObservable;
    private Observer<String> mObserver;

    private TickerPresenter mHomePresenter;
    private ProgressDialog mProgressDialog;

    @BindView(R.id.rcvTickers)
    public RecyclerView rcvTickers;

    private TickerAdapter mTickerAdapter;


    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    @Override
    public int getLayoutResId() {
        return R.layout.activity_ticker;
    }



    @Override
    public void activityCreated() {
        mHomePresenter = new TickerPresenter(mContext);
        mHomePresenter.attachView(this);
        mProgressDialog = new ProgressDialog(this);

        mHomePresenter.getListOfTickers();

        initAttributes();

    }

    private void initAttributes() {
        if (rcvTickers != null) {
            rcvTickers.setHasFixedSize(true);
        }
        mTickerAdapter = new TickerAdapter(mContext, new ArrayList<Ticker>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        rcvTickers.setLayoutManager(mLayoutManager);
        rcvTickers.setAdapter(mTickerAdapter);
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.hide();
    }

    @Override
    public void loadMessageFail(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadTickerSuccess(List<Ticker> grouTickers) {
        mTickerAdapter.setTickers(grouTickers);
    }

}
