package com.nofegreen.chord;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThemaList extends ArrayAdapter< String > {

    private final Activity context;
    private final String[] textId;
    private final Integer[] imageId;

    public ThemaList(Activity context, String[] textId, Integer[] imageId){
        super(context, com.nofegreen.chord.R.layout.activity_thema_list, textId);
        this.context = context;
        this.textId = textId;
        this.imageId = imageId;

    }@Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(com.nofegreen.chord.R.layout.activity_thema_list, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(com.nofegreen.chord.R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(com.nofegreen.chord.R.id.imageView);
        txtTitle.setText(textId[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
