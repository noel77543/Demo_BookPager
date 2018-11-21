package tw.noel.sung.com.demo_bookpager.bookpager.util.recyclerview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> data;
    private Context context;

    public CustomRecyclerViewAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    //--------------

    public CustomRecyclerViewAdapter setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    //----------
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setTextSize(24);
        textView.setTypeface(Typeface.SANS_SERIF);
        return new CustomViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CustomViewHolder) {
            CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;
            customViewHolder.textView.setText(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //-----------

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
