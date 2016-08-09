package com.raise.raisestudy.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.raise.raisestudy.Pager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raise.yang on 2016/06/25.
 */
public class CycleViewPager extends ViewPager {

    private PagerAdapter m_adapter;
    private List<View> m_views = new ArrayList<>();
    private List<Pager> m_pagers = new ArrayList<>();


    public CycleViewPager(Context context) {
        this(context, null);
    }

    public CycleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        addOnPageChangeListener(m_page_listener);
        m_adapter = new CyclePagerAdapter();

    }

    public void setViews(List<View> views) {
        m_views = new ArrayList<>();

//        ImageView imageView1 = new ImageView(getContext());
//        imageView1.setImageResource(android.R.drawable.ic_media_next);
//        ImageView imageView2 = new ImageView(getContext());
//        imageView2.setImageResource(android.R.drawable.ic_media_previous);
        m_views.add(views.get(views.size() - 1));
        m_views.addAll(views);
        m_views.add(views.get(0));

        for (View view : m_views) {
            m_pagers.add(new Pager(view));
        }

        setAdapter(m_adapter);
        setCurrentItem(1, false);
    }

    ViewPager.OnPageChangeListener m_page_listener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffsetPixels == 0) {
                if (position == m_pagers.size() - 1) {
                    setCurrentItem(1, false);
                } else if (position == 0) {
                    //滑到最左边一个
                    setCurrentItem(m_pagers.size() - 2, false);
                }
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    class CyclePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return m_pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d("CyclePagerAdapter", "instantiateItem() pos = " + position+ "  "+m_pagers.get(position).m_view.toString());
//            View view = m_views.get(position);
//            ViewGroup viewGroup = (ViewGroup) view.getParent();
//            if (viewGroup != null)
//                viewGroup.removeView(view);
//            if (position == getCount())

                container.addView(m_pagers.get(position).m_view, 0);
            return m_pagers.get(position).m_view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("CyclePagerAdapter", "destroyItem() pos = " + position);
            container.removeView(m_pagers.get(position).m_view);
        }
    }
}
