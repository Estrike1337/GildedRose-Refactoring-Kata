/**
 * @(#)CakeItemStrategy.java, 8月 07, 2023.
 * <p>
 * Copyright 2023 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose.itemStrategy;

import com.gildedrose.Item;

import static java.lang.Math.max;

/**
 * @author estrike1337
 */
public class CakeItemStrategy implements ItemStrategy {

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2;
            }
        }
        item.quality = max(item.quality, 0);
    }
}
