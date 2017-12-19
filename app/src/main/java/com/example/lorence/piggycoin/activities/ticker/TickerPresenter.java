package com.example.lorence.piggycoin.activities.ticker;

import android.content.Context;

import com.example.lorence.piggycoin.data.retrofit.response.Ticker;

import java.util.List;

/**
 *
 * Created by lorence on 13/11/2017.
 */

@SuppressWarnings("ALL")
public class TickerPresenter implements ITickerPresenter {

    private ITickerView mHomeView;

    private final ITickerModel mHomeModel;

    TickerPresenter(Context context) {
        mHomeModel = new TickerModel(context);
        mHomeModel.attachView(this);
    }

    @Override
    public void getListOfTickers() {
        if (mHomeView != null) {
            mHomeView.showProgressDialog();
            mHomeModel.getListOfTickers();
        }
    }

    @Override
    public void attachView(ITickerView homeView) {
        mHomeView = homeView;
    }

    @Override
    public void loadTickerSuccess(List<Ticker> grouTickers) {
        if (mHomeView != null) {
            mHomeView.hideProgressDialog();
            mHomeView.loadTickerSuccess(grouTickers);
        }
    }

    @Override
    public void loadMessageFail(String message) {
        if (mHomeView != null) {
            mHomeView.hideProgressDialog();
            mHomeView.loadMessageFail(message);
        }
    }
}
