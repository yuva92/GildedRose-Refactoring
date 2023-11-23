package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void itemDecreaseInQualityAndSellIn(){
        Item firstItem = new Item("FirstItem", 8, 10);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.sellIn,7);
        assertEquals(firstItem.quality,9);
    }

    @Test
    public void itemDecreaseTwiceWhenSellInPass(){
        Item firstItem = new Item("FirstItem", -1, 10);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,8);
    }

    @Test
    public void itemQualityNeverNegative(){
        Item firstItem = new Item("FirstItem", 5, 0);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,0);
    }

    @Test
    public void itemAgedBrieQualityTest(){
        Item firstItem = new Item("Aged Brie", 5, 0);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,1);
    }

    @Test
    public void itemBackStageQualityIncreaseByOneWhenSellInGreaterThan10Test(){
        Item firstItem = new Item("Backstage passes to a TAFKAL80ETC concert", 13, 1);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,2);
    }

    @Test
    public void itemBackStageQualityIncreaseByTwoWhenSellInLessThanOrEqual10Test(){
        Item firstItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,3);
    }

    @Test
    public void itemBackStageQualityIncreaseByThreeWhenSellInLessThanOrEqual5Test(){
        Item firstItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,4);
    }

    @Test
    public void test(){
        Item firstItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,50);
    }

    @Test
    public void itemLegendaryNeverDecreaseInSellInAndQuality(){
        Item firstItem = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,10);
        assertEquals(firstItem.sellIn,5);
    }

    @Test
    public void itemQualityNeverGreaterThan50(){
        Item firstItem = new Item("Aged Brie", 5, 50);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,50);
        assertEquals(firstItem.sellIn,4);
    }

    @Test
    public void itemQualityIncreaseForAgedBrieWhenSellInPass(){
        Item firstItem = new Item("Aged Brie", -1, 10);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,12);
    }

    @Test
    public void itemDecreaseInQualityAndSellInForConjured(){
        Item firstItem = new Item("Conjured", 5, 10);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,8);
        assertEquals(firstItem.sellIn,4);
    }

    @Test
    public void itemQualityNeverBeNegative(){
        Item firstItem = new Item("FirstItem", -1, 0);
        Item[] items =  new Item[]{firstItem};
        GildedRose gildedRose =  new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(firstItem.quality,0);
    }

}
