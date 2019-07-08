
package com.mr0kaushik.goworkshop.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.mr0kaushik.goworkshop.R;

public class SliderAdapter extends PagerAdapter {
    private static final String TAG = "SliderAdapter";
    
    
    private Context context;
    private int[] slideImages = {
            R.drawable.wt_map,
            R.drawable.wt_learn,
            R.drawable.wt_explore
    };
    private int[] slideHeading = {
            R.string.wt_map_head,
            R.string.wt_learn_head,
            R.string.wt_explore_head
    };
    
    private int[] slideDescriptions = {
            R.string.wt_map_desc,
            R.string.wt_learn_desc,
            R.string.wt_explore_desc
    };


    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slideHeading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==  object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: starting");
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        AppCompatImageView imageView = view.findViewById(R.id.wtImageView);
        TextView tvHead = view.findViewById(R.id.tvHead);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        
        imageView.setImageResource(slideImages[position]);
        Log.d(TAG, "instantiateItem: Head : " + context.getResources().getString(slideHeading[position]));
        tvHead.setText(slideHeading[position]);
        Log.d(TAG, "instantiateItem: Desc : " + context.getResources().getString(slideDescriptions[position]));
        tvDescription.setText(slideDescriptions[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d(TAG, "destroyItem: Removing Slide Activity");
        container.removeView((RelativeLayout) object);
    }


}
