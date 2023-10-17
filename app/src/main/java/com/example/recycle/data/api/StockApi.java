package com.example.recycle.data.api;

import com.example.recycle.data.response.StockResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StockApi {

    //Call for Stocks
//    @GET(".")
//    Call<StockResponse> CallStock(
//    @Query("v1/exchangeReport/FMSRFK_ALL") String FMSRFK_ALL
//    );
    @GET("v1/exchangeReport/FMSRFK_ALL")
    Call<List<StockResponse>> CallStock(

    );

}
