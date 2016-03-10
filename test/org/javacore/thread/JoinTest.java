package org.javacore.thread;

/**
 * @author zhen.ni
 * @see http://www.blogjava.net/jnbzwm/articles/330549.html
 */
public class JoinTest {

  public static void main(String[] args) {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " start.");

    CustomThread1 t1 = new CustomThread1();
    CustomThread t = new CustomThread(t1);

    try {
      t1.start();
      Thread.sleep(2000);
      t.start();
      t.join(); // 确保 t 结束后，main 线程进行执行
    } catch (Exception e) {
      System.out.println("Exception from main");
    }

    System.out.println(threadName + " end!");
  }

}


class CustomThread1 extends Thread {
  public CustomThread1() {
    super("[CustomThread1]");
  };

  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " start.");
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println(threadName + " loop at " + i);
        Thread.sleep(1000); // 休眠，让其他线程进入可运行状态
      }
      System.out.println(threadName + " end.");
    } catch (Exception e) {
      System.out.println("Exception from " + threadName + ".run");
    }
  }
}


class CustomThread extends Thread {
  CustomThread1 t1;

  public CustomThread(CustomThread1 t1) {
    super("[CustomThread]");
    this.t1 = t1;
  }

  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " start.");
    try {
      t1.join(); // 确保 t1 结束后，t 继续执行
      System.out.println(threadName + " end.");
    } catch (Exception e) {
      System.out.println("Exception from " + threadName + ".run");
    }
  }
}
