package chwn.wuba.com.mylistview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by changwenna on 2017/4/14.
 */
public class MyListView extends ListView implements AbsListView.RecyclerListener {
    private int myChildCount = -1;

    public MyListView(Context context) {
        super(context);
        setRecyclerListener(this);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRecyclerListener(this);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setRecyclerListener(this);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        Log.i("chwn", "setAdapter>>");
        super.setAdapter(adapter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.w("chwn", "onMeasure>>entry:widthMode:" + widthMode + ";heightMode:" + heightMode+";widthSize:"+widthSize+
        ";heightSize:"+heightSize);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.w("chwn", "onLayout>>changed:" + changed + ";l:" + l + ";t:" + t + ";r:" + r + ";b:" + b);
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.w("chwn", "onDraw>>");
        super.onDraw(canvas);
    }

    @Override
    protected void layoutChildren() {
        Log.w("chwn", "layoutChildren>>entry:childCount:" + getChildCount());
        super.layoutChildren();
        Log.w("chwn", "layoutChildren>>exit:childCount:" + getChildCount());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.w("chwn", "onSizeChanged>>MeasureSpec.UNSPECIFIED:"+MeasureSpec.UNSPECIFIED
                +";EXACTLY:"+MeasureSpec.EXACTLY
                +";AT_MOST:"+MeasureSpec.AT_MOST+"entry:w:" + w + ";h:" + h + ";oldw:" + oldw + ";oldh:" + oldh);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void handleDataChanged() {
        Log.w("chwn", "handleDataChanged>>entry:TranscriptMode:"+getTranscriptMode()+";isStackFromBottom:"+isStackFromBottom());
       super.handleDataChanged();
        Log.w("chwn", "handleDataChanged>>exit:childCount:" + getChildCount()+";layoutMode:"+getLayoutMode());
    }

    @Override
    public View getFocusedChild() {
        return super.getFocusedChild();
    }

    @Override
    public void onViewAdded(View child) {
        Object indexTag = child.getTag(R.integer.LIST_VIEW_TAG_INDEX);
        if (indexTag != null) {
            try {
                int index = Integer.parseInt(String.valueOf(indexTag));
                Log.e("chwn", "onViewAdded>>child No.:" + index);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onViewAdded(child);
    }

    @Override
    public void onViewRemoved(View child) {
        Object indexTag = child.getTag(R.integer.LIST_VIEW_TAG_INDEX);
        if (indexTag != null) {
            try {
                int index = Integer.parseInt(String.valueOf(indexTag));
                Log.e("chwn", "onViewRemoved>>child No.:" + index);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onViewRemoved(child);
    }

    @Override
    public void onMovedToScrapHeap(View view) {
        int curChildCount = getChildCount();
        if (myChildCount != curChildCount) {
            myChildCount = curChildCount;
            Log.e("chwn", "onMovedToScrapHeap>>listview:childCount:" + curChildCount);
        }
        Object indexTag = view.getTag(R.integer.LIST_VIEW_TAG_INDEX);
        if (indexTag != null) {
            try {
                int index = Integer.parseInt(String.valueOf(indexTag));
                Log.e("chwn", "onMovedToScrapHeap>>view No.:" + index);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
