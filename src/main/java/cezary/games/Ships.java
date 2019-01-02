package cezary.games;

import java.util.Scanner;

public class Ships {

    //Makes empty arrays for both players, one for ships and one for "shots"
    public static void shipsArrays() {
        String[][] shipsPlayer1 = new String[10][10];
        String[][] shipsPlayer2 = new String[10][10];
        String[][] shotPlayer1 = new String[10][10];
        String[][] shotPlayer2 = new String[10][10];
        Scanner scanner = new Scanner(System.in);

        for (int a = 0; a < shipsPlayer1.length; a++) {
            for (int b = 0; b < shipsPlayer1.length; b++) {
                shipsPlayer1[a][b] = ".";
                shipsPlayer2[a][b] = ".";
                shotPlayer1[a][b] = "~";
                shotPlayer2[a][b] = "~";
            }
        }
        makingShips(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, scanner);
    }
//Podczas rozmiesczania p1s4 będą -1 | Rozstawianie większych: Pytanie w którą stronę 
//o jeden kwadrat z blokadą na OutOfBound | Zestrzelony masz = wynik +1, jak 
//wynik =20, przegrana |  

    //This will let players set up their ships on the maps
    public static void makingShips(String[][] shipsPlayer1, String[][] shipsPlayer2, String[][] shotPlayer1, String[][] shotPlayer2, Scanner scanner) {
        int turn = 1;
        int p1s4 = 1;
        int p1s3 = 2;
        int p1s2 = 3;
        int p1s1 = 4;
        int p2s4 = 1;
        int p2s3 = 2;
        int p2s2 = 3;
        int p2s1 = 4;
        System.out.println("Rozmieść swoje statki. Aby podać koordynaty, wpisz pierw literę, potem cyfrę.");
        boolean bothPlayers = true;
        while (bothPlayers) {
            if (p1s4 == 1) {
                System.out.println("Okręt 4 masztowy\n");
                playerTurns(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, turn, scanner);
            }
        }

        

        playerTurns(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, turn, scanner);

    }

    //Asks for coordinates
    public static void coordinates(Scanner scanner, String[][] myTable, String[][] enemyTable) {
        String position = scanner.next();
        int horizontal = 0;
        int vertical = 0;
        switch (position.toLowerCase().charAt(0)) {
            case 'a':
                horizontal = 0;
                break;
            case 'b':
                horizontal = 1;
                break;
            case 'c':
                horizontal = 2;
                break;
            case 'd':
                horizontal = 3;
                break;
            case 'e':
                horizontal = 4;
                break;
            case 'f':
                horizontal = 5;
                break;
            case 'g':
                horizontal = 6;
                break;
            case 'h':
                horizontal = 7;
                break;
            case 'i':
                horizontal = 8;
                break;
            case 'j':
                horizontal = 9;
                break;
        }
        if (position.charAt(position.length() - 1) - '0' == 0) {
            vertical = 9;
        } else {
            vertical = position.charAt(position.length() - 1) - '0' - 1;

        }
        //tu chyba trzeba będzie zrobić badanie komórki + zachowanie
        myTable[horizontal][vertical] = myShip ;
        enemyTable[horizontal][vertical] = enemyShip ;
    }

    //This changes variables for each player's turn
    public static void playerTurns(String[][] shipsPlayer1, String[][] shipsPlayer2, String[][] shotPlayer1, String[][] shotPlayer2, Integer turn, Scanner scanner) {

        if (turn % 2 == 1) {
            String player = "Gracz 1";
            String[][] myTable = shipsPlayer1;
            String[][] enemyTable = shotPlayer1;
            tablesGenerator(player, myTable, enemyTable);
            coordinates(scanner, myTable, enemyTable);
        } else if (turn % 2 == 0) {
            String player = "Gracz 2";
            String[][] myTable = shipsPlayer2;
            String[][] enemyTable = shotPlayer2;
            tablesGenerator(player, myTable, enemyTable);
            coordinates(scanner, myTable, enemyTable);
        }

    }

    //Prints out both maps for the active player, the one with his shots and with his ships
    public static void tablesGenerator(String player, String[][] myTable, String[][] enemyTable) {
        System.out.println(player);
        System.out.println("XX|A|B|C|D|E|F|G|H|I|J   |   XX|A|B|C|D|E|F|G|H|I|J");
        String q = "|";
        for (int a = 0; a < myTable.length; a++) {
            String position = String.format("%02d", a + 1);
            System.out.print(position);
            for (int b = 0; b < myTable.length; b++) {
                System.out.print(q + myTable[a][b]);
                if (b == 9) {
                    System.out.print("   |   ");
                    System.out.print(position);
                    for (int c = 0; c < enemyTable.length; c++) {
                        System.out.print(q + enemyTable[a][b]);
                        if (c == 9) {
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
