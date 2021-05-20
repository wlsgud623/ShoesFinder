package com.example.shoesfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {

    Context context;
    ArrayList<shoes> list;
    LayoutInflater inflater;

    public SearchAdapter(Context context){
        this.context = context;
        this.list = new ArrayList<shoes>();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public void addItem(shoes shoe){
        list.add(shoe);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SearchViewHolder viewHolder;

        if(view == null){
            view = inflater.inflate(R.layout.search_item, viewGroup, false);
            viewHolder = new SearchViewHolder();
            viewHolder.shoes_image = view.findViewById(R.id.search_image);
            viewHolder.shoes_name = view.findViewById(R.id.search_name);
            viewHolder.shoese_price = view.findViewById(R.id.search_price);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (SearchViewHolder) view.getTag();
        }
        shoes shoe = list.get(i);
        String name =  shoe.getName();
        int price = shoe.getPrice();
        String url = shoe.getUrl();

        viewHolder.shoes_name.setText(name);
        viewHolder.shoese_price.setText(Integer.toString(price) + " ￦");
        Glide.with(context).load(url).override(50,50).into(viewHolder.shoes_image);
        //Picasso.get().load(url).resize(120,120).centerCrop().into(viewHolder.shoes_image);

        return view;
    }

    public void empty(){
        list = new ArrayList<shoes>();
    }

    public class SearchViewHolder{
        public ImageView shoes_image;
        public TextView shoes_name, shoese_price;
    }
}
