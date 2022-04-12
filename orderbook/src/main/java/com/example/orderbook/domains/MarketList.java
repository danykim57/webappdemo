package com.example.orderbook.domains;

import com.example.orderbook.DAOs.OrderItemDao;
import com.example.orderbook.services.OrderBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketList {
    private OrderBook market;
    private Map<String, OrderBook> orderBooks = null;

    public MarketList() {
        orderBooks = new HashMap<String, OrderBook>();
        market = new OrderBook("Test");
        orderBooks.put("Test", market);
    }

    public List<String> getList() {
        List<String> list = new ArrayList<>(orderBooks.keySet());
        return list;
    }

    public void add(String name) {
        if (!orderBooks.containsKey(name)) {
            market = new OrderBook(name);
            orderBooks.put(name, market);
        }
    }

    public void addBid(OrderItemDao bid) {
        if (orderBooks.containsKey(bid.getName())) {
            OrderBook book = orderBooks.get(bid.getName());
        }
    }

    public void addOffer(OrderItemDao offer) {
        if (orderBooks.containsKey(offer.getName())) {
            OrderBook book = orderBooks.get(offer.getName());
            book.addOffer(offer.getQty(), offer.getPrice());
        }
    }

    public Map<Double, List<Order>> getBidMap(OrderItemDao bid) {
        if (orderBooks.containsKey(bid.getName())) {
            OrderBook book = orderBooks.get(bid.getName());
            Map<Double, List<Order>> bidMap = book.getBidMap();
            return bidMap;
        }
        return null;
    }

    public Map<Double, List<Order>> getOfferMap(OrderItemDao offer) {
        if (orderBooks.containsKey(offer.getName())) {
            OrderBook book = orderBooks.get(offer.getName());
            Map<Double, List<Order>> offerMap = book.getOfferMap();
            return offerMap;
        }
        return null;
    }

}
