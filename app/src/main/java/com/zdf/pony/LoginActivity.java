package com.zdf.pony;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.gson.Gson;
import com.zdf.pony.pojo.Login;
import com.zdf.pony.utils.OkHttpUtils;
import okhttp3.*;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.input_account);
        etPassword = findViewById(R.id.input_password);
        AppCompatButton loginBtn = findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //请求地址不能使用127.0.0.1 和Android自身地址冲突
                String loginAddress = "http://192.168.1.51:8081/commonLogin";
                String loginAccount = etAccount.getText().toString();
                String loginPassword = etPassword.getText().toString();
                loginWithOkHttp(loginAddress, loginAccount, loginPassword);
                break;
            default:
                break;
        }
    }

    //实现登录
    public void loginWithOkHttp(String address, String account, String password) {
        this.loginWithOkHttp(address, account, password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson  = new Gson();
                        Login  login  =   gson.fromJson(responseData,Login.class);






                        if (login.getCode()==200) {
                            Toast.makeText(LoginActivity.this, responseData+ login.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, responseData, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //登录
    public void loginWithOkHttp(String address, String account, String password, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("account", account)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                // System.getProperty("http.agent")  获取userAgent 这里写死了   实际情况使用 OkHttputils.getUserAgent(context)
                .removeHeader("User-Agent").addHeader("User-Agent",  System.getProperty("http.agent"))
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

}


