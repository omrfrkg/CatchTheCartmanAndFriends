package com.omrfrkg.catchthecartman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences("com.omrfrkg.catchthecartman", Context.MODE_PRIVATE);
    }

    public void skorTablosunuTemizle(View view){
        sharedPreferences.edit().remove("enYuksekSkor").apply();
        Toast.makeText(SettingsActivity.this,"Skor Tablosu Başarıyla Temizlendi!",Toast.LENGTH_SHORT).show();
    }

    public void arkaplanMuziginiKapat(View view){

        sharedPreferences.edit().putInt("muzikKapat",0).apply();
        Toast.makeText(SettingsActivity.this,"Arkaplan Müziği Başarıyla Kapatıldı!",Toast.LENGTH_SHORT).show();

    }
}