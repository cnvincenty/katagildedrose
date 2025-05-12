package bo.edu.uagrm.soe.quality_updaters;

import bo.edu.uagrm.soe.Item;

public class ConjuredUpdaterStrategy extends AbstractUpdaterStrategy {

    public ConjuredUpdaterStrategy(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseQuality();
        decreaseSellIn();
        if (item.getSellIn() < 0) {
            decreaseQuality();
            decreaseQuality();
        }
    }
}
