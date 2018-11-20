package com.caomingyu.parcelableclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.caomingyu.parcelableserver.IMyAidlInterface;
import com.caomingyu.parcelableserver.Person;

public class MainActivity extends AppCompatActivity {

    private Button mBtAddPerson;
    IMyAidlInterface iMyAidlInterface;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidlInterface = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.caomingyu.parcelableserver","com.caomingyu.parcelableserver.IRemoteService");
        intent.setComponent(componentName);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private void initView() {
        mBtAddPerson = (Button) findViewById(R.id.bt_add_person);
        mBtAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iMyAidlInterface.addPerson(new Person("lisan",12));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
