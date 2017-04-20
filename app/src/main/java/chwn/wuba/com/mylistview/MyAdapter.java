package chwn.wuba.com.mylistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by changwenna on 2017/4/14.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<String> mListData = new ArrayList<>();

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<String> datas) {
        mListData.clear();
        mListData.addAll(datas);
        Log.i("chwn", "Adapter setData>>notifyDataSetChanged");
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Log.i("chwn", "MyAdapter>>getView>>inflate view,position:" + position);
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_title = (MyTextView) convertView;
            convertView.setTag(R.integer.LIST_VIEW_TAG_HOLDER, viewHolder);
            convertView.setTag(R.integer.LIST_VIEW_TAG_INDEX, position);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(R.integer.LIST_VIEW_TAG_HOLDER);
        }
        viewHolder.tv_title.setText(mListData.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public MyTextView tv_title;
    }
}
