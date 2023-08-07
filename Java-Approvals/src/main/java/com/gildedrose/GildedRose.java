package com.gildedrose;

import com.gildedrose.itemStrategy.ItemStrategy;
import com.gildedrose.itemStrategy.ItemStrategyFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            ItemStrategy strategy = ItemStrategyFactory.getStrategy(item);
            strategy.update(item);
        }
    }
}
