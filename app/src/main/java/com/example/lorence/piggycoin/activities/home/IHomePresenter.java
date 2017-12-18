package com.example.lorence.piggycoin.activities.home;

import com.example.lorence.piggycoin.data.room.entities.Ticket;
import com.example.lorence.piggycoin.interfaces.IBasePresenter;

import java.util.List;

/*
 * Created by lorence on 13/11/2017.
 */

public interface IHomePresenter extends IBasePresenter<IHomeView> {

    List<Ticket> getListOfTickers();
}
