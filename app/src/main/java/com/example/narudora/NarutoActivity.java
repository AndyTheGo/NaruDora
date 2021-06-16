package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NarutoActivity extends AppCompatActivity {
    ListView narutoList;
    ArrayList<NamePage> naruto = new ArrayList<>();
    Button play;
    Button pause;
    MediaPlayer mediaPlayer;
    MediaPlayer songPlayer;
    MediaPlayer musicPlayer;
    TextView Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto);
        Name = findViewById(R.id.songTitle);

        final ArrayList<NamePage> naruto = new ArrayList<>();
        naruto.add(new NamePage("Naruto: Opening 1", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 2", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 3", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 4", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 5", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 6", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 7", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 8", R.drawable.narutoidk));
        naruto.add(new NamePage("Naruto: Opening 9", R.drawable.narutoidk));

        narutoList = findViewById(R.id.shippudenList);
        NarutoAdapter animeAdapter = new NarutoAdapter(this, R.layout.activity_naruto, naruto);
        narutoList.setAdapter((ListAdapter) animeAdapter);

        narutoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NarutoActivity.this, PlayActivity.class);
                startActivity(intent);

            }
        });

        play = findViewById(R.id.play);
        //pause = findViewById(R.id.ivPa);

    }

}