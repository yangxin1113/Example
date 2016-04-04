package wdb.zyx.com.example;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView lv_property;
    private PropertyAdapter propertyAdapter;
    private ArrayList<HashMap<String,Object>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_property = (ListView)findViewById(R.id.lv_property);
        getData();
        propertyAdapter = new PropertyAdapter(new Handler(), getApplicationContext(),getData());
        lv_property.setAdapter(propertyAdapter);
    }

    private ArrayList<HashMap<String, Object>> getData() {
        mList = new ArrayList<HashMap<String, Object>>();

        HashMap<String,Object> map = new  HashMap<String,Object>();
        map.put("type","颜色");
        List<String> list = new ArrayList<String>();
        list.add("红色");
        list.add("绿色");
        map.put("lable", list);

        mList.add(map);

        HashMap<String,Object> map2 = new  HashMap<String,Object>();
        map2.put("type","内存");
        List<String> list2 = new ArrayList<String>();
        list2.add("红色");
        list2.add("绿色");
        map2.put("lable", list2);

        mList.add(map2);

        return mList;
    }


}
