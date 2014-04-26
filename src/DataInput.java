package monopoly;

import java.util.Scanner;

public class DataInput {
    private Scanner scanner;

    public DataInput() {
        this.scanner = new Scanner(System.in);
    }

    public boolean getConfirmInfo() {
        boolean confirmation;
        while (true) {
            String confirmInfo = scanner.nextLine();
            if (confirmInfo.equals("Y") ) {
                confirmation = true;
                break;
            }
            else if (confirmInfo.equals("N") ) {
                confirmation = false;
                break;
            }
            else {
                System.out.println("please input again:");
                continue;
            }
        }
        return confirmation;
    }

    public String getInputString (){
        return this.scanner.nextLine();
    }
}
