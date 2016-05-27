package com.zyx.custview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zyx.custview.widget.FirstCustview;

public class FirstActivity extends Activity implements OnClickListener{

    private FirstCustview mCustomView;// 我们的自定义View

    private int radiu;// 半径值


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 设置自定义View的半径值
            mCustomView.setRadiu(radiu);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstview);
        init();
        event();
    }

    private void init() {
        mCustomView = (FirstCustview) findViewById(R.id.fir_view);

        /*
         * 开线程
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*
                 * 确保线程不断执行不断刷新界面
                 */
                while (true) {
                    try {
                        /*
                         * 如果半径小于200则自加否则大于200后重置半径值以实现往复
                         */
                        if (radiu <= 200) {
                            radiu += 10;

                            // 发消息给Handler处理
                            mHandler.obtainMessage().sendToTarget();
                        } else {
                            radiu = 0;
                        }

                        // 每执行一次暂停40毫秒
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private void event(){

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){


        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 界面销毁后清除Handler的引用
        mHandler.removeCallbacksAndMessages(null);
    }
}
