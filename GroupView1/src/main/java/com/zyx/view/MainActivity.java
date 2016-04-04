package com.zyx.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_property;
    private Adapter propertyAdapter;
    private ArrayList<HashMap<String,Object>> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_property = (ListView)findViewById(R.id.lv_property);
        getData();
        propertyAdapter = new Adapter(getApplicationContext(),getData());
        lv_property.setAdapter(propertyAdapter);
       // Log.i("sfdsfsdfsd", propertyAdapter.getSelectProMap().toString()+"fdsgsd");
        /*Toast.makeText(getApplicationContext(),propertyAdapter.getSelectProMap().toString(), Toast.LENGTH_LONG);*/
    }

    private ArrayList<HashMap<String, Object>> getData() {
        mList = new ArrayList<HashMap<String, Object>>();

        HashMap<String,Object> map = new  HashMap<String,Object>();
        map.put("type","颜色");
        List<String> list = new ArrayList<String>();
        list.add("红色分散方式");
        list.add("绿色");
        list.add("绿色");
        list.add("红色分散方式");
        list.add("绿色");
        list.add("绿色");
        list.add("绿色");
        list.add("红色分散方式");
        list.add("红色分散方式");
        list.add("红色分散方式");
        map.put("lable", list);

        mList.add(map);

        HashMap<String,Object> map2 = new  HashMap<String,Object>();
        map2.put("type", "内存");
        List<String> list2 = new ArrayList<String>();
        list2.add("红色");
        list2.add("绿色发到谁的");

        list.add("绿色");
        list.add("绿色");
        list.add("红色分散方式");
        map2.put("lable", list2);

        mList.add(map2);

        return mList;
    }

    public void btn(View v){
        Log.i("sfdsfsdfsd", propertyAdapter.getSelectProMap().get("内存"));

    }
}
