package com.example.lorence.piggycoin.activities.home;

import android.content.Context;

import com.example.lorence.piggycoin.data.room.entities.Ticket;

import java.util.List;

/**
 *
 * Created by lorence on 18/12/2017.
 */

@SuppressWarnings("ALL")
public class HomeModel implements IHomeModel {

    private final Context mContext;
    private IHomePresenter mHomePresenter;

    HomeModel(Context context) {
        this.mContext = context;
    }

    @Override
    public void attachView(IHomePresenter homePresenter) {
        mHomePresenter = homePresenter;
    }

    @Override
    public List<Ticket> getListOfTickers() {

        return null;
    }
}
