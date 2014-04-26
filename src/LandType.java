package monopoly;

public class LandType {
    static LandType getTypeByNum(int typeNum) {
        if (typeNum == 1) {
            return new TypeOne();
        }
        else if (typeNum == 2) {
            return new TypeTwo();
        }
        else if (typeNum == 3) {
            return new TypeThree();
        }
        else
            return new TypeOthers();
    }

    int getTypePrice() {
        return 0;
    }
}
