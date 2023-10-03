package com.example.recycle.ui.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle.MyAdapter;
import com.example.recycle.R;
import com.example.recycle.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class homefragment extends Fragment {
    private FragmentHomeBinding binding;
    private ArrayList<String> mData=new ArrayList<>();
    private RecyclerView recycler_view;
    private MyAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //準備資料,顯示四個主題區
        mData.clear();
        mData.add("股票搜尋");
        mData.add("推薦項目");
        mData.add("股市分析");
        mData.add("智能選股");

        //連結元件
        recycler_view=(RecyclerView) root.findViewById(R.id.recycle_view);
        //設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //設置隔線
        recycler_view.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        //將資料交給adapter
        adapter=new MyAdapter(mData);
        //設置adapter給recycler_view
        recycler_view.setAdapter(adapter);

        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
