package com.omrfrkg.catchthecartman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView skor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        sharedPreferences = getSharedPreferences("com.omrfrkg.catchthecartman", Context.MODE_PRIVATE);
        skor = findViewById(R.id.enYuksekSkor);
        int enYuksekSkor = sharedPreferences.getInt("enYuksekSkor",0);
        skor.setText("En Yüksek Skorunuz :"+enYuksekSkor);

    }
}