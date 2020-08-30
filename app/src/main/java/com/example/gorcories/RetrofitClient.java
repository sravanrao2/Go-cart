package com.example.gorcories;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * This RetrofitClient class for used for connection.
 *
 */
public class RetrofitClient {


    public static final String BASE_URL = "http://10.0.2.2:3000";
    public static Retrofit retrofit = null;

    /**
     *
     * @return retrofit instance with an connection else return the error if the connection is unsuccessful.
     */
    public static Retrofit getApiClient() {

        if (retrofit == null) {


            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
