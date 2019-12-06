package com.shop.w2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:52
 */
public class WestTwoTeaShop implements Shop{
    protected     long  startTimeCoconut;//进椰果时间
    protected    long  startTimeBubble;//进珍珠时间
    protected   long  endTimeCoconut;//卖椰果奶茶时间
    protected   long  endTimeBubble;//卖椰果时间
    ArrayList<Integer> arrayListCoconut=new ArrayList<>();
    ArrayList<Integer> arrayListBubble=new ArrayList<>();
    protected   long amountCoconut=0;//椰果数量
    protected   long amountBubble=0;//珍珠数量
    @Override //添加配料(进货)
    public void buy(Ingredient ingredient){

        if(ingredient instanceof Bubble) {
            for(int i=1,j=1;i<=50;i++)
            {arrayListBubble.add(j);}
            amountBubble+=arrayListBubble.size();
            System.out.println( "珍珠进货成功。"+"进货数量：50");
            startTimeBubble = System.currentTimeMillis();
            System.out.println("珍珠进货时间：" + Calendar.getInstance().getTime());
        } else if(ingredient instanceof  Coconut)
        {
            for(int i=1,j=1;i<=50;i++)
            {   arrayListCoconut.add(j);}
            amountCoconut=arrayListCoconut.size();
            System.out.println( "椰果进货成功。"+"进货数量：50");
            startTimeBubble = System.currentTimeMillis();
            System.out.println("椰果进货时间：" + Calendar.getInstance().getTime());
        }

    }
    public void makeAndSoldMilktea()//制作和卖奶茶
    {
        System.out.println("您想要什么奶茶");
        System.out.println("提供两种奶茶：椰果奶茶和珍珠奶茶" );
        System.out.println("输入1为购买珍珠奶茶，输入2为购买椰果奶茶，输入12为购买两种奶茶，下面请输入1或2或12");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if(a==1)
        {
            Bubble bubble=new Bubble();
            System.out.println("请输入您想要购买的奶茶数量");
            int n=sc.nextInt();
            System.out.println("准备制作珍珠奶茶");
            addIngredient1(bubble );
            if(n>amountBubble){sentenceAmount0(bubble, n);}
            else  { System.out.println("您的"+n+"杯珍珠奶茶！！");
                for (int i = 0,j=arrayListBubble.size()-1; i < n; i++,j--) {
                    arrayListBubble.remove(j);
                } }
        }else if(a==2)
        {
            Coconut coconut=new Coconut();
            System.out.println("请输入您想要购买的奶茶数量");
            int n=sc.nextInt();
            System.out.println("准备制作椰果奶茶");
            addIngredient1(coconut );
            if(n>amountCoconut) sentenceAmount0(coconut, n);
            else {
                for (int i = 0,j=arrayListCoconut.size()-1; i < n; i++,j--) {
                    arrayListCoconut.remove(j);
                }
                System.out.println("您的" + n + "杯椰果奶茶！！");

            }       } else if(a==12)
        {
            Bubble bubble=new Bubble();
            Coconut coconut=new Coconut();
            System.out.println("请输入您想要购买的珍珠奶茶数量和椰果奶茶数量");
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            System.out.println("准备制作珍珠奶茶");
            addIngredient1(bubble );
            System.out.println("准备制作椰果奶茶");
            addIngredient1(coconut );
            if (n1>amountBubble){sentenceAmount0(bubble, n1);}
            else {
                for (int i = 0,j=arrayListBubble.size()-1; i < n1; i++,j--) {
                    arrayListBubble.remove(j);
                }
                System.out.println("您的"+n1+"杯珍珠奶茶！！");
            }
            if(n2>amountCoconut){sentenceAmount0(coconut, n2);}
            else{
                for (int i = 0,j=arrayListCoconut.size()-1; i < n2; i++,j--) {
                    arrayListCoconut.remove(j);
                }
                System.out.println("您的"+n2+"杯椰果奶茶！！");
            }
        }


    }
    public  void addIngredient1(Ingredient ingredient )//添加配料
    {

        if(ingredient instanceof Bubble)
        {
            sentenceTime( ingredient);
            Bubble bubble=(Bubble) ingredient;
            bubble.addIngredient();
        }
        if(ingredient instanceof Coconut)
        {
            sentenceTime( ingredient);
            Coconut coconut=(Coconut) ingredient;
            coconut.addIngredient();
        }

    }
    public void  sentenceTime(Ingredient ingredient)//判断配料是否过期,若过期，扔掉过期配料并进货
    {
        if(ingredient instanceof Bubble)
        {
            endTimeBubble=System.currentTimeMillis();
            long times=endTimeBubble-startTimeBubble;
            if(times<=ingredient.expiryDate*24*60*60*1000)
            {
                ingredient.ThrowAwayIngredient();
                for (int i = arrayListBubble.size()-1; i >0; i--) {
                    arrayListBubble.remove(i);
                }
                jinhuo( ingredient);//配料不足时立即进货
            }} else if(ingredient instanceof  Coconut)
        {
            endTimeCoconut=System.currentTimeMillis();
            long times=endTimeCoconut-startTimeCoconut;
            if(times<=ingredient.expiryDate*24*60*60*1000)
            {
                ingredient.ThrowAwayIngredient();
                for (int i = arrayListCoconut.size()-1; i >0; i--) {
                    arrayListCoconut.remove(i);
                }
                jinhuo( ingredient);//配料不足时立即进货
            }
        }

    }
    public  void  sentenceAmount0(Ingredient ingredient,int x)//判断是否缺货
    {
        if (ingredient instanceof Bubble) {
            if (x > amountBubble) {
                jinhuo( ingredient);//配料不足时立即进货

            } else if(x<=amountBubble){
                for (int i = 0,j=arrayListBubble.size()-1; i < x; i++,j--) {
                    arrayListBubble.remove(j);
                }
                amountBubble=arrayListBubble.size();
                System.out.println(amountBubble);
            }
        } else if (ingredient instanceof Coconut) {

            if (x > amountCoconut) {
                jinhuo( ingredient);//配料不足时立即进货
            } else {
                for (int i = 0,j=arrayListCoconut.size()-1; i < x; i++,j--) {
                    arrayListCoconut.remove(j);
                }
                amountCoconut=arrayListCoconut.size();

            }
        }
    }
    /* public  void maketea(Ingredient ingredient)//制作奶茶
     {
         System.out.println("制作奶茶");
         addIngredient(ingredient );
     }*/
    /*public  void  sentenceAmount(Ingredient ingredient,int x)//判断是否缺货
    {
        if(ingredient instanceof Bubble)
        { if(x>amountBubble) {
            System.out.println("对不起，没有足够的珍珠配料，请等几分钟进货");
            buy(ingredient);
            System.out.println(amountBubble);
            for (int i = 0; i < x; i++) {
                arrayListBubble.remove(i);
            }
            amountBubble=arrayListBubble.size();
            } }
            else if(ingredient instanceof  Coconut)
        {
            System.out.println(amountCoconut);
            if(x>amountCoconut) {
                System.out.println("对不起，没有足够的椰果配料，请等几分钟进货");
                buy(ingredient);
                for (int K = 0; K < x; K++) {
                    arrayListCoconut.remove(K);
                }
                amountCoconut=arrayListCoconut.size();

            }
        }

    }*/
    public  void printCunHuo()//打印存货数量
    {
        amountBubble=arrayListBubble.size();
        amountCoconut=arrayListCoconut.size();

        System.out.println("库存珍珠数量："+amountBubble);
        System.out.println("库存椰果数量："+amountCoconut);
        if(amountBubble<10){
            System.out.println("珍珠配料只剩"+amountBubble+"份赶快进珍珠配料");
        }
        if(amountCoconut<10){
            System.out.println("椰果配料只剩"+amountCoconut+"份赶快进椰果配料");
        }

    }
      /*  //1.创建一杯奶茶
        MilkTea milkTea=new MilkTea();
        //2.判断该奶茶是否为本店所出售的奶茶
        if(milkTea.getIngredient()instanceof Ingredient){
            //3.判断该奶茶是椰果奶茶还是珍珠奶茶
            if(ingredient.getIngredientName() == "椰果"){

            }
        }else{
            System.out.println("本店并未出售该奶茶");
        }

    }*/

    @Override
    public void sell(String teaName, String ingredientName) {
        // TODO Auto-generated method stub

    }
    public  void jinhuo(Ingredient ingredient)//配料不足时立即进货
    {
        System.out.println("对不起，没有足够的珍珠配料，请等几分钟进货");
        Random random=new Random();
        int min=random.nextInt(10)+4;
        System.out.println("·······经过"+min+"分钟");
        buy(ingredient);
    }
}
