package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BorutoActivity extends AppCompatActivity {
    ListView borutoList;
    ArrayList<NamePage> boruto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boruto);

        final ArrayList<NamePage> boruto = new ArrayList<>();
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 1", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 2", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 3", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 4", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 5", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 6", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 7", R.drawable.boruto));
        boruto.add(new NamePage("Boruto: Naruto Next Generations: Opening 8", R.drawable.boruto));

        borutoList = findViewById(R.id.shippudenList);
        BorutoAdapter animeAdapter = new BorutoAdapter(this, R.layout.activity_boruto, boruto);
        borutoList.setAdapter((ListAdapter) animeAdapter);
    }
}