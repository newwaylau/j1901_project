package com.lw.entity;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShopCart {

    // 存放商品的集合
   public  List<GoodsInfoDoMain> goodsInfoDoMains = new ArrayList<>();

    public List<GoodsInfoDoMain> getGoodsInfoDoMains() {
        return goodsInfoDoMains;
    }

    public void setGoodsInfoDoMains(List<GoodsInfoDoMain> goodsInfoDoMains) {
        this.goodsInfoDoMains = goodsInfoDoMains;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "goodsInfoDoMains=" + goodsInfoDoMains +
                '}';
    }
   /**
     * 获取购物车对象
     * @return
     */
    public static ShopCart getShopCartObject(HttpSession session){
        //1.从session获取购物车对象
        ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
        //判断对象是否为空,为空则代表第一次添加商品进购物车
        if(shopCart == null){
            shopCart = new ShopCart();
        }
        return shopCart;
    }

    // 添加
    public void shopAdd(GoodsInfoDoMain goodsDomain) {

        // 判断是否存在商品对象
        for (GoodsInfoDoMain goodsInfoDoMain : goodsInfoDoMains) {
            if (goodsInfoDoMain.getId() == goodsDomain.getId()) {
                // 如果商品相同只添加数量
                goodsInfoDoMain.setCount(goodsDomain.getCount()+goodsInfoDoMain.getCount());
                return;
            }
        }
        // 如果商品不存在就添加商品
        goodsInfoDoMains.add(goodsDomain);
    }

    /**
     *  获取总数量
     * @return
     */
    public int getTotalCount(){
        int totalCount = 0;

        for (GoodsInfoDoMain goodsInfoDoMain1 : goodsInfoDoMains){
            totalCount += goodsInfoDoMain1.getCount();
        }

        return totalCount;
    }

    // 获取总价
    public double getTotaoPrice(){
        double totalPrice = 0;
        for (GoodsInfoDoMain goodsInfoDoMain1 : goodsInfoDoMains){
            totalPrice += goodsInfoDoMain1.getCount()*goodsInfoDoMain1.getGoods_price_off();
        }
        return totalPrice;
    }

    // 删除




}
