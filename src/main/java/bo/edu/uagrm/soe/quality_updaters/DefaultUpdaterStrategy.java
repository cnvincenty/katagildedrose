package bo.edu.uagrm.soe.quality_updaters;

import bo.edu.uagrm.soe.Item;

public class DefaultUpdaterStrategy extends AbstractUpdaterStrategy {
    public DefaultUpdaterStrategy(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (item.getSellIn() < 0) {
            decreaseQuality();
        }
    }
}
