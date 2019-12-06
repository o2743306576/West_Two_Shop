package com.shop.w2;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:54
 */
public class ShopTest {
    public static void main(String[] args) {

        WestTwoTeaShop westTwoShop=new WestTwoTeaShop();
        Bubble b=new Bubble();
        Coconut c=new Coconut();
        westTwoShop.buy(b);//奶茶店刚开的时候进货
        westTwoShop.buy(c);//奶茶店刚开的时候进货
        SoldOutExcption.soldOutException( westTwoShop);//将过程放在此异常方法中，解决卖奶茶过程中的突发问题
    }
}
