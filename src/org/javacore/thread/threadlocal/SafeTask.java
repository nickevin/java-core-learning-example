package org.javacore.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:看类里面说明 Created by bysocket on 16/3/8.
 */
public class SafeTask implements Runnable {

  // Atomic integer containing the next thread ID to be assigned
  private static final AtomicInteger nextId = new AtomicInteger(0);

  // Thread local variable containing each thread's ID
  private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return nextId.getAndIncrement();
    }
  };

  // Returns the current thread's unique ID, assigning it if necessary
  public int getThreadId() {
    return threadId.get();
  }

  // Returns the current thread's starting timestamp
  private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
    @Override
    protected Date initialValue() {
      return new Date();
    }
  };

  @Override
  public void run() {
    System.out.printf("\nStarting Thread: %s : %s, %sn", Thread.currentThread().getId(),
        getThreadId(), startDate.get());
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("\nThread Finished: %s : %s, %sn", Thread.currentThread().getId(),
        getThreadId(), startDate.get());
  }
}
