package org.javacore.quiz;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileEnumerator {

  private File file;

  public enum Type {
    ALL, DIRECTORY, FILE;
  };

  private List<File> fileList = new ArrayList<File>();

  public FileEnumerator(File file) {
    this.file = file;
  }

  public List<File> listFile() {
    return listFile(Type.ALL);
  }

  public List<File> listFile(Type type) {
    fileList.addAll(Arrays.asList(file.listFiles(new FileTypeFilter(type))));

    return fileList;
  }

  private class FileTypeFilter implements FileFilter {

    private Type type;

    private FileTypeFilter(Type type) {
      this.type = type;
    }

    public boolean accept(File file) {
      deepLoop(file);

      if (type.equals(Type.ALL)) {
        return true;
      }

      if (type.equals(Type.DIRECTORY)) {
        return file.isDirectory();
      }

      return file.isFile();
    }

    private void deepLoop(File file) {
      if (file.isDirectory()) {
        fileList.addAll(Arrays.asList(file.listFiles(new FileTypeFilter(type))));
      }
    }
  }

  public static void main(String[] args) {
    List<File> flist = new FileEnumerator(new File("D:\\我的文档")).listFile(FileEnumerator.Type.FILE);
    for (File file : flist) {
      System.out.println(file.getPath());
    }
  }
}
