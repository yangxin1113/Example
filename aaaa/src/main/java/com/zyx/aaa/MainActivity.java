package com.zyx.aaa;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.List;

import bean.CommonException;
import bean.JobItem;
import biz.JobItemBiz;
import studenthelp.Constaint;


public class MainActivity extends Activity {
    private Button bt_job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_job = (Button) findViewById(R.id.bt_job);
        bt_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        JobItemBiz biz = new JobItemBiz();
                        List<JobItem> JobItems = null;


                        try {
                            //JobItems = biz.getJobItems(0, Constaint.JOB_catId_ALL, Constaint.JOB_AREA_ALL);
                            JobItems = biz.getJobItems(0, Constaint.JOB_catId_ALL,Constaint.JOB_AREA_ALL);
                        } catch (CommonException e) {
                            e.printStackTrace();
                        }
                        for (JobItem item : JobItems) {
                                System.out.println(item);
                                Log.w("zyx111", item.getAddress());
                            }




                    }
                }).start();
            }

        });
    }
}
