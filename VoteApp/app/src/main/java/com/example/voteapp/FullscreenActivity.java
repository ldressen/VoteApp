package com.example.voteapp;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {


    protected Button button_submit;
    protected RadioButton button_yes;
    protected RadioButton button_no;



    private static final String CLIENT_ID = "ec398ee3a4a34ad286ea82ad867026f0";
    private static final String REDIRECT_URL = "vote-app://callback";
    private SpotifyAppRemote mSpotifyAppRemote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        button_submit = findViewById(R.id.button_resume);
        button_submit.setOnClickListener(e -> button_submit_OnClickListener());
        button_yes = findViewById(R.id.radioButton_yes);
        button_no = findViewById(R.id.radioButton_no);


    }

    private void button_submit_OnClickListener() {


        if(button_yes.isChecked()){


            mSpotifyAppRemote.getPlayerApi().play("spotify:track:1mCsF9Tw4AkIZOjvZbZZdT");


        }
        else{

            mSpotifyAppRemote.getPlayerApi().play("spotify:track:6v9XhivN2PCrVsIW0U7sVk");

        }
        



    }
    @Override
    protected void onStart() {
        super.onStart();
        ConnectionParams connectionParams = new ConnectionParams.Builder(CLIENT_ID).setRedirectUri(REDIRECT_URL).showAuthView(true).build();

        SpotifyAppRemote.connect(this, connectionParams, new Connector.ConnectionListener() {
            @Override
            public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                mSpotifyAppRemote = spotifyAppRemote;
                Log.d("MainActivity", "Connected! Yay!");

                connected();
            }

            @Override
            public void onFailure(Throwable throwable) {

                Log.e("MainActivity",throwable.getMessage(),throwable);


            }
        });

    }

    private void connected() {

        mSpotifyAppRemote.getPlayerApi().play("spotify:playlist:4ooCy7kGZBXeTsj4jkEC3D");



    }

    @Override
    protected void onStop() {
        super.onStop();
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);

    }
}
