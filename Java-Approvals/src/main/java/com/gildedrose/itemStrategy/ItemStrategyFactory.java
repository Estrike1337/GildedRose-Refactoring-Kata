/**
 * @(#)ItemStrategyFactory.java, 8月 07, 2023.
 * <p>
 * Copyright 2023 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose.itemStrategy;

import com.gildedrose.Item;

/**
 * @author estrike1337
 */
public class ItemStrategyFactory {

    public static ItemStrategy getStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBriefItemStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesItemStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new RagnarosItemStrategy();
            case "Conjured Mana Cake":
                return new CakeItemStrategy();
            default:
                return new DefaultItemStrategy();
        }
    }
}
