package com.example.narudora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NarutoAdapter extends ArrayAdapter<NamePage> {
    private static final String TAG = "NarutoAdapter";
    private Context myContext;
    int myResource;

    public NarutoAdapter(Context context, ArrayList list){
        super(context, 0, list);
    }

    public NarutoAdapter(NarutoActivity narutoActivity, int name, ArrayList<NamePage> names) {
        super(narutoActivity,0,names);


    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.narutolist, parent, false);
        NamePage currentCategoryItem = getItem(position);
        ImageView categoryItemImageView = convertView.findViewById(R.id.narutoImage);
        TextView categoryItemTextView = convertView.findViewById(R.id.narutoName);
        categoryItemImageView.setImageResource(currentCategoryItem.getImage());
        categoryItemTextView.setText(currentCategoryItem.getName());
        return convertView;

    }
}
