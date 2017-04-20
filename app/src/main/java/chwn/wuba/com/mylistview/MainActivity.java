package chwn.wuba.com.mylistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private MyAdapter mAdapter;
    private ArrayList<String> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        Toast tt= Toast.makeText(this, "你好", Toast.LENGTH_SHORT);
        tt.setText("我好");
        tt.show();
    }

    private void initView() {
        mAdapter = new MyAdapter(this);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

    private void mockData() {
        if (mListData == null) {
            mListData = new ArrayList<>();
        }
        mListData.clear();
        for (int i = 0; i < 1000; i++) {
            mListData.add(String.valueOf(i));
        }
    }

    private void setData(){
        mockData();
        mAdapter.setData(mListData);
    }
}
