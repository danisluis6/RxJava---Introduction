package com.example.lorence.piggycoin.activities.home;

import com.example.lorence.piggycoin.data.retrofit.response.Ticker;
import com.example.lorence.piggycoin.interfaces.IBasePresenter;

import java.util.List;

/*
 * Created by lorence on 13/11/2017.
 */

public interface ITickerPresenter extends IBasePresenter<ITickerView> {

    void getListOfTickers();

    void loadTickerSuccess(List<Ticker> grouTickers);

    void loadMessageFail(String message);
}
