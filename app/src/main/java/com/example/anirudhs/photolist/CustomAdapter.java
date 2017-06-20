package com.example.anirudhs.photolist;

import android.app.Activity;


import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends ArrayAdapter<PhotoList>{

    private class ViewHolder{
        ImageView imgIcon;
        TextView captions;

    }


    public CustomAdapter(Activity context, ArrayList<PhotoList> photolist) {
        super(context,0, photolist);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
            viewHolder.captions = (TextView)convertView.findViewById(R.id.myText);
            viewHolder.imgIcon = (ImageView)convertView.findViewById(R.id.myImage);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
     PhotoList image = getItem(position);
        viewHolder.captions.setText(image.getCaption());
        final int THUMBSIZE = 200;
        viewHolder.imgIcon.setImageURI(Uri.fromFile(new File(image.getPath())));

        viewHolder.imgIcon.setImageBitmap(ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(image.getPath()),THUMBSIZE, THUMBSIZE));
        return convertView;


    }


}
