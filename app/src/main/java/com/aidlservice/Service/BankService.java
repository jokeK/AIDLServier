package com.aidlservice.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.aidlservice.IBankManager;
import com.aidlservice.MyBank.Bank;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BankService extends Service {
    private CopyOnWriteArrayList<Bank> banks = new CopyOnWriteArrayList<>();
    IBankManager.Stub bankManager = new IBankManager.Stub() {
        @Override
        public List<Bank> getBanks() throws RemoteException {
            //返回给客户端的数据
            synchronized (this){
                if (banks!=null)
                    return banks;
                return new CopyOnWriteArrayList<Bank>();
            }
        }

        @Override
        public void addBank(Bank bank) throws RemoteException {
            synchronized (this){
                if (banks==null)
                    banks =  new CopyOnWriteArrayList<>();
                if (bank == null)
                    return;
                banks.add(bank);
            }

        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bankManager;
    }
}
