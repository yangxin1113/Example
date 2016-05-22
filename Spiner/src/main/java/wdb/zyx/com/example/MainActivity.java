package wdb.zyx.com.example;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

   /* private List<String> mListType = new ArrayList<String>();  //类型列表
    private TextView mTView;
    private SpinerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTView = (TextView) findViewById(R.id.tv_value);


        //初始化数据
        String[] names = getResources().getStringArray(R.array.s_firstPay);
        for(int i = 0; i < names.length; i++){
            mListType.add(names[i]);
        }

        mAdapter = new SpinerAdapter(this,mListType);
        mAdapter.refreshData(mListType,0);

        //显示第一条数据
        //mTView.setText(names[0]);

        //初始化PopWindow
        mSpinerPopWindow = new SpinerPopWindow1(this);
        mSpinerPopWindow.setAdatper(mAdapter);
        mSpinerPopWindow.setItemListener(this);

    }


    //设置PopWindow
    private SpinerPopWindow1 mSpinerPopWindow;
    private void showSpinWindow(){
        Log.e("", "showSpinWindow");
        mSpinerPopWindow.setWidth(mTView.getWidth());
        mSpinerPopWindow.showAsDropDown(mTView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_drop:
                Log.e("zyx....", mListType.toString());
                showSpinWindow();
                break;
        }
    }

    *//* (non-Javadoc)
     * @see org.gaochun.adapter.SpinerAdapter.IOnItemSelectListener#onItemClick(int)
     *//*
    @Override
    public void onItemClick(int pos) {
        // TODO Auto-generated method stub
        if (pos >= 0 && pos <= mListType.size()){
            String value = mListType.get(pos);
            mTView.setText(value.toString());
        }
    }*/

    private SpinerPopWindow<String> mSpinerPopWindow;
    private List<String> list;
    private TextView tvValue;
    private Button bt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        tvValue = (TextView) findViewById(R.id.tv_value);
        tvValue.setOnClickListener(clickListener);
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list,itemClickListener);
        mSpinerPopWindow.setOnDismissListener(dismissListener);
        bt_button = (Button) findViewById(R.id.bt_button);
    }

    /**
     * 监听popupwindow取消
     */
    private OnDismissListener dismissListener=new OnDismissListener() {
        @Override
        public void onDismiss() {
            setTextImage(R.mipmap.icon_down);
        }
    };

    /**
     * popupwindow显示的ListView的item点击事件
     */
    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            mSpinerPopWindow.dismiss();
            tvValue.setText(list.get(position));
            Toast.makeText(MainActivity.this, "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
        }
    };

    /**
     * 显示PopupWindow
     */
    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_value:
                    mSpinerPopWindow.setWidth(tvValue.getWidth());
                    mSpinerPopWindow.showAsDropDown(tvValue);
                    setTextImage(R.mipmap.icon_up);
                    break;
            }
        }
    };

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("test:" + i);
        }
    }

    /**
     * 给TextView右边设置图片
     * @param resId
     */
    private void setTextImage(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tvValue.setCompoundDrawables(null, null, drawable, null);
    }


}
