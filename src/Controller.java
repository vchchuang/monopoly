package monopoly;

public class Controller {
    Player currentPlayer;
    RichMap map;
    Land currentLand;

    public Controller(Player currentPlayer,RichMap map) {
        this.currentPlayer = currentPlayer;
        this.map = map;
        updateCurrentLand();
    }

    public void playerMove(int steps) {
        currentPlayer.move(steps);
        updateCurrentLand();
    }

    public void playerBuyLand() {
        currentPlayer.buyLand(currentLand);
    }

    private void updateCurrentLand() {
        this.currentLand = map.getLandByNum(currentPlayer.getPosition());
    }

    public void changePlayer(Player player2) {
        this.currentPlayer = player2;
        updateCurrentLand();
    }

    public void playerPayOther() {
        currentPlayer.payForOthers(currentLand.getToll(),currentLand.getOwner());
    }

    public void upgradeLand() {
        currentPlayer.updateLand(currentLand);
    }
}
