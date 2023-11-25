import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Scanner a = new Scanner(System.in);
        boolean win = false;
        String[][] arr = new String[3][3];
        int round = 1;
        String ans = "";
        String replay = "";
        while (!win) {

            //CHECKS FOR WINNER
            if (win(arr)){
                System.out.println("GAME WON, Y/N to replay?");
                replay = a.nextLine();
                if (replay.equals("N")){
                    System.out.println("Game over");
                    win = true;
                } else if (replay.equals("Y")){
                    round = 1;
                    System.out.println("REPLAYING...");
                }
            }
            //
            if (!win) {
                if (round==1)
                    System.out.println("WELCOME TO TIC, TAC, TOE, Enter row, column, to make a move!");
                ans = a.nextLine();
                display(round, arr, ans);
                round++;
            }
        }
    }

    public static void display(int round, String[][] arr, String ans){
        System.out.println("Round: " + round);
        int column = Integer.parseInt(ans.substring(0, 1));
        int row = Integer.parseInt(ans.substring(3));
        String check = " ";
        if (round%2==1) check = "X";
        if (round%2==0) check = "0";


        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (round==1){
                    arr[i][j] = " ";
                }
                if (column<=3 && row<=3 && ans.length()==4){
                    if (arr[row-1][column-1].equals(" ")){
                        arr[row-1][column-1] = check;
                    }
                    System.out.print("[" + arr[i][j] + "]");
                } else {
                    if (j==arr[0].length-1 && i==arr.length-1)
                        System.out.println("Wrong input, try again");
                }

            }
            System.out.println();
        }
    }

    public static boolean win (String[][] arr){
        String vert = "";
        String hori = "";
        for (int i = 0; i < 3; i++) {
            vert = "";
            hori = "";
            for (int j = 0; j < 3; j++){
                vert+= arr[i][j];
                hori+= arr[j][i];
                if (hori.equals("XXX") || vert.equals("XXX")) return true;
                if (hori.equals("000") || vert.equals("000")) return true;
            }
            if ((arr[0][0]+arr[1][1]+arr[2][2]).equals("XXX") || (arr[0][0]+arr[1][1]+arr[2][2]).equals("000")) return true;
            if ((arr[2][0]+arr[1][1]+arr[0][2]).equals("XXX") || (arr[2][0]+arr[1][1]+arr[0][2]).equals("000")) return true;
        }
        return false;
    }

}
