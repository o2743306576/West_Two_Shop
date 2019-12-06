package com.shop.w2;

import java.util.Calendar;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:49
 */
public class Coconut extends Ingredient {
    public Coconut(){}
    public Coconut(String name, Calendar creatTime, int expityDate){
        super("椰果",creatTime,5);
    }
    public void addIngredient(){
        System.out.println("在奶茶中加入椰果配料");
    }
    @Override
    public String toString() {
        return "Coconut [name=" + ingredientName + ", creatTime=" + creatTime + ", expiryDate=" + expiryDate + "]";
    }
}
