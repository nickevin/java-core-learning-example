package org.javacore.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhen.ni
 * @see http://www.importnew.com/15731.html
 * @see http://www.iteye.com/topic/1002652
 */
public class TestCountDownLatch {

  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static void main(final String[] args) {
    CountDownLatch latch = null;

    try {
      latch = new CountDownLatch(2);// 两个工人的协作

      Worker worker1 = new Worker("zhang san", 5000, latch);
      Worker worker2 = new Worker("li si", 8000, latch);
      worker1.start();//
      worker2.start();//

      latch.await();// 等待所有工人完成工作
      System.out.println("工作完成： " + sdf.format(new Date()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  static class Worker extends Thread {
    String workerName;
    int workTime;
    CountDownLatch latch;

    public Worker(final String workerName, final int workTime, final CountDownLatch latch) {
      this.workerName = workerName;
      this.workTime = workTime;
      this.latch = latch;
    }

    @Override
    public void run() {
      System.out.println("工人： " + workerName + " 开工： " + sdf.format(new Date()));
      doWork();// 工作了
      System.out.println("工人 " + workerName + " 完工： " + sdf.format(new Date()));
      latch.countDown();// 工人完成工作，计数器减一

    }

    private void doWork() {
      try {
        Thread.sleep(workTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
