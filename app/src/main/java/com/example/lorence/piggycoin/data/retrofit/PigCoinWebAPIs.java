package com.example.lorence.piggycoin.data.retrofit;

import android.content.Context;

import com.example.lorence.piggycoin.data.retrofit.response.Ticker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 *
 * Created by lorence on 18/12/2017.
 */

@SuppressWarnings("ALL")
public interface PigCoinWebAPIs {

    @GET(PigCoinInfoAPIs.Categories.Ticker)
    Call<List<Ticker>> getTickers();

    public static class Factory {
        public static PigCoinWebAPIs create(Context context) {
            String baseUrl = PigCoinInfoAPIs.BASE_URL;
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            Retrofit retrofit = new Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(PigCoinWebAPIs.class);
        }
    }

}
