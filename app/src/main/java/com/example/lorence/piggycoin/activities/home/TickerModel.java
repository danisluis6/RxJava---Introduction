package com.example.lorence.piggycoin.activities.home;

import android.content.Context;
import android.widget.Toast;

import com.example.lorence.piggycoin.PigCoinApplication;
import com.example.lorence.piggycoin.data.retrofit.PigCoinWebAPIs;
import com.example.lorence.piggycoin.data.retrofit.response.Ticker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by lorence on 18/12/2017.
 */

@SuppressWarnings("ALL")
public class TickerModel implements ITickerModel {

    private final Context mContext;
    private ITickerPresenter mHomePresenter;
    /**
     * PigCoinWebAPIs
     */
    private PigCoinWebAPIs mApiService;

    TickerModel(Context context) {
        mContext = context;
        mApiService = PigCoinApplication.getInstance().getEzFaxingWebAPIs();
    }

    @Override
    public void attachView(ITickerPresenter homePresenter) {
        mHomePresenter = homePresenter;
    }

    @Override
    public void getListOfTickers() {
        Call<List<Ticker>> call = mApiService.getTickers();
        call.enqueue(new Callback<List<Ticker>>() {
            @Override
            public void onResponse(Call<List<Ticker>> call, Response<List<Ticker>> response) {
                if (response.isSuccessful()) {
                    List<Ticker> grouTickers = response.body();
                    mHomePresenter.loadTickerSuccess(grouTickers);
                }
            }

            @Override
            public void onFailure(Call<List<Ticker>> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT);
                mHomePresenter.loadMessageFail(t.getMessage());
            }
        });
    }
}
