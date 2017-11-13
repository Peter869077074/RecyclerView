package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13/013.
 */

public  class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mfruitlist;

    public FruitAdapter(List<Fruit>fruitList){
        mfruitlist = fruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView fruitImage;
        TextView fruitname;

        public ViewHolder(View view){
            super(view);
            fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            fruitname = (TextView)view.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mfruitlist.get(position);
                Toast.makeText(view.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mfruitlist.get(position);
        holder.fruitname.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getImageId());

    }

    @Override
    public int getItemCount() {
        return mfruitlist.size();
    }
}
