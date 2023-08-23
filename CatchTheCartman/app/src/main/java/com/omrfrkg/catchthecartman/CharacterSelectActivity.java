package com.omrfrkg.catchthecartman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CharacterSelectActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    MediaPlayer cartman;
    MediaPlayer kenny;
    MediaPlayer kyle;
    MediaPlayer stan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        sharedPreferences = getSharedPreferences("com.omrfrkg.catchthecartman", Context.MODE_PRIVATE);
        cartman = MediaPlayer.create(CharacterSelectActivity.this,R.raw.cartman_sounds);
        kenny = MediaPlayer.create(CharacterSelectActivity.this,R.raw.kenny_sounds);
        kyle = MediaPlayer.create(CharacterSelectActivity.this,R.raw.keyle_sounds);
        stan = MediaPlayer.create(CharacterSelectActivity.this,R.raw.stan_sounds);
    }

    public void cartmanSecildi(View view){
        sharedPreferences.edit().putString("character","cartman").apply();
        Toast.makeText(CharacterSelectActivity.this,"Cartman Karakterini Seçtiniz...",Toast.LENGTH_SHORT).show();
        cartman.start();
    }
    public void kennySecildi(View view){
        sharedPreferences.edit().putString("character","kenny").apply();
        Toast.makeText(CharacterSelectActivity.this,"Kenny Karakterini Seçtiniz...",Toast.LENGTH_SHORT).show();
        kenny.start();
    }
    public void kyleSecildi(View view){
        sharedPreferences.edit().putString("character","kyle").apply();
        Toast.makeText(CharacterSelectActivity.this,"Kyle Karakterini Seçtiniz...",Toast.LENGTH_SHORT).show();
        kyle.start();
    }
    public void stanSecildi(View view){
        sharedPreferences.edit().putString("character","stan").apply();
        Toast.makeText(CharacterSelectActivity.this,"Stan Karakterini Seçtiniz...",Toast.LENGTH_SHORT).show();
        stan.start();
    }
    public void anaMenuyeDon(View view){
        Intent intent = new Intent(CharacterSelectActivity.this,StartScreenActivity.class);
        startActivity(intent);
    }
}