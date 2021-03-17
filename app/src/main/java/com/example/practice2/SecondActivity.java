package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    List<String> stringList = new ArrayList<>(Arrays.asList("Drums","Guitar","Ukelele"));
    List<Integer> imageList = new ArrayList<>(Arrays.asList(R.drawable.bagpipes,R.drawable.drums,R.drawable.ukulele));
    List<Integer> musicList = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.drums,R.raw.ukulele));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.lv);
        ListviewAdapter listViewAdapter = new ListviewAdapter(stringList, imageList);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mediaPlayer != null && listViewAdapter.getPlayingTrack() == position) {
                    if(mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        listViewAdapter.setPlayStatus(false);
                    }
                    else if(!mediaPlayer.isPlaying()){
                        mediaPlayer.start();
                        listViewAdapter.setPlayStatus(true);

                    }
                }
                else{
                    if(mediaPlayer != null && mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        listViewAdapter.setPlayStatus(false);
                    }
                    mediaPlayer = MediaPlayer.create(SecondActivity.this,musicList.get(position));
                    mediaPlayer.start();
                    listViewAdapter.setPlayingTrack(position);
                    listViewAdapter.setPlayStatus(true);
                    Toast.makeText(SecondActivity.this, "Sounds playing", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
}