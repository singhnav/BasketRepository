package com.shopping.basket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class BasketPricing {

    private final List<Item> items;

    public BasketPricing(List<Item> items) {
        this.items = items;
    }

    public Double calculate() {

        Map<Item, Integer> itemsCounted = items.stream()
                .collect(Collectors.groupingBy(item -> item))
                .entrySet().stream().collect(toMap(e -> e.getKey(), e -> e.getValue().size()));

        return itemsCounted
                .entrySet().stream()
                .collect(toMap(e1 -> e1.getKey(), e1 -> priceFor(e1.getKey(), e1.getValue())))
                .entrySet().stream().collect(Collectors.summingDouble(e -> e.getValue()));

    }

    private double priceFor(Item item, Integer quantity) {
        return item.getPrice() * quantity;
    }
}
