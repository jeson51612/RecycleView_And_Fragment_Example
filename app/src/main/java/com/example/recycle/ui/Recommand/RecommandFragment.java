package com.example.recycle.ui.Recommand;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.recycle.data.api.Servicey;
import com.example.recycle.data.api.StockApi;
import com.example.recycle.data.response.StockResponse;
import com.example.recycle.databinding.FragmentRecommandBinding;
import com.example.recycle.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecommandFragment extends Fragment {
    private FragmentRecommandBinding binding;
    private Button btn;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRecommandBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        btn=root.findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.setBackgroundColor(Color.GRAY);
                GetRetrofitResponse(root);
            }



        });
        return root;

    }
    private void GetRetrofitResponse(View root) {
        StockApi stockApi = Servicey.getStockApi();


        Call<List<StockResponse>> responseCall=stockApi.CallStock();
        //是兩層巢狀json,所以要用List去排列矩陣行的List array

        responseCall.enqueue(new Callback<List<StockResponse>>() {

            @Override
            public void onResponse(Call<List<StockResponse>> call, Response<List<StockResponse>> response) {
               if(response.code()==200){
//                   Log.v("Tag","the response: "+response.body().toString());
                   for(StockResponse stocks:response.body()){
                       Log.v("Tag","the response: "+stocks.Code);
                   }

               }
                root.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onFailure(Call<List<StockResponse>> call, Throwable t) {
                Log.e("Tag", "Request failed: " + t.getMessage());
            }
        });



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
