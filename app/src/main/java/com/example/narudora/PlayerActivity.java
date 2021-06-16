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

public class PlayerActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_player);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        seekBar = findViewById(R.id.seekBar);
        songTitle = findViewById(R.id.songTitle);
        playBtn = findViewById(R.id.playButton);
        previousBtn = findViewById(R.id.previousButton);
        skipBtn = findViewById(R.id.nextButton);
        seekBar2 = findViewById(R.id.seekBarVol);
        songCover = findViewById(R.id.imageView5);


        final ArrayList <Integer> songs = new ArrayList<>();
        songs.add(0, R.raw.heroscomeback);
        songs.add(1, R.raw.distance);
        songs.add(2, R.raw.bluebird);
        songs.add(3, R.raw.closer);
        songs.add(4, R.raw.hotarunohikari);
        songs.add(5, R.raw.sign);
        songs.add(6, R.raw.toumeidattasekai);
        songs.add(7, R.raw.diver);
        songs.add(8, R.raw.lovers);
        songs.add(9, R.raw.newsong);
        songs.add(10, R.raw.totsugekirock);
        songs.add(11, R.raw.moshimo);
        songs.add(12, R.raw.niwakaamenimomakezu);
        songs.add(13, R.raw.tsukinoookisa);
        songs.add(14, R.raw.guren);
        songs.add(15, R.raw.silhouette);
        songs.add(16, R.raw.kaze);
        songs.add(17, R.raw.bloodcirculator);
        songs.add(18, R.raw.karanokokoro);

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
            songTitle.setText("Heroes Come Back - Nobodyknows");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 1) {
            songTitle.setText("Distance - Long Shot Party");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 2) {
            songTitle.setText("Blue Bird  - Ikimono-gakari");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 3) {
            songTitle.setText("Closer - Joe Inoue");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 4) {
            songTitle.setText("Hotaru no Hikari - Ikimono-gakari");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 5) {
            songTitle.setText("Sign - FLOW");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 6) {
            songTitle.setText("Toumei Datta Sekai - Hata Motohiro");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 7) {
            songTitle.setText("Diver - NICO Touches the Walls");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 8) {
            songTitle.setText("Lovers - 7!!");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 9) {
            songTitle.setText("Newsong - Tacica");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 10) {
            songTitle.setText("Totsugeki Rock - THE CRO-MAGNONS");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 11) {
            songTitle.setText("Moshimo  - Daisuke");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 12) {
            songTitle.setText("Niwaka Ame Ni Mo Makezu - NICO Touches the Walls");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 13) {
            songTitle.setText("Tsuki No Ookisa - Nogizaka46");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 14) {
            songTitle.setText("Guren - DOES");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 15) {
            songTitle.setText("Silhouette - KANA-BOON");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 16) {
            songTitle.setText("Kaze - Yamazaru");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 17) {
            songTitle.setText("Line - Sukima Switch");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 18) {
            songTitle.setText("Blood Circulator - Asian Kung-Fu Generation");
            songCover.setImageResource(R.drawable.shippudenv2);
        }
        if (currentIndex == 19) {
            songTitle.setText("Kara No Kokoro - Anly");
            songCover.setImageResource(R.drawable.shippudenv2);
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