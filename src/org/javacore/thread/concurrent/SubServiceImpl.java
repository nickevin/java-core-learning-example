package org.javacore.thread.concurrent;

public class SubServiceImpl implements SubService {

  @Override
  public void calc(final String code) {
    System.out.println("正在计算" + code + "省数据...");

  }

}
