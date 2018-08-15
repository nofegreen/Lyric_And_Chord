package com.nofegreen.chord;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThemaGrid extends ArrayAdapter< String > {

    private final Activity contextGrid;
    private final String[] textGrid;
    private final Integer[] imageGrid;
    private  final String[] yearGrid;

    public ThemaGrid(Activity context, String[] textId, Integer[] imageId, String[] textYearId){
        super(context, com.nofegreen.chord.R.layout.activity_thema_grid, textId);
        this.contextGrid = context;
        this.textGrid = textId;
        this.imageGrid = imageId;
        this.yearGrid = textYearId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = contextGrid.getLayoutInflater();
        View rowView = inflater.inflate(com.nofegreen.chord.R.layout.activity_thema_grid, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(com.nofegreen.chord.R.id.textAlbum);
        ImageView imageView = (ImageView) rowView.findViewById(com.nofegreen.chord.R.id.imageAlbum);
        TextView txYear = (TextView) rowView.findViewById(com.nofegreen.chord.R.id.yearsAlbum);

        txtTitle.setText(textGrid[position]);
        imageView.setImageResource(imageGrid[position]);
        txYear.setText(yearGrid[position]);
        return rowView;
    }
}
