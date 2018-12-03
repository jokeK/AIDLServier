package com.aidlservice;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aidlservice.MyBank.Bank;
import com.aidlservice.MyBank.BankManager;

public class MainActivity extends AppCompatActivity {
//    private IPerson person;
//    ServiceConnection conn = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            Toast.makeText(MainActivity.this,"Service创建成功",Toast.LENGTH_SHORT).show();
//            person = IPerson.Stub.asInterface(service);
//            try {
//                person.setValue("miK");
//                Toast.makeText(MainActivity.this,"赋值成功",Toast.LENGTH_SHORT).show();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this,ServiceS.class);
//        //intent.setAction("ServiceAidl");
//        intent.setPackage("com.aidlservier");
//        bindService(intent,conn, Service.BIND_AUTO_CREATE);
        Button btn = findViewById(R.id.button);
        BankManager.getIntence().connectService(this);
       final Bank bank =  new Bank();
       bank.setId(1);
       bank.setName("中国工商银行");
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   BankManager.getIntence().getIBankManager().addBank(bank);
               } catch (RemoteException e) {
                   e.printStackTrace();
               }
           }
       });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BankManager.getIntence().unBinderService(MainActivity.this);
    }
}
