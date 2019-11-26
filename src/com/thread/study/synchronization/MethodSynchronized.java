package com.thread.study.synchronization;

/**
 * 测试方法加synchronized关键字效果
 * 方法上加synchronized 保证同一时间只有一个线程在执行
 * 加在非静态方法上 相当于synchronized(this) 不影响其他线程实例
 */
public class MethodSynchronized implements Runnable {

    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }

    public void increase1(){
        i++;
    }
    @Override
    public void run(){
        for (int j =0 ; j<100000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MethodSynchronized test = new MethodSynchronized();
        MethodSynchronized test1 = new MethodSynchronized();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
