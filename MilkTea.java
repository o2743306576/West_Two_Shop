package com.shop.w2;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:50
 */
public class MilkTea {
    private String teaName;			//奶茶名字
    private Ingredient ingredient;	//奶茶配料
    public MilkTea(){}
    public MilkTea(String teaName,Ingredient ingredient){
        this.teaName=teaName;
        this.ingredient =ingredient;
    }

    //get/set
    public String getTeaName(){
        return teaName;
    }
    public void setTeaName(String teaName){
        this.teaName=teaName;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    @Override
    public String toString() {
        return "MilkTea [teaName=" + teaName + ", ingredient=" + ingredient + "]";
    }
}
