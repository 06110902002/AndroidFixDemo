package com.baize.fixdemo;

import android.app.Application;
import android.util.Log;

import com.baize.fixdemo.fixengine.FixDexUtil;

/**
 * author: lxb
 * created on: 2017/11/24 11:17
 * description:
 * copyright:baize ShangHai
 */

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        loadFixDexRes();
    }

    private void loadFixDexRes(){

        try {
            FixDexUtil fixDexUtil=new FixDexUtil(this);
            fixDexUtil.loadDexRes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
