package tw.noel.sung.com.demo_bookpager.bookpager.util.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {
    private Context context;

    public CustomRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }
    //------------

    private void init() {
        new PagerSnapHelper().attachToRecyclerView(this);
        setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }
}
