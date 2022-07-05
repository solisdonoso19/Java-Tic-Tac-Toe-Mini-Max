import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class cruzCero implements ActionListener {
    // JFrame windows
    protected JFrame wGame, mDialog;
    // button array
    protected JButton[] btnGame = new JButton[9];
    // booleans for character selected
    protected boolean team0, teamX;
    // Character X & 0
    protected String target;
    // variable to determine first turn
    protected boolean turn;

    void printGameWindow(JFrame menu) {
        // displays game windows on screen
        JFrame wGame = new JFrame("Juego Cruz y Cero");
        // this place the window in the center of the screen
        wGame.setSize(500, 500);
        wGame.setLocationRelativeTo(null);
        wGame.setLayout(null);
        // destroy the windows when users close the game
        wGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wGame.setVisible(true);

        // this set the menu visible when users close the game windows
        wGame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                menu.setVisible(true);
            }
        });
        // display buttons
        for (int i = 0; i <= 8; i++) {
            btnGame[i] = new JButton("");
            btnGame[i].setBounds(166 * (i % 3), 166 * (i / 3), 166, 166);
            btnGame[i].addActionListener(this);
            wGame.add(btnGame[i]);
        }
        // initializing target
        if (team0) {
            target = "0";
        } else {
            target = "X";
        }

        turn = turno();
    }

    // function to determine who starts first
    // 60% of the time the computer starts
    boolean turno() {
        double firstTurn = Math.random();
        if (firstTurn < 0.6) { // <- determined 60% of the time
            JOptionPane.showMessageDialog(mDialog, "El primer turno es de la COMPUTADORA!");
            return false;
        } else {
            JOptionPane.showMessageDialog(mDialog, "El primer turno es de USTED!");
            return true; // <- other 40%
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGame[0]) {
            // if my turn?
            if (turn) { // yes, so
                btnGame[0].setText(target);
                // target value exchange
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[1]) {
            if (turn) {
                btnGame[1].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[2]) {
            if (turn) {
                btnGame[2].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[3]) {
            if (turn) {
                btnGame[3].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[4]) {
            if (turn) {
                btnGame[4].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[5]) {
            if (turn) {
                btnGame[5].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[6]) {
            if (turn) {
                btnGame[6].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[7]) {
            if (turn) {
                btnGame[7].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

        if (e.getSource() == btnGame[8]) {
            if (turn) {
                btnGame[8].setText(target);
                if (target.equals("0")) {
                    target = "X";
                } else if (target.equals("X")) {
                    target = "0";
                }
            }
        }

    }
}
