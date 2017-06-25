package com.song.judynews.presenter;

import android.content.Intent;
import android.widget.TextView;

import com.song.judynews.activity.EditModuleActivity;
import com.song.judynews.util.Constants;
import com.song.judynews.widget.DragableGridLayout;

import java.util.ArrayList;

/**
 * Created by Judy on 2017/6/25.
 */

public class EditModulePresenter {
    private EditModuleActivity mActivity;
    private DragableGridLayout mGlMain;
    private DragableGridLayout mGlHide;

    public EditModulePresenter(EditModuleActivity editModuleActivity) {
        mActivity = editModuleActivity;
    }

    public void initData(final DragableGridLayout glMain, final DragableGridLayout glHide, Intent intent) {
        ArrayList<String> showList = intent.getStringArrayListExtra(Constants.SHOW_SET);
        ArrayList<String> hideList = intent.getStringArrayListExtra(Constants.HIDE_SET);

        glMain.setAllowDrag(true);
        glMain.setItems(showList);
        glHide.setItems(hideList);

        glMain.setOnItemClickListener(new DragableGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                glMain.removeView(tv);
                glHide.addItem(tv.getText().toString());
            }
        });

        glHide.setOnItemClickListener(new DragableGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                glMain.addItem(tv.getText().toString());
                glHide.removeView(tv);
            }
        });
    }

    public void saveModule(DragableGridLayout glMain, DragableGridLayout glHide, Intent intent) {
        intent.putStringArrayListExtra(Constants.SHOW_SET, glMain.getItems());
        intent.putStringArrayListExtra(Constants.HIDE_SET, glHide.getItems());
    }
}
