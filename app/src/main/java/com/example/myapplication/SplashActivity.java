package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Создаем объект Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Создаем объект Intent для запуска другой активити
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                // Запускаем другую активити
                startActivity(intent);
                // Закрываем текущую активити
                finish();
            }
        }, 3000); // Указываем задержку в 3 секунды (3000 миллисекунд)
    }
}
