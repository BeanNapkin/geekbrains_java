import java.util.Random;
import java.util.Scanner;

public class CrossZero {
    // static final int FIELD_SIZE = 5;
    static final int FIELD_SIZE = 3;
    static final char EMPTY_CELL = '*';

    //public static char[] PLAYERS_SYMBOLS = {'X', '0', '%', '+'};
    public static char[] PLAYERS_SYMBOLS = {'X', '0'};
    static final char USER_SYMBOL = 'X';

    public static char[][] field;

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        field = createField();
        System.out.println("Игра 'Крестики-нолики': ");
        System.out.println();
        printField();

        boolean isGameContinue = true;

        while (isGameContinue) {
            for (int i = 0; i < PLAYERS_SYMBOLS.length; i++) {
                if (i == 0) {
                    usersTurn();
                } else {
                    computersTurn(PLAYERS_SYMBOLS[i]);
                }

                if (isSymbolWon(field, PLAYERS_SYMBOLS[i])) {
                    System.out.println("Выиграл " + PLAYERS_SYMBOLS[i]);
                    isGameContinue = false;
                    break;
                }

                if (isFieldFull()) {
                    System.out.println("Ничья!");
                    isGameContinue = false;
                    break;
                }
            }
        }
        scanner.close();
    }

    public static char[][] createField() {
        char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }
        return field;
    }

    public static void printField() {
        System.out.print("\t");

        for (int i = 1; i <= FIELD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(i + 1 + "\t");

            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void usersTurn() {
        int x = 0;
        int y = 0;

        do {
            System.out.println("Поставьте 'крестик', введя координаты ячейки в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellNotValid(x, y) || isCellNotEmpty(x, y));

        field[x][y] = USER_SYMBOL;

        printField();
    }

    public static void computersTurn(char symb) {

        if (isAnyCellForBlock()) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (isAnyCellForBlockInRow(i, field)) {
                    BlockCellInRow(i, field, symb);
                }
                if (isAnyCellForBlockInColumn(i, field)) {
                    BlockCellInColumn(i, field, symb);
                }
            }
            if (isAnyCellForBlockInRightDiagonal(field)) {
                BlockCellInRightDiagonal(field, symb);
            }
            if (isAnyCellForBlockInLeftDiagonal(field)) {
                BlockCellInLeftDiagonal(field, symb);
            }
        } else {

            int x = 0;
            int y = 0;

            do {
                x = random.nextInt(FIELD_SIZE);
                y = random.nextInt(FIELD_SIZE);
            } while (isCellNotEmpty(x, y));

            field[x][y] = symb;

        }
        System.out.println("Ход компьютера");
        printField();
    }

    public static boolean isCellNotEmpty(int x, int y) {
        return field[x][y] != EMPTY_CELL;
    }

    public static boolean isCellNotValid(int x, int y) {
        return x > FIELD_SIZE || x < 0 || y < 0 || y > FIELD_SIZE;
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnyCellForBlockInRow(int rowIndex, char[][] field) {
        int countEmptyCells = 0;
        int countSymb = 0;

        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[rowIndex][i] == EMPTY_CELL) {
                countEmptyCells++;
            }
            if (field[rowIndex][i] == USER_SYMBOL) {
                countSymb++;
            }
        }
        return (countEmptyCells == 1 && countSymb == FIELD_SIZE - 1);
    }

    public static boolean isAnyCellForBlockInColumn(int columnIndex, char[][] field) {
        int countEmptyCells = 0;
        int countSymb = 0;

        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][columnIndex] == EMPTY_CELL) {
                countEmptyCells++;
            }
            if (field[i][columnIndex] == USER_SYMBOL) {
                countSymb++;
            }
        }
        return (countEmptyCells == 1 && countSymb == FIELD_SIZE - 1);
    }

    public static boolean isAnyCellForBlockInRightDiagonal(char[][] field) {
        int countEmptyCells = 0;
        int countSymb = 0;

        for (int j = FIELD_SIZE - 1, i = 0; j >= 0 && i < FIELD_SIZE; j--, i++) {
            if (field[i][j] == EMPTY_CELL) {
                countEmptyCells++;
            }
            if (field[i][j] == USER_SYMBOL) {
                countSymb++;
            }
        }
        return (countEmptyCells == 1 && countSymb == FIELD_SIZE - 1);
    }

    public static boolean isAnyCellForBlockInLeftDiagonal(char[][] field) {
        int countEmptyCells = 0;
        int countSymb = 0;

        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][i] == EMPTY_CELL) {
                countEmptyCells++;
            }
            if (field[i][i] == USER_SYMBOL) {
                countSymb++;
            }
        }
        return (countEmptyCells == 1 && countSymb == FIELD_SIZE - 1);
    }

    public static boolean isAnyCellForBlock() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (isAnyCellForBlockInColumn(i, field) || isAnyCellForBlockInRow(i, field)) {
                return true;
            }
        }
        return isAnyCellForBlockInLeftDiagonal(field) || isAnyCellForBlockInRightDiagonal(field);
    }

    public static void BlockCellInRow(int rowIndex, char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[rowIndex][i] == EMPTY_CELL) {
                field[rowIndex][i] = symb;
            }
        }
    }

    public static void BlockCellInColumn(int columnIndex, char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][columnIndex] == EMPTY_CELL) {
                field[i][columnIndex] = symb;
            }
        }
    }

    public static void BlockCellInRightDiagonal(char[][] field, char symb) {
        for (int j = FIELD_SIZE - 1, i = 0; j >= 0 && i < FIELD_SIZE; j--, i++) {
            if (field[i][j] == EMPTY_CELL) {
                field[i][j] = symb;
            }
        }
    }

    public static void BlockCellInLeftDiagonal(char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][i] == EMPTY_CELL) {
                field[i][i] = symb;
            }
        }
    }

    public static boolean checkLeftDiagonal(char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][i] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRightDiagonal(char[][] field, char symb) {
        for (int j = FIELD_SIZE - 1, i = 0; j >= 0 && i < FIELD_SIZE; j--, i++) {
            if (field[i][j] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRow(int rowIndex, char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[rowIndex][i] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int columnIndex, char[][] testField, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (testField[i][columnIndex] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymbolWon(char[][] field, char symb) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (checkRow(i, field, symb) || checkColumn(i, field, symb)) {
                return true;
            }
        }
        return checkLeftDiagonal(field, symb) || checkRightDiagonal(field, symb);
    }
}


