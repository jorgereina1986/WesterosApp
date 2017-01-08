package com.jorgereina.westerosapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jorgereina.westerosapp.R;
import com.jorgereina.westerosapp.models.Response;
import com.jorgereina.westerosapp.service.WesterosApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://starlord.hackerearth.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkCall();
    }

    private void networkCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WesterosApi service = retrofit.create(WesterosApi.class);

        Call<List<Response>> westeros = service.listWesteros();

        westeros.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                Log.d("xxcx", response.body().get(0).getAttacker1());
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });
    }




}
