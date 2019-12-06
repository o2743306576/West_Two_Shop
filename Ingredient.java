package com.shop.w2;

import java.util.Calendar;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:47
 */
public class Ingredient {
    protected String ingredientName;		//名字
    protected Calendar creatTime;	//生产日期
    protected int expiryDate;		//保质期

    //无参
    public Ingredient(){}
    //有参
    public Ingredient(String ingredientName,Calendar creatTime,int expiryDate){
        this.ingredientName=ingredientName;
        this.creatTime=creatTime;
        this.expiryDate=expiryDate;
    }

    //提供get/set
    public String getIngredientName(){
        return ingredientName;
    }
    public void setName(String ingredientName){
        this.ingredientName=ingredientName;
    }
    public Calendar getCreatTime(){
        return creatTime;
    }
    public void setCreatTime(Calendar creatTime){
        this.creatTime=creatTime;
    }
    public int getExpiryDate(){
        return expiryDate;
    }
    public void setExpiryDate(int expiryDate){
        this.expiryDate=expiryDate;
    }
    @Override
    public String toString() {
        return "Ingredient [配料名字=" + ingredientName + ", 生产日期=" + creatTime + ", 保质期=" + expiryDate + "]";
    }
    public  void ThrowAwayIngredient()
    {
        System.out.println("由于过期扔掉配料");
    }

}
