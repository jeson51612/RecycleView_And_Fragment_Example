package com.example.recycle.data.response;


import com.example.recycle.data.model.StockModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//This class is for multi stock request
public class StockResponse {
    // 1- Finding the Stock Object
//    @Expose()
//    public List<StockModel> stocks;
//    //資料量過大 越多參數找越久(兩參數約十秒)
    @SerializedName("Code")
    public String Code;

    @SerializedName("Name")
    private String Name;

//    public List<StockModel> getStocks(){
//        return stocks;
//    }

}

