package com.defiance.confine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class DietPlanAvoidFragment extends Fragment {

    private TextView list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan_avoid, container, false);
        list = view.findViewById(R.id.diet_list);
        list.setText(DietPlanInfoFragment.list_text);
        return view;
    }
}