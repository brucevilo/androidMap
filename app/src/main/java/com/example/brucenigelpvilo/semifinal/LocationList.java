package com.example.brucenigelpvilo.semifinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class LocationList extends ArrayAdapter<location> {

    private Activity context;
    private List<location> locationList;


    public LocationList(Activity context, List <location> locationList) {
        super(context,R.layout.list_layout,locationList);
        this.context = context;
        this.locationList = locationList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewLatitude = listViewItem.findViewById(R.id.latitude);
        TextView textViewLongtitude  = listViewItem.findViewById(R.id.longtitude);
        TextView textViewPlaces =listViewItem.findViewById(R.id.place);

        location location = locationList.get(position);

        textViewLatitude.setText(location.getDb_latitude());
        textViewLongtitude.setText(location.getDb_longtitude());
        textViewPlaces.setText(location.getDb_places());

        return listViewItem;
    }
}
