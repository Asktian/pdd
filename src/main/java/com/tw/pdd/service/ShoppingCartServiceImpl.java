package com.tw.pdd.service;

import com.tw.pdd.mapper.ShoppingCartMapper;
import com.tw.pdd.pojo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void createShoppingCart(Map<String, String> shoppingCart) {
        double goodsPrice = Double.parseDouble(shoppingCart.get("goodsPrice"));
        int goodsNumber = Integer.parseInt(shoppingCart.get("goodsNumber"));
        shoppingCart.put("goodsMoney", "" + goodsPrice * goodsNumber + "");
        shoppingCartMapper.createShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getShoppingCartListByUUID(String uuid) {
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.getShoppingCartListByUUID(uuid);
        return shoppingCarts;
    }

    @Override
    public void deleteShoppingCart(int cartId) {
        shoppingCartMapper.deleteShoppingCart(cartId);
    }
}
