package com.example.administrator.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @InjectView(R.id.tv_start)
    TextView tvStart;
    @InjectView(R.id.tv_stop)
    TextView tvStop;
    @InjectView(R.id.tv_bind)
    TextView tvBind;
    @InjectView(R.id.tv_unbind)
    TextView tvUnbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.tv_start, R.id.tv_stop,R.id.tv_bind, R.id.tv_unbind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                //常规启动方式
                Intent intent = new Intent(this, ServiceTest.class);
                startService(intent);
                break;
            case R.id.tv_stop:
                //常规停止方式
                Intent intent1 = new Intent(this, ServiceTest.class);
                stopService(intent1);
                break;
            case R.id.tv_bind:
                Intent intent2 = new Intent(this, ServiceTest.class);
                bindService(intent2,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.tv_unbind:
                unbindService(serviceConnection);
                break;
        }
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };




}
