package com.example.recyclerview_and_json_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview_and_json_data.Adaptadores.Adaptador;
import com.example.recyclerview_and_json_data.Modelo.Evaluadores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Evaluadores> evaluadores;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lstEvaluadores);
        evaluadores = new ArrayList<>();
        extraerEvaluadores();
    }
    private void extraerEvaluadores() {
        RequestQueue Requestq=Volley.newRequestQueue(this);
        String URL_Json = "https://www.uealecpeterson.net/ws/listadoevaluadores.php";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL_Json, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray tamaño = response.getJSONArray("listaaevaluador");
                    for(int i=0; i<tamaño.length(); i++) {
                        JSONObject jsonObject = new JSONObject(tamaño.get(i).toString());
                        Evaluadores listado = new Evaluadores(jsonObject.getString("imgJPG"),
                                jsonObject.getString("imgjpg"), jsonObject.getString("idevaluador"),
                                jsonObject.getString("nombres"), jsonObject.getString("area"));
                        evaluadores.add(listado);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Requestq.add(request);
    }

}