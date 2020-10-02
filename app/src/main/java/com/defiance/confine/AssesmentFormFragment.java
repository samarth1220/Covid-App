package com.defiance.confine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kenilt.loopingviewpager.scroller.AutoScroller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssesmentFormFragment extends Fragment {

    private ViewPager viewPager;
    private Adapter adapter;
    private List<Model> models;
    private AutoScroller autoScroller;
    private Button next_btn;
    private TextView total_cases, active_cases;
    private TextView text2;

    private JSONObject jsonObject = null;
    private String  url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST";
    public static Map<String, String> map = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assesment_form, container, false);

        text2 = view.findViewById(R.id.head_text_2);
        text2.setVisibility(View.GONE);

        models = new ArrayList<>();
        models.add(new Model(R.mipmap.card_1));
        models.add(new Model(R.mipmap.card_2));
        models.add(new Model(R.mipmap.card_3));
        models.add(new Model(R.mipmap.card_4));
        models.add(new Model(R.mipmap.card_5));
        models.add(new Model(R.mipmap.card_6));
        models.add(new Model(R.mipmap.card_7));
        models.add(new Model(R.mipmap.card_8));

        total_cases = view.findViewById(R.id.total_cases);
        active_cases = view.findViewById(R.id.active_cases);

        adapter = new Adapter(models, getActivity());
        next_btn = view.findViewById(R.id.next_btn);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        autoScroller = new AutoScroller(viewPager, getLifecycle(),3000);


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    map.put("activeCases", response.get("activeCases").toString());
                    map.put("activeCasesNew", response.get("activeCasesNew").toString());
                    map.put("recovered", response.get("recovered").toString());
                    map.put("recoveredNew", response.get("recoveredNew").toString());
                    map.put("deaths", response.get("deaths").toString());
                    map.put("deathsNew", response.get("deathsNew").toString());
                    map.put("totalCases", response.get("totalCases").toString());
                    text2.setVisibility(View.VISIBLE);
                    total_cases.setText(map.get("totalCases"));
                    active_cases.setText(map.get("activeCases"));
                    Log.wtf("Text", total_cases.getText().toString());
                    Log.wtf("JSON", response.get("totalCases").toString()       );

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Json object", error.toString());

                    }
                });

        requestQueue.add(jsonObjectRequest);


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FormActivity.class));
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CovidCasesActivity.class));

            }
        });
        return view;
    }
}