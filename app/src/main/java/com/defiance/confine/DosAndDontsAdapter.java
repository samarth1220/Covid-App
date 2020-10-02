package com.defiance.confine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class DosAndDontsAdapter extends PagerAdapter {

    public DosAndDontsAdapter(List<DosAndDontsModel> dosAndDontsModels, Context context) {
        this.dosAndDontsModels = dosAndDontsModels;
        this.context = context;
    }

    private List<DosAndDontsModel> dosAndDontsModels;
    private LayoutInflater layoutInflater;
    private Context context;

    @Override
    public int getCount() {
        return dosAndDontsModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.donts_item, container, false);

        TextView textView1 = view.findViewById(R.id.head_1);
        TextView textView2 = view.findViewById(R.id.head_2);
        TextView textView3 = view.findViewById(R.id.head_3);
        TextView textView4 = view.findViewById(R.id.head_4);
        TextView textView5 = view.findViewById(R.id.head_5);
        TextView textView6 = view.findViewById(R.id.head_6);
        TextView textView7 = view.findViewById(R.id.head_7);
        TextView textView8 = view.findViewById(R.id.desc_1);
        TextView textView9 = view.findViewById(R.id.desc_2);
        TextView textView10 = view.findViewById(R.id.desc_3);
        TextView textView11 = view.findViewById(R.id.desc_4);
        TextView textView12 = view.findViewById(R.id.desc_5);
        TextView textView13 = view.findViewById(R.id.desc_6);
        TextView textView14 = view.findViewById(R.id.desc_7);

        TextView textView = view.findViewById(R.id.dos_and_donts_head);


        textView.setText(dosAndDontsModels.get(position).getHeading());
        textView1.setText(dosAndDontsModels.get(position).getHead1());
        textView2.setText(dosAndDontsModels.get(position).getHead2());
        textView3.setText(dosAndDontsModels.get(position).getHead3());
        textView4.setText(dosAndDontsModels.get(position).getHead4());
        textView5.setText(dosAndDontsModels.get(position).getHead5());
        textView6.setText(dosAndDontsModels.get(position).getHead6());
        textView7.setText(dosAndDontsModels.get(position).getHead7());

        textView8.setText(dosAndDontsModels.get(position).getDesc1());
        textView9.setText(dosAndDontsModels.get(position).getDesc2());
        textView10.setText(dosAndDontsModels.get(position).getDesc3());
        textView11.setText(dosAndDontsModels.get(position).getDesc4());
        textView12.setText(dosAndDontsModels.get(position).getDesc5());
        textView13.setText(dosAndDontsModels.get(position).getDesc6());
        textView14.setText(dosAndDontsModels.get(position).getDesc7());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
