package com.bidsun.dw.test;

import java.io.File;

/**
 * @author Niuxy
 * @className RenameFilename
 * @description TODO
 * @date 2021/5/18 0:42
 */

public class RenameFilename {
    static File file;
    static String path = "E:/MINE/senior/face/";
    static String picName;
    static String newName;

    public static void main(String[] args) {
        singleChange();//改一个文件
        moreChange();//循环多个
    }

    static void singleChange() {
        picName = "big0.bmp";
        newName = "big0.jpg";
        file = new File(path + picName); //指定文件名及路径

        if (file.renameTo(new File(path + newName))) {
            System.out.println("修改成功!");
        } else {
            System.out.println("修改失败");
        }

    }

    static void moreChange() {
        for (int i = 1; i <= 100000000; i++) {
            if (i > 99) {
                picName = "政府采购0" + i + ".bmp";
                newName = "政府采购0" + i + ".jpg";
            } else if (i > 9) {
                picName = "政府采购00" + i + ".bmp";
                newName = "政府采购00" + i + ".jpg";
            } else {
                picName = "政府采购000" + i + ".bmp";
                newName = "政府采购000" + i + ".jpg";
            }
            file = new File(path + picName); //指定文件名及路径

            //改名
            if (file.renameTo(new File(path + newName))) {
                System.out.println("修改" + i + "成功!");
            } else {
                System.out.println("修改失败");
            }
        }
    }
}

