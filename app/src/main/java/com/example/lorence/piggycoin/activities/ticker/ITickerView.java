package com.example.lorence.piggycoin.activities.ticker;

import com.example.lorence.piggycoin.data.retrofit.response.Ticker;

import java.util.List;

/**
 * Created by lorence on 18/12/2017.
 *
 */

// TODO
public interface ITickerView {

    void showProgressDialog();

    void hideProgressDialog();

    void loadMessageFail(String message);

    void loadTickerSuccess(List<Ticker> grouTickers);
}
