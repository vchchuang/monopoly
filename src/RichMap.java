package monopoly;

import java.util.ArrayList;
import java.util.List;

public class RichMap {
    private List<Land> landList;

    public RichMap() {
        landList = new ArrayList<Land>();

        landList.add(new Land(0, 0, 4));

        for (int landNum = 1; landNum <= 13; landNum++) {
            landList.add(new Land(landNum, 0, 1));
        }

        landList.add(new Land(14, 0, 4));

        for (int landNum = 15; landNum <= 27; landNum++) {
            landList.add(new Land(landNum, 0, 1));
        }

        landList.add(new Land(28, 0, 4));

        for (int landNum = 29; landNum <= 34; landNum++) {
            landList.add(new Land(landNum, 0, 2));
        }

        landList.add(new Land(35, 0, 4));

        for (int landNum = 36; landNum <= 48; landNum++) {
            landList.add(new Land(landNum, 0, 3));
        }

        landList.add(new Land(49, 0, 4));

        for (int landNum = 50; landNum <= 62; landNum++) {
            landList.add(new Land(landNum, 0, 3));
        }

        landList.add(new Land(63, 0, 4));

        for (int landNum = 64; landNum <= 69; landNum++) {
            landList.add(new Land(landNum, 0, 1));
        }

    }

    public Land getLandByNum(int i) {
        return landList.get(i);
    }
}
