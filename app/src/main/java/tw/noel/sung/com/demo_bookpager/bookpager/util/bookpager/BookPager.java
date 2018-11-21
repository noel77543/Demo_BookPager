package tw.noel.sung.com.demo_bookpager.bookpager.util.bookpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;

public class BookPager extends ViewPager {
    private BookPagerAdapter bookPagerAdapter;
    private Context context;

    public BookPager(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public BookPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    //-----------
    private void init() {
        bookPagerAdapter = new BookPagerAdapter(context);
        setAdapter(bookPagerAdapter);
    }


    //---------

    /***
     * 設置資料
     */
    public void setData(ArrayList<ArrayList<String>> data) {
        bookPagerAdapter.updateData(data);
    }
}
