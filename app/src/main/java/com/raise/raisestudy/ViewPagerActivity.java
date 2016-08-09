package com.raise.raisestudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.raise.raisestudy.view.CycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private CycleViewPager m_cycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        m_cycleViewPager = (CycleViewPager) findViewById(R.id.cycle_viewpager);
        int[] res = new int[]{
                android.R.drawable.ic_media_previous,
                android.R.drawable.ic_media_play,
                android.R.drawable.ic_media_next
        };
        List<View> views = new ArrayList<>();
        for (int i = 0;i<3;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(res[i]);
            views.add(imageView);
//            TextView tv = new TextView(this);
//            tv.setText(i+"fdgdgdg");
//            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
//            views.add(tv);
        }

        m_cycleViewPager.setViews(views);
    }

}
