package com.connexdev.projectlogin;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //ini untuk pengaturan lamanya splash screen berjalan
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(7000); // set Waktu Pending selama 2 detik
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, CrudHomePage.class));
                    finish(); // Menutup Activity
                }
            }
        };
        thread.start();
    }
}