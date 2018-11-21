package tw.noel.sung.com.demo_bookpager.bookpager.util.bookpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tw.noel.sung.com.demo_bookpager.bookpager.util.recyclerview.CustomRecyclerView;
import tw.noel.sung.com.demo_bookpager.bookpager.util.recyclerview.CustomRecyclerViewAdapter;

public class BookPagerAdapter extends PagerAdapter {
    private ArrayList<ArrayList<String>> data;
    private Context context;

    public BookPagerAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();

    }

    //-----------
    public void updateData(ArrayList<ArrayList<String>> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    //------------
    @Override
    public int getCount() {
        return data.size();
    }
    //-----------

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    //-----------

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        CustomRecyclerView customRecyclerView = new CustomRecyclerView(context);
        customRecyclerView.setAdapter(new CustomRecyclerViewAdapter(context).setData(data.get(position)));
        container.addView(customRecyclerView);
        return customRecyclerView;
    }
    //-----------

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
