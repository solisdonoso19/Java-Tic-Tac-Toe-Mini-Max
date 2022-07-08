import javax.swing.*;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.*;

public class MinMax {
    private Integer[] gameValues = new Integer[9];
    private Integer deepth = 1;
    private static Integer endboard = 9;
    private boolean change = false;

    public void assigValues() {
        for (int i = 0; i < endboard; i++) {
            if (cruzCero.btnGame[i].getText().compareTo("0") == 0) {
                gameValues[i] = 2;
            } else if (cruzCero.btnGame[i].getText().compareTo("X") == 0) {
                gameValues[i] = 1;
            } else {
                gameValues[i] = 0;
            }
        }
    }

    // function to determinate wins
    public boolean tieGame() {
        boolean tie = true;
        for (int i = 0; i < endboard; i++) {
            if (gameValues[i] == 1 || gameValues[i] == 2) {
                continue;
            } else {
                return false;
            }
        }
        return tie;

    }

    public boolean winGame() {
        if (gameValues[0] == gameValues[1] && gameValues[1] == gameValues[2] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[3] == gameValues[4] && gameValues[4] == gameValues[5] && gameValues[3] != 0) {
            return true;
        } else if (gameValues[6] == gameValues[7] && gameValues[7] == gameValues[8] && gameValues[6] != 0) {
            return true;
        } else if (gameValues[0] == gameValues[3] && gameValues[3] == gameValues[6] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[1] == gameValues[4] && gameValues[4] == gameValues[7] && gameValues[1] != 0) {
            return true;
        } else if (gameValues[2] == gameValues[5] && gameValues[5] == gameValues[8] && gameValues[2] != 0) {
            return true;
        } else if (gameValues[0] == gameValues[4] && gameValues[4] == gameValues[8] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[2] == gameValues[4] && gameValues[4] == gameValues[6] && gameValues[2] != 0) {
            return true;
        }
        return false;
    }

    void miniMax() {
        int bestPlay = -1, max = 0, actualMax = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < endboard; i++) {
            if (gameValues[i] == 0) {
                int tmpBestPlay;
                gameValues[i] = 2;
                tmpBestPlay = i;

                actualMax = minValue(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                gameValues[tmpBestPlay] = 0;

                if (max < actualMax) {
                    max = actualMax;
                    bestPlay = tmpBestPlay;
                }
            }
        }

        gameValues[bestPlay] = 2;
        cruzCero.btnGame[bestPlay].setText(cruzCero.target);
        change = true;
    }

    public int minValue(int deph, int alfa, int beta) {
        if (winGame() || tieGame()) {
            return heuristica();
        } else if (deepth < deph) {
            return heuristica();
        } else {
            for (int i = 0; i < endboard; i++) {
                if (gameValues[i] == 0) {
                    int tmpBestPlay;
                    gameValues[i] = 1;
                    tmpBestPlay = i;

                    beta = min(beta, maxValue(deph + 1, alfa, beta));
                    gameValues[tmpBestPlay] = 0;
                    if (alfa >= beta) {
                        return alfa;

                    }
                }
            }
            return beta;
        }
    }

    public int maxValue(int deph, int alfa, int beta) {
        if (winGame() || tieGame()) {
            return heuristica();
        } else if (deepth < deph) {
            return heuristica();
        } else {
            for (int i = 0; i < endboard; i++) {
                if (gameValues[i] == 0) {
                    int tmpBestPlay;
                    gameValues[i] = 2;
                    tmpBestPlay = i;

                    alfa = max(alfa, maxValue(deph + 1, alfa, beta));
                    gameValues[tmpBestPlay] = 0;
                    if (alfa >= beta) {
                        return beta;

                    }
                }
            }
            return alfa;
        }
    }

    public int heuristica() {
        int costo = 0;
        costo = cost(2) - cost(1);
        return costo;
    }

    public int cost(int player) {
        int value = 0;
        if (gameValues[0] == gameValues[1] && gameValues[1] == gameValues[2] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[3] == gameValues[4] && gameValues[4] == gameValues[5] && gameValues[3] != 0) {
            return true;
        } else if (gameValues[6] == gameValues[7] && gameValues[7] == gameValues[8] && gameValues[6] != 0) {
            return true;
        } else if (gameValues[0] == gameValues[3] && gameValues[3] == gameValues[6] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[1] == gameValues[4] && gameValues[4] == gameValues[7] && gameValues[1] != 0) {
            return true;
        } else if (gameValues[2] == gameValues[5] && gameValues[5] == gameValues[8] && gameValues[2] != 0) {
            return true;
        } else if (gameValues[0] == gameValues[4] && gameValues[4] == gameValues[8] && gameValues[0] != 0) {
            return true;
        } else if (gameValues[2] == gameValues[4] && gameValues[4] == gameValues[6] && gameValues[2] != 0) {
            return true;
        }
        return false;
    }return 0;
}

}