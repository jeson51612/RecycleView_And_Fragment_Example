package com.example.recycle.data.model;

import static java.lang.System.in;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class StockModel implements Parcelable {
    //Model Class for our stock
    private String Code;
    private String Name;
    private float HighestPrice;
    private float LowestPrice;
    private float WeightedAvgPriceAB;
    private int Transaction;
    private int TradeValueA;
    private int TradeVolumeB;
    private float TurnoverRatio;

    //Constructor

    public StockModel(String code, String name, float highestPrice, float lowestPrice, float weightedAvgPriceAB, int transaction, int tradeValueA, int tradeVolumeB, float turnoverRatio) {
        Code = code;
        Name = name;
        HighestPrice = highestPrice;
        LowestPrice = lowestPrice;
        WeightedAvgPriceAB = weightedAvgPriceAB;
        Transaction = transaction;
        TradeValueA = tradeValueA;
        TradeVolumeB = tradeVolumeB;
        TurnoverRatio = turnoverRatio;
    }
    public static final Creator<StockModel> CREATOR=new Creator<StockModel>() {
        @Override
        public StockModel createFromParcel(Parcel parcel) {
            return null;
        }

        @Override
        public StockModel[] newArray(int i) {
            return new StockModel[0];
        }
    };

    //Getters

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public float getHighestPrice() {
        return HighestPrice;
    }

    public float getLowestPrice() {
        return LowestPrice;
    }

    public float getWeightedAvgPriceAB() {
        return WeightedAvgPriceAB;
    }

    public int getTransaction() {
        return Transaction;
    }

    public int getTradeValueA() {
        return TradeValueA;
    }

    public int getTradeVolumeB() {
        return TradeVolumeB;
    }

    public float getTurnoverRatio() {
        return TurnoverRatio;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Code);
        parcel.writeString(Name);
        parcel.writeFloat(HighestPrice);
        parcel.writeFloat(LowestPrice);
        parcel.writeFloat(WeightedAvgPriceAB);
        parcel.writeInt(Transaction);
        parcel.writeInt(TradeValueA);
        parcel.writeInt(TradeVolumeB);
        parcel.writeFloat(TurnoverRatio);
    }
}
