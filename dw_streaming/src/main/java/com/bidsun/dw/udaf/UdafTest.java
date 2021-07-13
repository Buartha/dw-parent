package com.bidsun.dw.udaf;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UdafTest {
    public static void main(String[] args) {
        String str1 = "乔丹,科比,悟空,大师兄,热水壶";
        String str2 = "热水壶,绝地求生,悟空,罗辑";
        int sameNum = countStr(str1, str2);
        /*-----------------------------*/
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");

        /*-----------------------------*/
        System.out.println("相同字符的个数为" + GetNum(arr1, arr2));



    }

    public static int countStr(String str1, String str2) {
        int counter = 0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        }
        while (str1.indexOf(str2) != -1) {
            counter++;
            str1 = str1.substring(str1.indexOf(str2) + str2.length());
        }
        return counter;
    }

    public static int GetNum(String a[], String b[]) {
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {

                if (a[i].equals(b[j])) {
                    num++;
                    break;
                }

            }
        }
        return num;
    }
}
