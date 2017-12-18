package com.example.lorence.piggycoin.activities.home;

import android.content.Context;

import com.example.lorence.piggycoin.data.room.entities.Ticket;

import java.util.List;

/**
 *
 * Created by lorence on 13/11/2017.
 */

public class HomePresenter implements IHomePresenter {

    private IHomeView mHomeView;

    private final IHomeModel mHomeModel;

    HomePresenter(Context context) {
        mHomeModel = new HomeModel(context);
        mHomeModel.attachView(this);
    }

    @Override
    public List<Ticket> getListOfTickers() {
        return null;
    }

    @Override
    public void attachView(IHomeView homeView) {
        this.mHomeView = homeView;
    }
}
