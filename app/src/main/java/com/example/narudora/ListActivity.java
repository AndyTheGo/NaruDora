package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView animeList;
    ArrayList<NamePage> anime = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ArrayList<NamePage> anime = new ArrayList<>();
        anime.add(new NamePage("Naruto", R.drawable.narutoidk));
        anime.add(new NamePage("Naruto: Shippuden", R.drawable.shippudenv2));
        anime.add(new NamePage("Boruto: Naruto Next Generations", R.drawable.boruto));

        animeList = findViewById(R.id.listfornames);
        NameListAdapter animeAdapter = new NameListAdapter(this, R.layout.activity_list, anime);
        animeList.setAdapter((ListAdapter) animeAdapter);

        animeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(ListActivity.this, PlayActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(ListActivity.this, PlayerActivity.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(ListActivity.this, PlayingActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}