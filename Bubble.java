package com.shop.w2;

import java.util.Calendar;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:46
 */
public class Bubble extends Ingredient{
    public Bubble(){}
    public Bubble(String name, Calendar creatTime, int expityDate){
        super("珍珠",creatTime,7);
    }

    public void addIngredient(){
        System.out.println("在奶茶中加入珍珠配料");
    }
    @Override
    public String toString() {
        return "Bubble [name=" + ingredientName + ", creatTime=" + creatTime + ", expiryDate=" + expiryDate + "]";
    }

}
