package com.example.wallpaper_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {
    private Context mycontext;
    public static  final Integer[] img = {R.drawable.first1,R.drawable.second2,R.drawable.third3,R.drawable.fourth4,
            R.drawable.fifth5,R.drawable.sixth6,R.drawable.sevnth7,R.drawable.eight8,R.drawable.ninth9,R.drawable.el11,
            R.drawable.twelv12,R.drawable.thirdee13};

    public MyAdapter(Context c){
        this.mycontext = c;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return img[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.single_row,null);
        }
        ImageView x = convertView.findViewById(R.id.imgimg);
        x.setImageResource(img[position]);
        return convertView;
    }
}
