package com.baize.fixdemo;

import android.app.Application;
import android.widget.Toast;

/**
 * author: lxb
 * created on: 2017/11/23 19:04
 * description:
 * copyright:baize ShangHai
 */

public class TestClass {

    public void showToast(String str,Application context){

        Toast.makeText(context,"this is bug" + 2,Toast.LENGTH_SHORT).show();

    }
}
