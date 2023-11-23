package com.gildedrose;

import static com.gildedrose.ItemConstants.*;

public class ItemService {

    private final Item item;

    public ItemService(Item item) {
        this.item = item;
    }

    protected void updateQualityAndSellIn() {
        if (!SULFURAS.equals(item.name)) {
            if (AGED_BRIE.equals(item.name)) {
                incrementQualityByOne();
            } else if (BACKSTAGE_PASSES.equals(item.name)) {
                updateBackstage();
            } else if (CONJURED.equals(item.name)) {
                item.quality = item.quality - 2;
            } else {
                decrementQualityByOne();
            }
            item.sellIn = item.sellIn - 1;
        }
    }

    protected void updateQualityAndSellInForExpired() {
        if (item.sellIn < 0 && !SULFURAS.equals(item.name)) {
            if (AGED_BRIE.equals(item.name)) {
                incrementQualityByOne();
            } else if (BACKSTAGE_PASSES.equals(item.name)) {
                item.quality = 0;
            } else {
                decrementQualityByOne();
            }
        }
    }

    private void updateBackstage() {
        incrementQualityByOne();
        if (item.sellIn < 11) {
            incrementQualityByOne();
        }
        if (item.sellIn < 6) {
            incrementQualityByOne();
        }
    }

    private void decrementQualityByOne() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void incrementQualityByOne() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
