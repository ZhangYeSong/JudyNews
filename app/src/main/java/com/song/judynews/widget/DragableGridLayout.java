package com.song.judynews.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Judy on 2017/1/5.
 */

public class DragableGridLayout extends GridLayout {
    private Rect[] mRects;
    private View dragedView;
    private OnLongClickListener olcl = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            v.startDrag(null, new DragShadowBuilder(v), null, 0);
            v.setEnabled(false);
            dragedView = v;

            return false;
        }
    };

    private OnDragListener odl = new OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    initRects();
                    break;

                case DragEvent.ACTION_DRAG_LOCATION:
                    int touchIndex = getTouchIndex(event);
                    if (touchIndex > -1 && dragedView != null && dragedView != DragableGridLayout.this.getChildAt(touchIndex)) {
                        DragableGridLayout.this.removeView(dragedView);
                        DragableGridLayout.this.addView(dragedView, touchIndex);
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    if (dragedView != null) {
                        dragedView.setEnabled(true);
                    }
                    break;
            }
            return true;
        }
    };

    private boolean mAllowDrag;
    private OnItemClickListener mOnItemClickListener;

    public DragableGridLayout(Context context) {
        this(context, null);
    }

    public DragableGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setColumnCount(4);
        this.setLayoutTransition(new LayoutTransition());
    }

    public void setItems(List<String> items) {
        for (String item : items) {
            addItem(item);
        }
    }

    public void addItem(String item) {
        final TextView tv = newTextViewItem();
        tv.setText(item);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(tv);
            }
        });
        this.addView(tv);
    }

    private TextView newTextViewItem() {
        int margin = 5;
        LayoutParams params = new LayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels / 4 - 2 * margin;
        params.height = LayoutParams.WRAP_CONTENT;
        params.setMargins(margin, margin, margin, margin);
        TextView tv = new TextView(getContext());
        tv.setGravity(Gravity.CENTER);
        //tv.setBackgroundResource(R.drawable.selector);
        tv.setLayoutParams(params);
        if (mAllowDrag) {
            tv.setOnLongClickListener(olcl);
        } else {
            tv.setOnLongClickListener(null);
        }
        return tv;
    }

    public void setAllowDrag(boolean allowDrag) {
        this.mAllowDrag = allowDrag;
        if (allowDrag) {
            this.setOnDragListener(odl);
        } else {
            this.setOnDragListener(null);
        }

    }

    private void initRects() {
        mRects = new Rect[DragableGridLayout.this.getChildCount()];
        for (int i = 0; i < DragableGridLayout.this.getChildCount(); i++) {
            View childAt = DragableGridLayout.this.getChildAt(i);
            mRects[i] = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());

        }
    }

    private int getTouchIndex(DragEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        for (int i = 0; i < mRects.length; i++) {
            Rect rect = mRects[i];
            if (rect.contains(x, y)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> getItems() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < this.getChildCount(); i++) {
            TextView tv = (TextView) this.getChildAt(i);
            data.add(tv.getText().toString());
        }
        return data;
    }

    public interface OnItemClickListener {
        void onItemClick(TextView tv);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}
