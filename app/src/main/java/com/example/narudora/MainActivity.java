package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    TextView slogan;
    Button button;
    private NameListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        //slogan = findViewById(R.id.textView);
        button = findViewById(R.id.play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPage();
            }
        });
    }
     public void listPage(){
         Intent intent = new Intent(MainActivity.this, ListActivity.class);
         startActivity(intent);
    }
}