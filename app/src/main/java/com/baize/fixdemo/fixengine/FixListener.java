package com.baize.fixdemo.fixengine;

/**
 * author: lxb
 * created on: 2017/11/24 14:55
 * description: 修复监听器
 * copyright:baize ShangHai
 */

public interface FixListener {

    void onSuccess(String success);

    void onFail(String error);

    void onProgress(String progress);
}
