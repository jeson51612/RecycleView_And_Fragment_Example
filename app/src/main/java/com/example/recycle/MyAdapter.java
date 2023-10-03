package com.example.recycle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;
    private final List<Integer> drawables = Arrays.asList(
            R.drawable.bank1,
            R.drawable.bank2,
            R.drawable.money1,
            R.drawable.money2);


    public MyAdapter(List<String> data){
        mData=data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //連結項目佈局檔list_item
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //設置txtItem要顯示的內容
        holder.txtItem.setText(mData.get(position));
        holder.imageView.setImageDrawable(ResourcesCompat.getDrawable(holder.imageView.getResources(),
                drawables.get(position),
                null));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        //宣告元件
        private TextView txtItem;

        private ImageView imageView;




        ViewHolder(View itemview){
            super(itemview);
            txtItem=(TextView) itemview.findViewById(R.id.txtItem);
            imageView=(ImageView) itemview.findViewById(R.id.listimage);

            //點擊項目
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Snackbar.make(view, "Click " + getBindingAdapterPosition(), Snackbar.LENGTH_SHORT).show();
//                    Toast.makeText(view.getContext(),"click"+getBindingAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
