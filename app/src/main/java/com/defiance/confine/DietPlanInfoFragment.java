package com.defiance.confine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class DietPlanInfoFragment extends Fragment {

    private ImageButton next;
    private TextView diagnose;
    private FoodAvoid foodAvoid = new FoodAvoid();
    public static StringBuilder list_text;
    private StringBuilder head_text;
    private DiseaseFragment disease;
    private TextView text1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan_info, container, false);
        next = view.findViewById(R.id.next_diet);

        text1 = view.findViewById(R.id.condition_intro_text);
        diagnose = view.findViewById(R.id.diet_plan_diagnose);
        head_text = new StringBuilder();
        list_text = new StringBuilder();
        disease = new DiseaseFragment();

            if (disease.hasDiabetes()) {
                head_text.append(", Diabetes");
                addToList(foodAvoid.diabetes);
            }
            if (disease.hasHypertension()) {
                head_text.append(", Hypertension");
                addToList(foodAvoid.hypertension);
            }
            if (disease.hasLungDisease()) {
                head_text.append(", Lung Disease");
                addToList(foodAvoid.lungs);
            }
            if (disease.hasHeartDisease()) {
                head_text.append(", Heart Disease");
                addToList(foodAvoid.heart);
            }
            if (disease.hasKidneyDisease()) {
                head_text.append(", Kidney Disease");
                addToList(foodAvoid.kidney);
            }
            if (disease.hasLiverDisease()) {
                head_text.append(", Liver Disease");
                addToList(foodAvoid.liver);
            }
            if (disease.hasBloodDisease()) {
                head_text.append(", Blood Disease");
            }
            if (disease.hasImmunoDeficiency()) {
                head_text.append(", Immunoodeficiency");
                addToList(foodAvoid.immune);
            }

            Log.wtf("String", head_text.toString());

            if (!TextUtils.equals(head_text.toString(), "")){
            head_text.append(".");
            head_text.deleteCharAt(0);
            head_text.deleteCharAt(0);
            diagnose.setText(head_text);
        }
            else {
                next.setVisibility(View.GONE);
                text1.setVisibility(View.GONE);
                diagnose.setText("You dont have any Diseases");
            }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.diet_fragment, new DietPlanAvoidFragment());
                transaction.commit();
            }
        });

        return view;
    }

    private void addToList(List<String> list) {

        for(String items : list)
            list_text.append("\n✔" + items + "\n");
        list_text.deleteCharAt(list_text.length() - 1);
    }



}