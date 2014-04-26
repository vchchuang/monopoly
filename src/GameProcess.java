package monopoly;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    Controller controller;
    List<Player> playerList;
    RichMap map;
    int initMoney;
    DataInput dataInput;
    boolean hasRolled=false;

    public GameProcess() {
        this.map = new RichMap();
        this.initMoney = 10000;
        this.dataInput = new DataInput();
        this.playerList = new ArrayList<Player>();
    }

    public void initPlayers(String input) {
        int playerNum ;
        for(int i=0;i<input.length();i++) {
            playerNum = input.charAt(i)-'0';
            playerList.add(new Player(playerNum,initMoney));
        }
        controller = new Controller(playerList.get(0),this.map);
    }

    public void action(String command){
        String[] wholeCommand = command.split(" ");
        String commandPart1;
        String commandPart2 = "";
        if (wholeCommand.length>1){
            commandPart1 = wholeCommand[0];
            commandPart2 = wholeCommand[1];
        }
        else {
            commandPart1 = wholeCommand[0];
        }

        if ("roll" .equals(commandPart1) ){
            controller.currentPlayer.move(controller.currentPlayer.roll());
            hasRolled=true;
        }
        else if ("sell" .equals(commandPart1) ){
            controller.currentPlayer.sellLand(map.getLandByNum(commandPart2.charAt(0) - '0'));
        }
        else if ("query" .equals(commandPart1) ) {
            System.out.println("Query");
        }
        else if ("help".equals(commandPart1) ) {
            System.out.println("Help");
        }
        else
            System.out.println("error");

    }

    public void afterMove() {
        if (controller.currentLand.getOwner() != controller.currentPlayer ) {
            if (controller.currentLand.getOwner() == (Player)null) {
                if (getConfirmation()) {
                    controller.playerBuyLand();
                }
            }
            else {
                controller.playerPayOther();
            }
        }
        else {
            if (getConfirmation()) {
                    controller.upgradeLand();
                }
        }
        hasRolled = false;
    }

    private boolean getConfirmation() {
        return this.dataInput.getConfirmInfo();
    }

    public void run(){
        initPlayers(dataInput.getInputString());
        while(true){
            for (int i=0;i<playerList.size();i++){
                while(hasRolled==false)
                    action(dataInput.getInputString());
                afterMove();
            }
        }
    }
}
