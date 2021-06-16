package com.example.narudora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {
    Bundle songExtraData;
    ArrayList<File> songFileList;
    SeekBar seekBar;
    SeekBar seekBar2;
    TextView songTitle;
    ImageView playBtn;
    ImageView previousBtn;
    ImageView skipBtn;
    ImageView songCover;
    static MediaPlayer mediaPlayer;
    private Runnable runnable;
    private AudioManager audioManager;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        seekBar = findViewById(R.id.seekBar);
        songTitle = findViewById(R.id.songTitle);
        playBtn = findViewById(R.id.playButton);
        previousBtn = findViewById(R.id.previousButton);
        skipBtn = findViewById(R.id.nextButton);
        seekBar2 = findViewById(R.id.seekBarVol);
        songCover = findViewById(R.id.imageView5);


        final ArrayList <Integer> songs = new ArrayList<>();
        songs.add(0, R.raw.batonroad);
        songs.add(1, R.raw.over);
        songs.add(2, R.raw.itsallinthegame);
        songs.add(3, R.raw.lonelygo);
        songs.add(4, R.raw.goldentime);
        songs.add(5, R.raw.teenagedream);
        songs.add(6, R.raw.startingandgrowing);
        songs.add(7, R.raw.baku);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

        int maxV = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar2.setMax(maxV);
        seekBar2.setProgress(curV);

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setMax(mediaPlayer.getDuration());
                if (mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    playBtn.setImageResource(R.drawable.playbuttonv3);
                } else {
                    mediaPlayer.start();
                    playBtn.setImageResource(R.drawable.pausebutton2);
                }
                SongNames();
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null){
                    playBtn.setImageResource(R.drawable.pausebutton2);
                }
                if (currentIndex <songs.size() - 1){
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
                SongNames();

            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null){
                    playBtn.setImageResource(R.drawable.pausebutton2);
                }

                if (currentIndex > 0){
                    currentIndex--;
                } else{
                    currentIndex = songs.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
                SongNames();
            }
        });

    }

    private void SongNames (){
        if (currentIndex == 0) {
            songTitle.setText("Baton Road - KANA-BOOM");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 1) {
            songTitle.setText("OVER - Little Glee Monster");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 2) {
            songTitle.setText("It's All In The Game  - Qyoto");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 3) {
            songTitle.setText("Lonely Go! - Brian the Sun");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 4) {
            songTitle.setText("Golden Time - Fujifabric");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 5) {
            songTitle.setText("Teenage Dream - Miwa");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 6) {
            songTitle.setText("Starting and Growing - Sambomaster");
            songCover.setImageResource(R.drawable.boruto);
        }
        if (currentIndex == 7) {
            songTitle.setText("BAKU - Ikimono-Gakari");
            songCover.setImageResource(R.drawable.boruto);
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null){
                    try {
                        if (mediaPlayer.isPlaying()){
                            Message message = new Message();
                            handler.sendMessage(message);
                            message.what = mediaPlayer.getCurrentPosition();
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("Handler Leak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            seekBar.setProgress(msg.what);
        }
    };
}