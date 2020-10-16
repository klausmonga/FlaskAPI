package com.b6555s.location;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class cars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getCars();
    }
    private void getCars() {
        SharedPreferences msharedPreferences = getSharedPreferences("first_start", 0);
        final StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET,
                new Net().getDomain(getApplicationContext())+"/cars", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                RecyclerView cars_recyclerView = (RecyclerView)findViewById(R.id.cars);
                cars_recyclerView.setHasFixedSize(true);
                cars_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                ArrayList<CarDAO> carDAOS = new ArrayList<CarDAO>();

                Log.e("resp",response);
                try {
                    JSONArray json = new JSONArray(response);
                    int i =0;
                    while( json.length() > i){
                        carDAOS.add(new CarDAO(String.valueOf(json.getJSONArray(i).get(0)),String.valueOf(json.getJSONArray(i).get(1))
                                ,String.valueOf(json.getJSONArray(i).get(2)),
                                String.valueOf(json.getJSONArray(i).get(3))));
                        i++;
                    }
                } catch (JSONException e) {
                    Log.e("json",e.getMessage());
                }
                CarsHadapter adapter = new CarsHadapter(carDAOS, getApplicationContext());
                cars_recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Status remote"," erreur de volley: ("+error.getMessage()+")");
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

}
