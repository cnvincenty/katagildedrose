package bo.edu.uagrm.soe;

import java.util.ArrayList;
import java.util.List;

import bo.edu.uagrm.soe.interfaces.QualityUpdaterStrategy;
import bo.edu.uagrm.soe.quality_updaters.BackstagePassUpdaterStrategy;
import bo.edu.uagrm.soe.quality_updaters.ConjuredUpdaterStrategy;
import bo.edu.uagrm.soe.quality_updaters.DefaultUpdaterStrategy;
import bo.edu.uagrm.soe.quality_updaters.LegendaryUpdaterStrategy;

public class GildedRose {

    public static List<Item> items =  new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();

        System.out.println(items);
    }

    public static void updateQuality() {
    for (Item item : items) {
      QualityUpdaterStrategy updater = createQualityUpdaterStrategy(item);
      updater.update();
    }
  }

  public static QualityUpdaterStrategy createQualityUpdaterStrategy(Item item) {
    switch (item.getName()) {
      case "Aged Brie":
        return new BackstagePassUpdaterStrategy(item);
      case "Backstage passes to a TAFKAL80ETC concert":
        return new BackstagePassUpdaterStrategy(item);
      case "Sulfuras, Hand of Ragnaros":
        return new LegendaryUpdaterStrategy(item);
      case "Conjured Mana Cake":
        return new ConjuredUpdaterStrategy(item);
      default:
        return new DefaultUpdaterStrategy(item);
    }
  }

    /* public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            if ((!"Aged Brie".equals(items.get(i).getName()))
                    && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                if (items.get(i).getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getSellIn() < 11) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!"Aged Brie".equals(items.get(i).getName())) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    } else {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                } else {
                    if (items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }

            if (items.get(i).getName().equals("Conjured Mana Cake")) {
                if (items.get(i).getQuality() > 0) {
                    items.get(i).setQuality(items.get(i).getQuality() - 1);
                    if (items.get(i).getSellIn() < 0) {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
        }
    } */
}