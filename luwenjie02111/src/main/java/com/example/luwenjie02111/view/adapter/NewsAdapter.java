package com.example.luwenjie02111.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.luwenjie02111.R;
import com.example.luwenjie02111.model.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;



public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<NewsBean.ResultsBean> mList = new ArrayList<>();

    public NewsAdapter(Context context){
        this.mContext = context;
    }

    public void setData(List<NewsBean.ResultsBean> list,boolean isRefreshing){
        if (list!=null){
            if(isRefreshing) {
                mList.clear();
            }
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        if(mList.get(i)!=null){
            viewHolder.name.setText(i+"    "+mList.get(i).getTitle()+" ");
            Glide.with(mContext).load(mList.get(i).getUrl()).into(viewHolder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public  TextView name;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
