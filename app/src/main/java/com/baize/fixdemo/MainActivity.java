package com.baize.fixdemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.baize.fixdemo.fixengine.FileUtil;
import com.baize.fixdemo.fixengine.FixDexUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){

        findViewById(R.id.fix_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fixDexBug();
            }
        });

        findViewById(R.id.show_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TestClass().showToast(null,getApplication());

            }
        });
    }

    private void fixDexBug() {
        System.out.println("44----------------------开始修复:");
        try {

            String dexPath= Environment.getExternalStorageDirectory()+"/classes_fix.dex";
           /* FileUtil.copyAssetsTo(this,"classes_fix.dex",dexPath);
            File file=new File(dexPath);
            if (file.exists()) {
                FixDexUtil fixUtil = new FixDexUtil(this);
                fixUtil.fixDex(file.getAbsolutePath());
                System.out.println("53----------------------修复成功!:");

            }*/

            FixDexUtil fixUtil = new FixDexUtil(this);
            fixUtil.fixDex(dexPath);
            System.out.println("53----------------------修复成功!:");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("59----------------------修复失败:"+ex);

        }
        System.out.println("62----------------------修复结束。。。。:");
    }


}
