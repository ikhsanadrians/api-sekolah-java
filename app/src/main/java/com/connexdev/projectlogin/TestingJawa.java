// package com.connexdev.projectlogin;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.HashMap;
//
// public class TestingJawa extends AppCompatActivity {
//
//    private EditText EditTextNisJawa;
//    private Spinner ListItemJawa;
//    private EditText EditTextNameJawa;
//    private EditText Alamat;
//    private Button BtnSubmit;
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
//        setContentView(R.layout.activity_testing_jawa);
//
//        EditText EditTextNameJawa = (EditText) findViewById(R.id.editTextNameJawa);
//        EditText EditTextNisJawa = (EditText) findViewById(R.id.editNisJawa);
//        EditText Alamat     = (EditText) findViewById(R.id.editTextAlamatJawa);
//        Spinner ListItemJawa = (Spinner) findViewById(R.id.listItemJawa);
//        Button BtnSubmit = (Button) findViewById(R.id.buttonAddJawa);
//
//        BtnSubmit.setOnClickListener(new View.OnClickListener() {
//           @Override
//            public void onClick(View v) {
//               final String nis = EditTextNisJawa.getText().toString().trim();
//               final String name = EditTextNameJawa.getText().toString().trim();
//               final String desg = ListItemJawa.getSelectedItem().toString().trim();
//               final String alamat = Alamat.getText().toString().trim();
//               class AddTesting extends AsyncTask<Void, Void, String> {
//                   ProgressDialog loading;
//                   @Override
//                   protected void onPreExecute() {
//                       super.onPreExecute();
//                       loading = ProgressDialog.show(TestingJawa.this,"Menambahkan...", "Tunggu...", false, false);
//                   }
//                   @Override
//                   protected void onPostExecute(String s) {
//                       super.onPreExecute(s);
//                       loading.dismiss();
//                       Toast.makeText(TambahSiswa.this, s, Toast.LENGTH_SHORT).show();
//                   }
//                   @Override
//                   protected String doInBackground(Void... v) {
//                       HashMap<String, String> params = new HashMap<>();
//                       params.put(Configuration.KEY_EMP_ID_PD,nis);
//                       params.put(Configuration.KEY_EMP_KELAMIN_PD,desg);
//                       params.put(Configuration.KEY_EMP_NAMA_PD,name);
//                       params.put(Configuration.KEY_EMP_ALAMAT_PD,alamat);
//                       RequestHandler rh = new RequestHandler();
//                      String res = rh.sendPostRequest(Configuration.URL_ADD_PD);
//                       return res;
//                   }
//                   AddEmployee ae = new AddEmployee();
//                   ae.execute();
//               }
//
//
//           }
//
//
//        });
//
//
//    }
//
//}