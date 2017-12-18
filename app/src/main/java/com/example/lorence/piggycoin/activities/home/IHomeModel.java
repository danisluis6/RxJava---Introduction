package com.example.lorence.piggycoin.activities.home;

import com.example.lorence.piggycoin.data.room.entities.Ticket;
import com.example.lorence.piggycoin.interfaces.IBasePresenter;

import java.util.List;

/*
 * Created by lorence on 13/11/2017.
 */

// TODO
public interface IHomeModel extends IBasePresenter<IHomePresenter> {

    List<Ticket> getListOfTickers();
}
