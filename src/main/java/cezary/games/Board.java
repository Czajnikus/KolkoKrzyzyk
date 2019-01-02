package cezary.games;

import java.util.Scanner;

public class Board {

    public static void gameStartingBoxes(int size) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[size][size];

        int turn = 1;

        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
                int cord = 3 * a + b + 1;
                board[a][b] = Integer.toString(cord);
            }
        }

        while (turn <10) {
            gameGrid(board);
            if (turn % 2 == 1) {
                System.out.println("Gdzie postawić krzyżyk?");
                int position = scanner.nextInt();
                for (int a = 0; a < board.length; a++) {
                    for (int b = 0; b < board[a].length; b++) {
                        if (Integer.toString(position).equals(board[a][b])) {
                            board[a][b] = "X";
                            turn += 1;
                            gameWon(board);

                        }

                    }
                }
            } else if (turn % 2 == 0) {
                System.out.println("Gdzie postawić kółko?");
                int position = scanner.nextInt();
                for (int a = 0; a < board.length; a++) {
                    for (int b = 0; b < board[a].length; b++) {
                        if (Integer.toString(position).equals(board[a][b])) {
                            board[a][b] = "O";
                            turn += 1;
                            gameWon(board);

                        }

                    }
                }
            }

        }
        System.out.println("Remis!");
        Menu.menu();

    }

    public static void gameGrid(String[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-----");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-----");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public static void gameWon(String[][] board) {

        for (int a = 0; a < board.length; a++) {
            if (board[a][0].equals("X") && board[a][1].equals("X") && board[a][2].equals("X")) {
                System.out.println("Wygrał krzyżyk!");
                System.exit(0);
            } else if (board[a][0].equals("O") && board[a][1].equals("O") && board[a][2].equals("O")) {
                System.out.println("Wygrało kółko!");
                System.exit(0);

            }
            for (int b = 0; b < board[a].length; b++) {
                if (board[0][b].equals("X") && board[1][b].equals("X") && board[2][b].equals("X")) {
                    System.out.println("Wygrał krzyżyk!");
                    System.exit(0);
                } else if (board[a][0].equals("O") && board[a][1].equals("O") && board[a][2].equals("O")) {
                    System.out.println("Wygrało kółko!");
                    System.exit(0);

                }
            }

        }
        if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            System.out.println("Wygrał krzyżyk!");
            System.exit(0);
        } else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            System.out.println("Wygrało kółko!");
            System.exit(0);
        } else if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
            System.out.println("Wygrał krzyżyk!");
            System.exit(0);
        } else if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
            System.out.println("Wygrało kółko!");
            System.exit(0);

        }
    }
}
