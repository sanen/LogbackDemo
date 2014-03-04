package com.demo;

import java.io.FileWriter;

public class TestBat {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        try {
              FileWriter writer = new FileWriter("c:\\openexcel.bat ");
              writer.write("@echo   off ");
              writer.write("\r\n ");
              writer.write("C:");
              writer.write("\r\n ");
              // C:\\Program Files\\Internet Explorer\\ 是指ie的路径
              writer.write("cd C:\\Program Files\\Internet Explorer\\");
              writer.write("\r\n ");
              // C:\\1.xls 要打开的Excel 文件
              writer.write("iexplore.exe   C:\\1.xlsx");
              writer.write("\r\n ");
              writer.write("@echo   on ");
              writer.close();
              p = rn.exec("cmd.exe /C  c:\\openexcel.bat");
          }
          catch (Exception e1) {
                 e1.printStackTrace();
          }
      }
}
