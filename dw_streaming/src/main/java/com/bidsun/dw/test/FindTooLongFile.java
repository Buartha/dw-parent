package com.bidsun.dw.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Niuxy
 * @className FindTooLongFile
 * @description 文件上传云服务器过程中，文件名过长，导致上传失败，复制文件，再修改文件名
 * @date 2021/6/11 12:06
 */
public class FindTooLongFile {
    public static void main(String[] args) throws IOException {
        FindTooLongFile findTooLongFile = new FindTooLongFile();
        findTooLongFile.changeName("C:\\Users\\EDZ\\Desktop\\标信5.25\\测试文件");
    }

    private static List<File> readFile(String fileDir) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }

        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                readFile(f.getAbsolutePath());
            }
        }
        for (File f1 : fileList) {
            System.out.println(f1.getName());
        }
        return fileList;
    }

    public void changeName(String path) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        int count = 0;
        File file1 = new File(path + "\\newFile\\");
        if (!file1.exists()) {
            file1.mkdir();
        }
        for (int i = 0; i < files.length; i++) {

            String name = files[i].getAbsolutePath();
            if (name.length() > 128) {
                String nameStr = name.substring(path.length(), 90);
                System.out.println("长文件名：" + name);
                System.out.println("修改后文件名：" + nameStr);
                //new File().mkdir(path + "\\newFile\\");
                //boolean newFile = files[i].createNewFile(path +  "\\newFile\\" + nameStr + ".html");

                copyNio(files[i].toString(), path + "\\newFile\\" + nameStr + ".html");
                //boolean newFile1 = new File(path + "\\newFile\\" + nameStr + ".html").createNewFile();
                //boolean b = files[i].renameTo(new File(path + "\\newFile\\" + nameStr + ".html"));
                //System.out.println("改名是否成功：" + b);
                count++;
                //}
            }
        }
        System.out.println(path + "路径，总共修改文件名数量：" + count);
    }

    public static void copyNio(String source, String dest) throws IOException {
        FileChannel input = null;
        FileChannel output = null;

        try {
            input = new FileInputStream(new File(source)).getChannel();
            output = new FileOutputStream(new File(dest)).getChannel();
            output.transferFrom(input, 0, input.size());
        } catch (Exception e) {
            //System.out.println("copyNio", "error occur while copy" + e.toString());
        } finally {
            input.close();
            output.close();

        }
    }
}
