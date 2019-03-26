package com.tw.pdd.mapper;

import com.tw.pdd.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper {
    void createShoppingCart(@Param(value = "shoppingCart") Map<String, String> shoppingCart);

    List<ShoppingCart> getShoppingCartListByUUID(String uuid);

    void deleteShoppingCart(int cartId);
}
