package com.aidlservice.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.aidlservice.IPerson;
import com.aidlservice.Person;

public class ServiceS extends Service{
//    IPerson.Stub person = new IPerson.Stub() {
//        @Override
//        public void setValue(String name) throws RemoteException {
//
//        }
//
//        @Override
//        public String getValue() throws RemoteException {
//            return null;
//        }
//    };
    private IPerson.Stub person = new Person();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return person;
    }
}
