package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShippudenActivity extends AppCompatActivity {
    ListView shippudenList;
    ArrayList<NamePage> shippuden = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shippuden);
        
        final ArrayList<NamePage> shippuden = new ArrayList<>();
        shippuden.add(new NamePage("Naruto Shippuden: Opening 1", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 2", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 3", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 4", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 5", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 6", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 7", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 8", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 9", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 10", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 11", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 12", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 13", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 14", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 15", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 16", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 17", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 18", R.drawable.shippudenv2));
        shippuden.add(new NamePage("Naruto Shippuden: Opening 19", R.drawable.shippudenv2));

        shippudenList = findViewById(R.id.shippudenList);
        ShippudenAdapter animeAdapter = new ShippudenAdapter(this, R.layout.activity_shippuden, shippuden);
        shippudenList.setAdapter((ListAdapter) animeAdapter);
    }
}