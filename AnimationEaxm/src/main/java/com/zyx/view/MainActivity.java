package com.zyx.view;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener{
    private AnimationDrawable animationDrawable;
    private ImageView imageView;
    private LinearLayout ll_bg;
    private Button bt_scale;
    private Button bt_rotate;
    private Button bt_translate;
    private Button bt_alpha;
    private Button bt_frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iView);
        ll_bg = (LinearLayout) findViewById(R.id.ll_bg);

        bt_scale = (Button) findViewById(R.id.bt_scale);
        bt_alpha = (Button) findViewById(R.id.bt_alpha);
        bt_rotate = (Button) findViewById(R.id.bt_rotate);
        bt_translate = (Button) findViewById(R.id.bt_translate);
        bt_frame = (Button) findViewById(R.id.bt_frame);
        bt_scale.setOnClickListener(this);
        bt_alpha.setOnClickListener(this);
        bt_rotate.setOnClickListener(this);
        bt_translate.setOnClickListener(this);
        bt_frame.setOnClickListener(this);
        ll_bg.setBackgroundResource(R.drawable.frame);
        animationDrawable = (AnimationDrawable) ll_bg.getBackground();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_alpha:

                Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                imageView.startAnimation(animation);
                break;
            case R.id.bt_scale:

                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                imageView.startAnimation(animation);
                break;
            case R.id.bt_translate:

                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                imageView.startAnimation(animation);
                break;
            case R.id.bt_rotate:

                animation = AnimationUtils.loadAnimation(this, R.anim.rorate);
                imageView.startAnimation(animation);
                break;
            case R.id.bt_frame:
                imageView.setVisibility(View.INVISIBLE);
                animationDrawable.start();
                break;
        }
    }
}
