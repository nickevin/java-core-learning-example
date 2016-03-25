package org.javacore.thread.threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:私有变量会被所有线程共享 Created by bysocket on 16/3/8.
 */
public class UnsafeTask implements Runnable {

  private static final AtomicInteger nextId = new AtomicInteger(0);

  public int getThreadId() {
    return nextId.getAndIncrement();
  }

  @Override
  public void run() {

    System.out.printf("Starting Thread:%s : %s\n", Thread.currentThread().getId(), getThreadId());
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("Finish Thread:%s : %s\n", Thread.currentThread().getId(), getThreadId());
  }
}
