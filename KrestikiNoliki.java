import java.util.Random;
import java.util.Scanner;

public class KrestikiNoliki {

    private static char map[][];
    private static int SIZE = 3;

    private static final char DOT_EMPTY = '●';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final boolean SILLY_MODE = false;

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            if (isEndGame(DOT_X)) {
                break;
            }

            if (SILLY_MODE)
                computerTurnHard();
            else
                computerTurnSilly();
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра закончена!");
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты через пробел");
            y = in.nextInt() - 1;
            x = in.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    private static void computerTurnSilly() {
        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        computerDecision(y, x);
    }

    private static void computerTurnHard() {
        int x = 0;
        int y = 0;

        int numOfSameSimybolsNearby = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    int temp = checkCellsNearby(i, j);
                    if (temp > numOfSameSimybolsNearby) {
                        numOfSameSimybolsNearby = temp;
                        x = j;
                        y = i;
                    }
                }
            }
        }
        if (numOfSameSimybolsNearby > 0)
            computerDecision(y, x);
        else
            computerTurnSilly();
    }

    private static void computerDecision(int y, int x) {
        System.out.println("Компьютер сходил");
        map[y][x] = DOT_O;
    }

    private static int checkCellsNearby(int y, int x) {
        int quantity = 0;

        for (int i = y - 1; i < 2; i++) {
            for (int j = x - 1; j < 2; j++) {
                if (isCellValid(i, j) && map[i][j] == DOT_O) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    private static boolean isCellValid(int y, int x) {
        boolean result = true;

        if (x < 0 || x > SIZE + 1 || y < 0 || y > SIZE + 1) {
            result = false;
        }
        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }

        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if ((map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol))
            result = true;
        return result;
    }
}
