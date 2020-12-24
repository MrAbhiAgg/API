package com.example.testserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_OUTPUT = "LOG_OUTPUT";
    public static final String JSON_URL ="https://fortnite-api.theapinetwork.com/store/get/";
    TextView tvload;
    Button startbtn;
    boolean isNetwork;
    private BroadcastReceiver mreciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra(MyIntentService.SERVICE_PAYLOAD);
            Logoutput(data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvload = findViewById(R.id.tvload);
        startbtn = findViewById(R.id.startbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCode();
            }
        });
        isNetwork = NetworkHelper.isNetworkAvailable(this);
//        Logoutput("Network "+isNetwork);


    }

    public void runCode(){
        if(isNetwork){
            Intent intent = new Intent(MainActivity.this,MyIntentService.class);
            intent.setData(Uri.parse(JSON_URL));
            startService(intent);
        }else{
            Toast.makeText(this,"Network not available...!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Logoutput(String data){
        Log.d(LOG_OUTPUT,data);
        tvload.append(data+"\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mreciever, new IntentFilter(MyIntentService.SERVICE_MESSAGE));
    }
}