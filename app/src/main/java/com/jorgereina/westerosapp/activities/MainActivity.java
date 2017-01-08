package com.jorgereina.westerosapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jorgereina.westerosapp.R;
import com.jorgereina.westerosapp.adapters.WesterosAdapter;
import com.jorgereina.westerosapp.models.Westero;
import com.jorgereina.westerosapp.service.WesterosApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://starlord.hackerearth.com";

    private RecyclerView recyclerView;
    private List<Westero> westeroList;
    private WesterosAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        networkCall();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.westeros_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        westeroList = new ArrayList<>();
        adapter = new WesterosAdapter(this, westeroList);
        recyclerView.setAdapter(adapter);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void networkCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WesterosApi service = retrofit.create(WesterosApi.class);

        Call<List<Westero>> call = service.listWesteros();

        call.enqueue(new Callback<List<Westero>>() {
            @Override
            public void onResponse(Call<List<Westero>> call, retrofit2.Response<List<Westero>> response) {
                Log.d("xxcx", response.body().get(0).getName());

                westeroList.clear();
                westeroList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Westero>> call, Throwable t) {

            }
        });
    }




}
