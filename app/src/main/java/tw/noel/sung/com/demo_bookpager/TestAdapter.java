package tw.noel.sung.com.demo_bookpager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> test;
    private View view;

    public TestAdapter() {
        test = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            test.add(i + "");
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_test,viewGroup,false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof TestViewHolder){
            TestViewHolder testViewHolder = (TestViewHolder)viewHolder;
            testViewHolder.textView.setText(test.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    //----------------

    class TestViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

}
