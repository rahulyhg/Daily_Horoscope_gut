package com.example.alex.daily_horoscope;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class    SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context = context;
    }
    //arrays
    public int[] slideImages = {
            R.drawable.splashlogo,
            R.drawable.tailored,
            R.drawable.touch
    };
    public String[] slide_headings = {
            "Welcome to Horoscope Daily!",
            "We represent you",
            "Are you curious?"
    };
    public String[] slide_description = {
            "Enjoy day to day horoscopes and predictions for your future!",
            "Carefully tailored horoscopes for each zodiac sign on a daily basis!",
            "Check now what the stars say!"

    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.slide_image);

        //Typeface Textviews
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/AdventPro-Light.ttf");

        TextView slideHeading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slideDesc = (TextView)view.findViewById(R.id.slide_desc);
        slideDesc.setTypeface(typeface);
        slideHeading.setTypeface(typeface);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_description[position]);

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

}
