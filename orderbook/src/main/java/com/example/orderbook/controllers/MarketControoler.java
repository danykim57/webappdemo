package com.example.orderbook.controllers;

import com.example.orderbook.domains.MarketList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketControoler {
    private MarketList marketList;

    public MarketControoler() {
        marketList = new MarketList();
        marketList.add("Test");
    }

    @RequestMapping("market/add/item/{name}")
    public String addMarketItem(@PathVariable(value = "name") String name) {
        marketList.add(name);
        return "success";
    }
}
