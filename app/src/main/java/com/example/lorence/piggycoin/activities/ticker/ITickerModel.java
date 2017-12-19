package com.example.lorence.piggycoin.activities.ticker;

import com.example.lorence.piggycoin.interfaces.IBasePresenter;

/*
 * Created by lorence on 13/11/2017.
 */

public interface ITickerModel extends IBasePresenter<ITickerPresenter> {

    void getListOfTickers();
}
