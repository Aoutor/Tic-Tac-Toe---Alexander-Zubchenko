import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Scanner a = new Scanner(System.in);
        boolean win = false;
        String[][] arr = new String[3][3];
        int round = 1;
        String ans = "";
        while (!win) {
            ans = a.nextLine();
            display(round, arr, ans);
            round++;
            if (win(arr)) System.out.println("WON");

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
                    arr[row-1][column-1] = check;
                    System.out.print("[" + arr[i][j] + "]");
                } else {
                    if (j==arr[0].length-1 && i==arr.length-1)
                        System.out.println("Wrong input, try again");
                }

            }
            System.out.println();
        }

        System.out.println("Make a move (row, column)");
    }

    public static boolean win (String[][] arr){
        if (arr[0].equals(arr[1]) && arr[1].equals(arr[2])) return true;
        return false;
    }

}
