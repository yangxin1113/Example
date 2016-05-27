package com.zyx.custview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    private Button bt_fitst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();
    }

    private void init() {
        bt_fitst = (Button) findViewById(R.id.bt_fitst);

    }

    private void event(){
        bt_fitst.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bt_fitst:
                Intent i =   new Intent(MainActivity.this, FirstActivity.class);
                startActivity(i);
                break;
        }

    }
}
