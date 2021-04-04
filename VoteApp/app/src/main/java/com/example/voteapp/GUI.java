package com.example.voteapp;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GUI extends AppCompatActivity {




    protected Button button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        button_submit = findViewById(R.id.button_resume);
        button_submit.setOnClickListener(e -> button_submit_OnClickListener());


    }

    private void button_submit_OnClickListener() {

        finish();


    }
}
