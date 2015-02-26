package com.example.presdanwapres;

import android.app.Activity;
import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Listitem extends ArrayAdapter<Listheader>{

    Context context;
    int layoutResourceId;   
    Listheader data[] = null;
   
    public Listitem(Context context, int layoutResourceId, Listheader[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
     
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        listheaderHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new listheaderHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
           
            row.setTag(holder);
        }
        else
        {
            holder = (listheaderHolder)row.getTag();
        }
       
        Listheader listheader = data[position];
        holder.txtTitle.setText(listheader.title);
        holder.imgIcon.setImageResource(listheader.icon);
       
        return row;
    }
   
    static class listheaderHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}