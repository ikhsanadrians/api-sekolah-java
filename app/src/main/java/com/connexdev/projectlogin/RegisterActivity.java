//package com.connexdev.projectlogin;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import java.util.HashMap;
//
//
//public class RegisterActivity extends AppCompatActivity {
//
//    private EditText registerName;
//    private EditText registerPassword;
//    private EditText ConfirmPassword;
//    private Button btnSubmit;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        getSupportActionBar().hide();
//
//        EditText registerName = (EditText) findViewById(R.id.namauser);
//        EditText registerPassword = (EditText) findViewById(R.id.passworduser);
//        EditText ConfirmPassword = (EditText) findViewById(R.id.confirmpassword);
//        Button btnSubmit = (Button) findViewById(R.id.tombolsubmit);
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String username = registerName.getText().toString().trim();
//                final String password = registerPassword.getText().toString().trim();
//                final String confirms = ConfirmPassword.getText().toString().trim();
//
//               if(confirms.equals(password)){
//                   class AddUsername extends AsyncTask<Void, Void, String> {
//                       ProgressDialog loading;
//                       @Override
//                       protected void onPreExecute() {
//                           super.onPreExecute();
//                           loading = ProgressDialog.show(RegisterActivity.this,
//                                   "Menambahkan...", "Tunggu...", false, false);
//                       }
//                       @Override
//                       protected void onPostExecute(String s) {
//                           super.onPostExecute(s);
//                           loading.dismiss();
//                           Toast.makeText(RegisterActivity.this, s,
//                                   Toast.LENGTH_LONG).show();
//                       }
//                       @Override
//                       protected String doInBackground(Void... v) {
//                           HashMap<String, String> params = new HashMap<>();
//                           params.put(Configuration.KEY_EMP_USERNAME,username );
//                           params.put(Configuration.KEY_EMP_PASSWORD,password);
//                           RequestHandler rh = new RequestHandler();
//                           String res = rh.sendPostRequest(Configuration.URL_ADD_NEWUSER,
//                                   params);
//                           return res;
//                       }
//
//                   }
//                   AddUsername ae = new AddUsername();
//                   ae.execute();
//
//               } else {
//                   AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                   builder.setMessage("Confirm Password Tidak Cocok")
//                           .setNegativeButton("Retry", null).create().show();
//
//
//               }
//
//
//            }
//
//
//
//        });
//
//
//
//
//    }
//
//
//}