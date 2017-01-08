package com.jorgereina.westerosapp.service;

import com.jorgereina.westerosapp.models.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WesterosApi {

    //http://starlord.hackerearth.com/gotjson
    @GET("/gotjson")
    Call<List<Response>> listWesteros();
}
