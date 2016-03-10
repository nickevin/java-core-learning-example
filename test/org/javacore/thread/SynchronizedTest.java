package org.javacore.thread;

public class SynchronizedTest implements Runnable {

  private Foo foo = new Foo();

  public static void main(String[] args) {
    SynchronizedTest r = new SynchronizedTest();
    Thread ta = new Thread(r, "Thread-A");
    Thread tb = new Thread(r, "Thread-B");
    ta.start();
    tb.start();
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      this.fix(30);

      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX());
    }
  }

  public int fix(int y) {
    return foo.fix(y);
  }

  class Foo {

    private int x = 100;

    public int getX() {
      return x;
    }

    public int fix(int y) {
      System.out.print(Thread.currentThread().getName() + ": " + x + " - " + y + " = ");
      x = x - y;
      System.out.println(Thread.currentThread().getName() + ": " + x);
      return x;
    }
  }

}
