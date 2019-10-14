package com.atguigu.demo;

import com.sun.org.apache.xerces.internal.xs.PSVIProvider;
import org.omg.Messaging.SyncScopeHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author IanHu
 * @dare 2019/10/14 - 9:50
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 */
class Resource //资源类
{
    //方式二：
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private volatile Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 读取开始");
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取开始");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    //*************************************************************
    //方式一：
  /*  private Lock lock = new ReentrantLock();
    private volatile Map<String,String> map = new HashMap<>();
    public void put(String key,String value){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void get(String key){
        lock.lock();
        try {
            String result = null;
            System.out.println(Thread.currentThread().getName()+"\t读取开始");
            result =  map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取开始" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }*/

}

public class ReentrantReadWriteLockDemo {
    //线程操作资源类的写入方法

    public static void main(String[] args) {
        final Resource resource = new Resource();
        for (int i = 0; i < 5; i++) {
            int finnall = i;
            new Thread(() -> {
                resource.put(finnall + "", finnall + "");
            }, String.valueOf(i)).start();
        }
        //线程操作资源类的写入方法
        for (int i = 0; i < 5; i++) {
            int finall = i;
            new Thread(() -> {
                resource.get(finall + "");
            }, String.valueOf(i)).start();
        }

    }


}
