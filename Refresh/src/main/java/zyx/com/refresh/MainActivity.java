package zyx.com.refresh;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Arrays;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;


public class MainActivity extends AppCompatActivity {

    private ListView lvMain;
    private BaseAdapter adapter;

    private PtrClassicFrameLayout ptr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lv_main);
        ptr = (PtrClassicFrameLayout) findViewById(R.id.ptr_main);
        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                getData();
                ptr.refreshComplete();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ptr.autoRefresh();
            }
        }, 100);
    }

    private void getData() {
        adapter = new ListViewAdapter(MainActivity.this, Arrays.asList(Constants.SMALL_IMAGE_URLS));
        lvMain.setAdapter(adapter);
    }

}
