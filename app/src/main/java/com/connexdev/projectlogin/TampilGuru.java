package com.connexdev.projectlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;


public class TampilGuru extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_guru);
        getSupportActionBar().hide();
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }
    private void showEmployee() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result =
                    jsonObject.getJSONArray(Configuration.TAG_JSON_ARRAY_GURU);
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Configuration.TAG_ID_GURU);
                String name = jo.getString(Configuration.TAG_NAMA_GURU);
                HashMap<String, String> employees = new HashMap<>();
                employees.put(Configuration.TAG_ID_GURU, id);
                employees.put(Configuration.TAG_NAMA_GURU, name);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                TampilGuru.this, list, R.layout.listitem,
                new String[]{Configuration.TAG_ID_GURU, Configuration.TAG_NAMA_GURU},
                new int[]{R.id.id, R.id.name});
        listView.setAdapter(adapter);
    }
    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilGuru.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }
            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuration.URL_GET_ALL_GURU);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    //buat detile guru saat di klik
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long kdguru) {
        Intent intent = new Intent(TampilGuru.this, DetileGuru.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String empIdGuru = map.get(Configuration.TAG_ID_GURU).toString();
        intent.putExtra(Configuration.EMP_ID_GURU, empIdGuru);
        startActivity(intent);
    }
}