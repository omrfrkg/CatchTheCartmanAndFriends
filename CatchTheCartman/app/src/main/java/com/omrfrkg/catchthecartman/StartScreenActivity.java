package com.omrfrkg.catchthecartman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }
    public void oyunEkraniniAc(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void karakterSecmeEkraniniAc(View view){
        Intent intent = new Intent(StartScreenActivity.this,CharacterSelectActivity.class);
        startActivity(intent);
    }
    public void ayarlarEkraniniAc(View view){
        Intent intent = new Intent(StartScreenActivity.this,SettingsActivity.class);
        startActivity(intent);
    }
    public void skorSayfasiniAc(View view){
        Intent intent = new Intent(StartScreenActivity.this,HighScoreActivity.class);
        startActivity(intent);
    }
}