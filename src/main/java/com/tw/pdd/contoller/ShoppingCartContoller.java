package com.tw.pdd.contoller;

import com.tw.pdd.pojo.ShoppingCart;
import com.tw.pdd.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "购物车模块")
@RestController
public class ShoppingCartContoller {
    @Autowired
    private ShoppingCartService shoppingCartService;


    @ApiOperation(value = "添加到购物车", httpMethod = "POST")
    @RequestMapping("/createShoppingCart")
    public String createShoppingCart(@RequestBody @ApiParam Map<String, String> shoppingCart) {
        shoppingCartService.createShoppingCart(shoppingCart);
        return "ok";
    }

    @ApiOperation(value = "获取用户购物车列表", httpMethod = "GET")
    @RequestMapping("/getShoppingCartListByUUID")
    public List<ShoppingCart> getShoppingCartListByUUID(String uuid) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartListByUUID(uuid);
        return shoppingCarts;
    }

    @ApiOperation(value = "删除购物车", httpMethod = "GET")
    @RequestMapping("/deleteShoppingCart")
    public String deleteShoppingCart(int id) {
        shoppingCartService.deleteShoppingCart(id);
        return "ok";
    }
}
