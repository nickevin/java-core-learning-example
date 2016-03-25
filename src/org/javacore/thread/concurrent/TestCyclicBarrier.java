package org.javacore.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * @author zhen.ni
 * @see http://www.iteye.com/topic/980944
 * @see http://www.cnblogs.com/dolphin0520/p/3920397.html
 */
public class TestCyclicBarrier {

  public static void main(final String[] args) {
    TotalService totalService = new TotalServiceImpl();
    CyclicBarrier barrier = new CyclicBarrier(5, new TotalTask(totalService));

    // 实际系统是查出所有省编码code的列表，然后循环，每个code生成一个线程。
    new SubTask(new SubServiceImpl(), barrier, "北京").start();
    new SubTask(new SubServiceImpl(), barrier, "上海").start();
    new SubTask(new SubServiceImpl(), barrier, "广西").start();
    new SubTask(new SubServiceImpl(), barrier, "四川").start();
    new SubTask(new SubServiceImpl(), barrier, "黑龙江").start();
  }
}


/**
 * 主任务：汇总任务
 */
class TotalTask implements Runnable {
  private TotalService totalService;

  TotalTask(final TotalService totalService) {
    this.totalService = totalService;
  }

  @Override
  public void run() {
    // 读取内存中各省的数据汇总，过程略。
    System.out.println("=======================================");
    totalService.count();
    System.out.println("全国汇总结束");
  }
}


/**
 * 子任务：计费任务
 */
class SubTask extends Thread {

  // 计费服务
  private SubService billService;
  private CyclicBarrier barrier;
  // 代码，按省代码分类，各省数据库独立。
  private String code;

  SubTask(final SubService billService, final CyclicBarrier barrier, final String code) {
    this.billService = billService;
    this.barrier = barrier;
    this.code = code;
  }

  @Override
  public void run() {
    System.out.println("开始计算" + code + "省数据");
    billService.calc(code);
    System.out.println(code + "省计算完成，等待其他省完成");
    try {
      // 通知barrier已经完成
      barrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
