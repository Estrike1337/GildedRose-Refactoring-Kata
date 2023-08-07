package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void foo() {

        //        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20), //
        //            new Item("Aged Brie", 2, 0), //
        //            new Item("Elixir of the Mongoose", 5, 7), //
        //            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        //            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        //            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        //            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        //            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        //            // this conjured item does not work properly yet
        //            new Item("Conjured Mana Cake", 3, 6)};
        //        GildedRose app = new GildedRose(items);
        //        app.updateQuality();
        String[] names =
            new String[]{"+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert", "Backstage passes to a TAFKAL80ETC concert",
                "Conjured Mana Cake", "foo"};
        Integer[] sellIns = new Integer[]{0, 12, 5, -1};
        Integer[] qualities = new Integer[]{0, 1, 5, 50, 49};
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, names, sellIns, qualities);
        //Approvals.verifyAll("Items", items);
    }

    public String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
