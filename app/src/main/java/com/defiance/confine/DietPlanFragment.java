package com.defiance.confine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DietPlanFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan, container, false);

        if (NavigationDrawerActivity.map.get("combination") != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.diet_fragment, new DietPlanInfoFragment());
            transaction.commit();
        }
        else {
            Toast.makeText(getContext(), "Please Take Self-Assesment Test!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getActivity(), NavigationDrawerActivity.class));
        }
        return view;
    }
}