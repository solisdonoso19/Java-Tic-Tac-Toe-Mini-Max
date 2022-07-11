import javax.swing.*;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.*;

public class MinMax {
    protected Integer[][] gameValues = new Integer[3][3];
    public static Integer Depth = Menu.nivdif/* representa nivel de dificultad */, contPlay = 0;
    protected static Integer endBoard = 3;

    // initializing matriz on minmax
    public void initValues() {
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++)
                gameValues[i][j] = 0;
        }
    }

    // print on console all the plays
    protected void consoleLog() {
        System.out.println("Nivel de Dificultad: " + Depth);
        contPlay = contPlay + 1;
        System.out.println("Jugada: " + contPlay);
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                System.out.print("| " + gameValues[i][j] + " | \t");
            }
            System.out.println("");
        }
    }

    // this evaluate if the board is full
    public boolean isFull() {
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                if (gameValues[j][i] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // win evalutate
    public int isWin() {
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                if (j + 2 < endBoard) {
                    if (gameValues[j][i] == 1 && gameValues[j + 1][i] == 1 && gameValues[j + 2][i] == 1) {
                        return 1;
                    }
                }
                if (i + 2 < endBoard) {
                    if (gameValues[j][i] == 1 && gameValues[j][i + 1] == 1 && gameValues[j][i + 2] == 1) {
                        return 1;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (gameValues[j][i] == 1 && gameValues[j + 1][i + 1] == 1 && gameValues[j + 2][i + 2] == 1) {
                        return 1;
                    }
                }
                if (i - 2 > -1 && j + 2 < endBoard) {
                    if (gameValues[j][i] == 1 && gameValues[j + 1][i - 1] == 1 && gameValues[j + 2][i - 2] == 1) {
                        return 1;
                    }
                }
                if (i + 2 < endBoard && j - 2 > -1) {
                    if (gameValues[j][i] == 1 && gameValues[j - 1][i + 1] == 1 && gameValues[j - 2][i + 2] == 1) {
                        return 1;
                    }
                }

                if (j + 2 < endBoard) {
                    if (gameValues[j][i] == 2 && gameValues[j + 1][i] == 2 && gameValues[j + 2][i] == 2) {
                        return 2;
                    }
                }
                if (i + 2 < endBoard) {
                    if (gameValues[j][i] == 2 && gameValues[j][i + 1] == 2 && gameValues[j][i + 2] == 2) {
                        return 2;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (gameValues[j][i] == 2 && gameValues[j + 1][i + 1] == 2 && gameValues[j + 2][i + 2] == 2) {
                        return 2;
                    }
                }
                if (i - 2 > -1 && j + 2 < endBoard) {
                    if (gameValues[j][i] == 2 && gameValues[j + 1][i - 1] == 2 && gameValues[j + 2][i - 2] == 2) {
                        return 2;
                    }
                }
                if (i + 2 < endBoard && j - 2 > -1) {
                    if (gameValues[j][i] == 2 && gameValues[j - 1][i + 1] == 2 && gameValues[j - 2][i + 2] == 2) {
                        return 2;
                    }
                }

            }
        }
        return 0;
    }

    protected void endMessage() {
        if (isWin() == 1) {
            JOptionPane.showMessageDialog(cruzCero.mDialog, "                 GANASTE!");
            cruzCero.wGame.dispose();
            Menu.wMenu.setVisible(true);
        } else if (isWin() == 2) {
            JOptionPane.showMessageDialog(cruzCero.mDialog, "GANO LA COMPUTADORA!");
            cruzCero.wGame.dispose();
            Menu.wMenu.setVisible(true);

        }
    }

    // ! minMax algorithm//

    protected void miniMax() {
        int bestRow = -1, bestColumn = -1;
        int max, maxActual;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                if (gameValues[j][i] == 0) {
                    int tempRow, tempColumn;
                    gameValues[j][i] = 2;
                    tempRow = i;
                    tempColumn = j;

                    maxActual = ValorMin(0, Integer.MIN_VALUE, Integer.MAX_VALUE);

                    gameValues[tempColumn][tempRow] = 0;

                    if (max < maxActual) {
                        max = maxActual;
                        bestRow = tempRow;
                        bestColumn = tempColumn;
                    }

                }
            }
        }
        gameValues[bestColumn][bestRow] = 2;
        cruzCero.btnGame[bestColumn][bestRow].setText(cruzCero.targetPC);
        consoleLog();
        // endMessage(); desactive la llamada al metodo para que no muestre en
        // JOptionPane 2 veces

    }

    public int ValorMin(int deph, int alfa, int beta) {

        Depth = Menu.nivdif;/* representa nivel de dificultad */
        if (isWin() == 1 || isWin() == 2) {
            return heuristics(deph);
        } else if (isFull()) {
            return heuristics(deph);
        } else if (Depth < deph) {
            return heuristics(deph);
        } else {
            for (int i = 0; i < endBoard; i++) {
                for (int j = 0; j < endBoard; j++) {
                    if (gameValues[j][i] == 0) {
                        int tempRow, tempColumn;
                        gameValues[j][i] = 1;
                        tempRow = i;
                        tempColumn = j;

                        beta = min(beta, ValorMax(deph + 1, alfa, beta));

                        gameValues[tempColumn][tempRow] = 0;

                        if (alfa >= beta) {
                            return alfa;
                        }

                    }
                }
            }
            return beta;
        }

    }

    public int ValorMax(int deph, int alfa, int beta) {
        if (isWin() == 1 || isWin() == 2) {
            return heuristics(deph);
        } else if (isFull()) {
            return heuristics(deph);
        } else {
            for (int i = 0; i < endBoard; i++) {
                for (int j = 0; j < endBoard; j++) {
                    if (gameValues[j][i] == 0) {
                        int tempRow, tempColumn;
                        gameValues[j][i] = 2;
                        tempRow = i;
                        tempColumn = j;

                        alfa = max(alfa, ValorMin(deph + 1, alfa, beta));

                        gameValues[tempColumn][tempRow] = 0;

                        if (alfa >= beta) {
                            return beta;
                        }

                    }
                }
            }
            return alfa;
        }

    }

    public int heuristics(int deph) {
        int cost = 0;
        cost = Cost(2, deph) - Cost(1, deph);
        return cost;
    }

    public int Cost(int jugador, int deph) {
        int value = 0;

        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {

                // Para 3
                if (j + 2 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i] == jugador
                            && gameValues[j + 2][i] == jugador) {
                        value = 1000 - deph;
                    }
                }
                if (i + 2 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j][i + 1] == jugador
                            && gameValues[j][i + 2] == jugador) {
                        value = 1000 - deph;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i + 1] == jugador
                            && gameValues[j + 2][i + 2] == jugador) {
                        value = 1000 - deph;
                    }
                }
                if (i - 2 > -1 && j + 2 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i - 1] == jugador
                            && gameValues[j + 2][i - 2] == jugador) {
                        value = 1000 - deph;
                    }
                }
                if (i + 2 < endBoard && j - 2 > -1) {
                    if (gameValues[j][i] == jugador && gameValues[j - 1][i + 1] == jugador
                            && gameValues[j - 2][i + 2] == jugador) {
                        value = 1000 - deph;
                    }
                }

                if (j + 1 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i] == jugador) {
                        if (value < 300) {
                            value = 300 + deph;
                        }
                    }
                }
                if (i + 1 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j][i + 1] == jugador) {
                        if (value < 300) {
                            value = 300 + deph;
                        }
                    }
                }

                if (i + 1 < endBoard && j + 1 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i + 1] == jugador) {
                        if (value < 300) {
                            value = 300 + deph;
                        }
                    }
                }
                if (i - 1 > -1 && j + 1 < endBoard) {
                    if (gameValues[j][i] == jugador && gameValues[j + 1][i - 1] == jugador) {
                        if (value < 300) {
                            value = 300 + deph;
                        }
                    }
                }
                if (i + 1 < endBoard && j - 1 > -1) {
                    if (gameValues[j][i] == jugador && gameValues[j - 1][i + 1] == jugador) {
                        if (value < 300) {
                            value = 300 + deph;
                        }
                    }
                }

            }
        }

        return value;

    }
}