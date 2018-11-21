package tw.noel.sung.com.demo_bookpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import tw.noel.sung.com.demo_bookpager.bookpager.util.bookpager.BookPager;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private TextView tvCurrentParts;
    private TextView tvBook;
    private BookPager bookPager;
    private   ArrayList<ArrayList<String>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentParts = findViewById(R.id.tv_current_parts);
        tvBook = findViewById(R.id.tv_book);
        bookPager = findViewById(R.id.book_pager);

        bookPager.addOnPageChangeListener(this);

        data = new ArrayList<>();
        //加入 1~ 10 的隨機數量的小說
        for (int i = 0; i < (new Random().nextInt(10) + 1); i++) {
            ArrayList<String> arrayList = new ArrayList<>();
            //每部小說 加入 1~ 30 的隨機集數
            for (int j = 0; j < (new Random().nextInt(30) + 1); j++) {
                arrayList.add(j +  getWords());
            }
            //將塞滿集數的該部小說 裝入數據
            data.add(arrayList);
        }

        bookPager.setData(data);
        tvBook.setText("總共 "+data.size()+" 部書籍");
        tvCurrentParts.setText("這是第"+0+"部書籍，總集數共 "+data.get(0).size()+" 集");
    }

    private String getWords(){
        return "AAAAAAABBBBABABABABAJBABJBAJBAJBABJABLJABABJLABAKLBAKBAKBAKBKABNKABNK:AKANAA:NBANAN:AN:LAN:AN:AN\n" +
                "KNSIKNANNSPN:SFOJJMmdsvlomodsmvl;mjd[OABHDOIBDSOI\n"+
                "SLAFJMOLFMJPNASFONMOGDLMOL:SNDGLOMDNMGLSMBL\n"+"" +
                "SMDBMDSLBMSLMB\n"+"" +
                "LPOMOPNMOPNMFODNMF:SNMFON:LGMDLGMMWB{\n"+
                "{PMB{PM{RPWBM['msUSUOGSUGGLOSIGIGCSPGCISHVIHP:VNDPO:NBPND:Sdv'smMD";
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        tvBook.setText("總共 "+data.size()+" 部書籍");
        tvCurrentParts.setText("這是第"+i+"部書籍，總集數共 "+data.get(i).size()+" 集");
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
