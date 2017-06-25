package com.song.judynews.presenter;

import android.content.Intent;
import android.content.SharedPreferences;

import com.song.judynews.activity.EditModuleActivity;
import com.song.judynews.activity.HomeActivity;
import com.song.judynews.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Judy on 2017/6/25.
 */

public class HomePresenter {
    private HomeActivity mActivity;
    private ArrayList<String> mShowList;
    private ArrayList<String> mHideList;

    public HomePresenter(HomeActivity homeActivity) {
        mActivity = homeActivity;
    }

    public void initData() {
        SharedPreferences sp = mActivity.getSharedPreferences(Constants.SP_HOME, MODE_PRIVATE);
        String showStr = sp.getString(Constants.SHOW_SET, Constants.DEF_SHOW_SET);
        String hideStr = sp.getString(Constants.HIDE_SET, Constants.DEF_HIDE_SET);

        try {
            JSONArray showArray = new JSONArray(showStr);
            JSONArray hideArray = new JSONArray(hideStr);

            mShowList = new ArrayList<>();
            mHideList = new ArrayList<>();

            for (int i = 0; i < showArray.length(); i++) {
                mShowList.add(showArray.getString(i));
            }

            for (int i = 0; i < hideArray.length(); i++) {
                mHideList.add(hideArray.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Intent toEditModule() {
        initData();
        Intent intent = new Intent(mActivity, EditModuleActivity.class);
        intent.putExtra(Constants.SHOW_SET, mShowList);
        intent.putExtra(Constants.HIDE_SET, mHideList);
        return intent;
    }

    public void saveData(ArrayList<String> showList, ArrayList<String> hideList) {
        SharedPreferences.Editor editor = mActivity.getSharedPreferences(Constants.SP_HOME, MODE_PRIVATE).edit();
        JSONArray showArray = new JSONArray();
        JSONArray hideArray = new JSONArray();

        for (String str : showList) {
            showArray.put(str);
        }

        for (String str : hideList) {
            hideArray.put(str);
        }

        editor.putString(Constants.SHOW_SET, showArray.toString());
        editor.putString(Constants.HIDE_SET, hideArray.toString());
        editor.apply();

    }
}
