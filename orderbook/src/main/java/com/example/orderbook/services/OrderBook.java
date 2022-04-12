package com.example.orderbook.services;

import com.example.orderbook.domains.Order;

import java.util.*;

public class OrderBook {
    private String itemName;
    private Map<Double, List<Order>> bidMap = null;
    private Map<Double, List<Order>> offerMap = null;

    private Queue<Double> bidmaxPriceList = null;
    private Queue<Double> offerMinPriceList = null;

    public OrderBook(String itemName) {
        this.itemName = itemName;
        bidMap = new HashMap<Double, List<Order>>();
        offerMap = new HashMap<Double, List<Order>>();
        bidmaxPriceList = new PriorityQueue<Double>(30, Collections.reverseOrder());
        offerMinPriceList = new PriorityQueue<Double>();
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void addBid(int quantity, double price) {
        List<Order> bucket = getBucket(bidMap, price);
        Order newBid = new Order(quantity, price);
        bucket.add(newBid);
        bidMap.put(newBid.getPrice(), bucket);
        bidmaxPriceList.add(price);
        matchOrders();
    }

    public void addOffer(int quantity, double price) {
        List<Order> bucket = getBucket(offerMap, price);
        Order newOffer = new Order(quantity, price);
        bucket.add(newOffer);
        offerMap.put(newOffer.getPrice(), bucket);
        offerMinPriceList.add(price);
        matchOrders();
    }

    private void matchOrders() {
        List<Order> bidBucket = null, offerBucket = null;
        Double lowestOffer = null, highestBid = null;
        boolean finished = false;

        while (!finished) {
            highestBid = bidmaxPriceList.peek();
            lowestOffer = offerMinPriceList.peek();

            if (lowestOffer == null || highestBid == null || lowestOffer > highestBid) {
                finished = true;
            }

            else {
                bidBucket = bidMap.get(bidmaxPriceList.peek());
                offerBucket = offerMap.get(offerMinPriceList.peek());

                int bidQuantity = bidBucket.get(0).getQuantity();
                int offerQuantity = offerBucket.get(0).getQuantity();

                if (bidQuantity > offerQuantity) {
                    System.out.println(successfulTrade(offerQuantity, lowestOffer));

                    bidQuantity -= offerQuantity;
                    bidBucket.get(0).setQuantity(bidQuantity);

                    offerBucket.remove(0);
                    offerMinPriceList.remove();
                }

                else if (offerQuantity > bidQuantity) {
                    System.out.println(successfulTrade(bidQuantity, lowestOffer));

                    offerQuantity -= bidQuantity;
                    offerBucket.get(0).setQuantity(offerQuantity);

                    bidBucket.remove(0);
                    bidmaxPriceList.remove();
                }

                else {
                    System.out.println(successfulTrade(bidQuantity, lowestOffer));

                    bidBucket.remove(0);
                    bidmaxPriceList.remove();
                    offerBucket.remove(0);
                    offerMinPriceList.remove();
                }

            }
        }
    }

    private String successfulTrade(int quantity, double price) {
        return quantity + " shares traded for $" + price + " per share.";
    }

    private List<Order> getBucket(Map<Double, List<Order>> hashmap, double price) {
        List<Order> bucket;
        if (hashmap.containsKey(price)) {
            bucket = hashmap.get(price);
        }

        else {
            bucket = new LinkedList<Order>();
        }
        return bucket;
    }

    private void printFailedTrades(Map<Double, List<Order>> hashmap, String type) {
        for (Double key : hashmap.keySet()) {
            List<Order> bucket = hashmap.get(key);
            for (Order order : bucket) {
                System.out.println(type + order.getQuantity() + "shares for $" + order.getPrice() + " per share failed to trade.");
            }
        }
    }

    public void openMarket() {
        System.out.println("Market opens");
    }

    public void closeMarket() {
        System.out.println("Market closes");
        printFailedTrades(bidMap, "Bid for ");
        printFailedTrades(offerMap, "Offer of ");
    }

    public Map<Double, List<Order>> getBidMap() {
        return bidMap;
    }

    public Map<Double, List<Order>> getOfferMap() {
        return offerMap;
    }


}
