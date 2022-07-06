import javax.swing.*;
import java.util.*;

public class MinMax {
    private Integer[] gameValues = new Integer[9];
    private Integer deepth = 1;
    private static Integer endboard = 9;
    private booelan change = false;

    public void assigValues(JButton[] btnGame) {
        for (int i = 0; i < endboard; i++) {
            if (btnGame[i].getText().compareTo("0") == 0) {
                gameValues[i] = 2;
            } else if (btnGame[i].getText().compareTo("X") == 0) {
                gameValues[i] = 1;
            } else {
                gameValues[i] = 0;
            }
            System.out.println(gameValues[i]);
        }
    }

    // function to determinate wins
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

    private void miniMax() {
        int bestPlay, max, actualMax;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < endboard; i++) {
            if (gameValues[i] == 0) {
                int tmpBestPlay;
                gameValues[i] = 2;
                tmpBestPlay = i;

                actualMax = minValue(Integer.MIN_VALUE, Integer.MAX_VALUE);
                gameValues[tmpBestPlay] = 0;

                if (max < actualMax) {
                    max = actualMax;
                    bestPlay = tmpBestPlay;
                }
            }
        }
        gameValues[bestPlay] = 1;
        change = false;
    }

    public int minValue(int alfa, int bera) {

    }

    public void maxValue() {

    }

    public void heuristica() {

    }

    public void cost() {

    }

}