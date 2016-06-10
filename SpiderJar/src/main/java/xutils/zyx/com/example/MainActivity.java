package xutils.zyx.com.example;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zyx.bean.JobItem;
import com.zyx.biz.JobItemBiz;
import com.zyx.studenthelp.Constaint;


import java.util.List;

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
/*
                NewsItemBiz biz = new NewsItemBiz();
                int currentPage = 1;
                List<NewsItem> newsItems = null;
                try {
                    newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, currentPage);
                } catch (CommonException e) {
                    e.printStackTrace();
                }
                for (NewsItem item : newsItems)
                    {
                        //System.out.println(item);
                        Log.w("zzzz",item.toString());
                    }

                    System.out.println("----------------------");*/


                        JobItemBiz biz = new JobItemBiz();
                        List<JobItem> JobItems = null;
                        try {
                            JobItems = biz.getJobItems(0, Constaint.JOB_catId_ALL, Constaint.JOB_AREA_ALL);
                            for (JobItem item : JobItems)
                            {
                                //System.out.println(item);
                                Log.w("zyx111", item.getAddress());
                            }
                        } catch (com.zyx.bean.CommonException e) {
                            e.printStackTrace();
                        }

            }
        });
    }


}
