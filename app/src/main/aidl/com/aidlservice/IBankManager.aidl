// IBookManager.aidl
package com.aidlservice;

// Declare any non-default types here with import statements
import com.aidlservice.MyBank.Bank;
interface IBankManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    List<Bank> getBanks();
    //in 表示输入参数，即服务端可以修改该类型
    //out 表示输出参数，即客户端可以修改该类型，客户端不行
    //inout 表示客户端和服务端都可以修改该类型
     //inout不要乱用，用的不好会加大系统开销。
    void addBank(in Bank bank);
}
