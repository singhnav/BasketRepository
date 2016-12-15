package com.shopping.basket;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BasketPricingTest {


    @Test
    public void priceAnEmptyBasket() throws Exception {
        assertThat(new BasketPricing(Collections.emptyList()).calculate(), is(0.0));
    }


    @Test
    public void priceASimpleBasket() throws Exception {
        assertThat(new BasketPricing(Arrays.asList(Item.Apples)).calculate(), is(30.0));
    }



    @Test
    public void priceABasketOfMultipleItems() {

        List<Item> items = new ArrayList<>();

        items.add(Item.Apples);
        items.add(Item.Apples);
        items.add(Item.Oranges);
        items.add(Item.Oranges);
        items.add(Item.Oranges);
        items.add(Item.Bananas);
        items.add(Item.Lemons);
        items.add(Item.Lemons);
        items.add(Item.Peaches);
        items.add(Item.Peaches);
        items.add(Item.Apples);
        items.add(Item.Bananas);

        assertThat(new BasketPricing(items).calculate(), is(350.0));
    }


}