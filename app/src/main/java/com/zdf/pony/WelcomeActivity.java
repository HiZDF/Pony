package com.zdf.pony;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 欢迎界面
 */
public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private int reclen = 5; //跳过倒计时显示5秒
    private TextView tv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*==========设置全屏======必须在setContentView前面=======*/
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        initView();
        timer.schedule(task, 1000, 1000);
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                jump();
            }
        }, 5000);

    }

    private void initView() {
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    reclen--;
                    tv.setText(reclen + "跳过");
                    if (reclen < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);
                    }
                }
            });
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                jump();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }

    private void jump() {
        // 获取sharedpreferences对象
        SharedPreferences share = getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        // 判断是否是之前有登录过
        if (share.getBoolean("LoginBool", false)) {
            // 跳转到注销页面并销毁当前activity
            Intent intent = new Intent(WelcomeActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            //从闪屏界面跳转到首界面
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}