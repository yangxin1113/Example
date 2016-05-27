package com.zyx.map;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends Activity implements OnClickListener{

    private Button bt_local;
    private Button bt_guide;
    private Button bt_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_local = (Button) findViewById(R.id.bt_local);
        bt_guide = (Button) findViewById(R.id.bt_guide);
        bt_city = (Button) findViewById(R.id.bt_city);
        bt_local.setOnClickListener(this);
        bt_guide.setOnClickListener(this);
        bt_city.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_local:
                Intent i = new Intent(MainActivity.this,LocationDemo.class);
                startActivity(i);
                break;
            case R.id.bt_guide:
                i = new Intent(MainActivity.this,RoutePlanDemo.class);
                startActivity(i);
                break;
            case R.id.bt_city:
                i = new Intent(MainActivity.this,DistrictSearchDemo.class);
                startActivity(i);
                break;
        }

    }
}
