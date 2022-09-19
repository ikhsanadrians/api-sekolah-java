package com.connexdev.projectlogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
 EditText username,password;
  Button btnLogin;
  String usernamekey,passwordkey;
  TextView RegisterLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.namauser);
        password = (EditText) findViewById(R.id.passworduser);
        btnLogin = (Button) findViewById(R.id.tombol);
        RegisterLink = (TextView) findViewById(R.id.Register);

        btnLogin.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                usernamekey = username.getText().toString();
                passwordkey = password.getText().toString();
                if (usernamekey.equals("maulana") && passwordkey.equals("sentana")){
                    Toast.makeText(getApplicationContext(),"Selamat Anda Berhasil Login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, CrudHomePage.class);
                        LoginActivity.this.startActivity(intent);
                        finish();

                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username Atau Password Antum Ada yang salah Tuh")
                            .setNegativeButton("Retry", null).create().show();

}
            }


    });

    RegisterLink.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            LoginActivity.this.startActivity(intent);
            finish();
        }
    });
}
}