package com.tw.pdd.service;

import com.tw.pdd.pojo.ShoppingCart;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    void createShoppingCart(Map<String, String> shoppingCart);

    List<ShoppingCart> getShoppingCartListByUUID(String uuid);

    void deleteShoppingCart(int cartId);
}
