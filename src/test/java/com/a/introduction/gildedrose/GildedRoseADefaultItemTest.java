package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemTest {
    private static final int NOT_EXPIRED_SELLIN = 15;
    private static final int EXPIRED_SELLIN = -1;
    private static final int QUALITY = 3;
    public static final String DEFAULT_ITEM = "DEFAULT_ITEM";

    @Test
    public void test_unexpiredDefaultItem_qualityDecreaseBy1() {
        GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, QUALITY);

        app.updateQuality();
        Item expectedItem = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN - 1, QUALITY - 1);

        assertItem(expectedItem, app.items[0]);
    }

    @Test
    public void test_expiredDefaultItem_qualityDecreaseBy2() {
        GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, EXPIRED_SELLIN, QUALITY);

        app.updateQuality();
        Item expectedItem = new Item(DEFAULT_ITEM, EXPIRED_SELLIN - 1, QUALITY - 2);

        assertItem(expectedItem, app.items[0]);

    }

    private GildedRose createGildedRoseWithItem(String defaultItem, int notExpiredSellin, int quality) {
        Item item = new Item(defaultItem, notExpiredSellin, quality);
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    private void assertItem(Item expectedItem, Item actualItem) {
        assertEquals(expectedItem.name, actualItem.name);
        assertEquals(expectedItem.sellIn, actualItem.sellIn);
        assertEquals(expectedItem.quality, actualItem.quality);
    }

}