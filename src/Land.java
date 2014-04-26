package monopoly;

public class Land {
    private Player owner;
    private int num;
    private int level;
    private int price;
    private LandType type;

    public Land(int num, int level, int type) {
        this.num = num;
        this.level = level;
        this.type = LandType.getTypeByNum(type);
        price = this.type.getTypePrice();
    }

    public int getPrice() {
        return price;
    }

    public int getSellPrice() {
        return (price + price * level) * 2;
    }

    public void levelUp() {
        level += 1;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    public void sold() {
        owner = (Player)null;
        this.level = 0;
    }

    public int getToll() {
        return (int) (0.5*price) * (int) Math.pow(2,(level));
    }
}
