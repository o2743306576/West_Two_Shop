package com.shop.w2;

/**
 * @author Krijon Ou
 * @create 2019-12-06 18:51
 */
public interface Shop {
    //添加配料
    public void buy(Ingredient ingredient);

    //出售,参数1:奶茶名字,参数二:配料名字
    public void sell(String teaName,String ingredientName);

}
