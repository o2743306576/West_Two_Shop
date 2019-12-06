package com.shop.w2;

import java.util.Scanner;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:52
 */
public class SoldOutExcption extends Exception {
    public  static void soldOutException(WestTwoTeaShop westTwoShop)
    {
        Scanner sc=new Scanner(System.in);
        int result=0;
        while(result==0) {
            try {
                westTwoShop.makeAndSoldMilktea();
            } catch (IndexOutOfBoundsException e) {

                westTwoShop.printCunHuo();
            } finally {
                westTwoShop.printCunHuo();
                System.out.println("输入数字0继续，若输入的数字不是1停止");
                result =sc.nextInt();
            }
        }

    }
}
