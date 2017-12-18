package com.example.lorence.piggycoin.data.retrofit;

import android.content.Context;

import com.example.lorence.piggycoin.data.retrofit.response.Ticket;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 *
 * Created by lorence on 18/12/2017.
 */

@SuppressWarnings("ALL")
public class IraMovieWebAPIs {

    @GET(IraMovieInfoAPIs.Categories.Ticket)
    Call<Ticket> getTickets();

    public static class Factory {
        public static IraMovieWebAPIs create(Context context) {
            String baseUrl = IraMovieInfoAPIs.BASE_URL;
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
            return retrofit.create(IraMovieWebAPIs.class);
        }
    }

}
