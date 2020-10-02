package com.defiance.confine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;


    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

        @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(models.get(position).getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 1)
                    context.startActivity(new Intent(context, MythBustersActivity.class));
                else if (position == 2)
                    context.startActivity(new Intent(context, PreventiveMeasuresActivity.class));
                else if  (position == 3)
                    context.startActivity(new Intent(context, SelfQuarantineActivity.class));
                else if (position == 4)
                    context.startActivity(new Intent(context, TipsActivity.class));
                else if (position == 5)
                    context.startActivity(new Intent(context, DosAndDontsActivity.class));
                else if (position == 6)
                    context.startActivity(new Intent(context, MentalHealthActivity.class));
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
