package com.b6555s.location;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(((EditText) findViewById(R.id.name)).getText().toString(), ((EditText) findViewById(R.id.password)).getText().toString());
            }
        });

        findViewById(R.id.sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin(((EditText) findViewById(R.id.name)).getText().toString(), ((EditText) findViewById(R.id.password)).getText().toString());
            }
        });
    }

    public void signin(String name, String password){
        final StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET,
                new Net().getDomain(getApplicationContext())+"/sign_in/"+name+"/"+password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("notif",response);
                if (response.equals(1)){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else {
                    Toast.makeText(Login.this, "Auth faild", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Status remote"," erreur de volley: ("+error.getMessage()+")");
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    public void login(String name, String password){
        final StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET,
                new Net().getDomain(getApplicationContext())+"/login/"+name+"/"+password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("notif",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (!jsonObject.get("user").equals(0)){
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }else {
                        Toast.makeText(Login.this, "Auth faild", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Log.e("json",e.getMessage());
                }

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
