package chwn.wuba.com.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by changwenna on 2017/4/14.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onStartTemporaryDetach() {
        Log.v("chwn","onStartTemporaryDetach>>");
        Object indexTag = getTag(R.integer.LIST_VIEW_TAG_INDEX);
        if(indexTag != null){
            try {
                int index = Integer.parseInt(String.valueOf(indexTag));
                Log.v("chwn","onStartTemporaryDetach>>child No.:"+index);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        super.onStartTemporaryDetach();
    }

    @Override
    public void onFinishTemporaryDetach() {
        Log.v("chwn","onFinishTemporaryDetach>>");
        Object indexTag = getTag(R.integer.LIST_VIEW_TAG_INDEX);
        if(indexTag != null){
            try {
                int index = Integer.parseInt(String.valueOf(indexTag));
                Log.v("chwn","onFinishTemporaryDetach>>child No.:"+index);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        super.onFinishTemporaryDetach();
    }
}
