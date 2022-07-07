import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Font;

public class cruzCero extends MinMax implements ActionListener {
    // JFrame windows
    protected JFrame wGame, mDialog;
    // button array
    protected JButton[] btnGame = new JButton[9];
    // booleans for character selected
    protected boolean team0, teamX;
    // Character X & 0
    protected String target;
    // variable to determine first turn
    protected boolean turn, win;
    // object of minmax
    protected MinMax minMax = new MinMax();

    protected JButton btnTemporal = new JButton();

    void printGameWindow(JFrame menu) {
        // displays game windows on screen
        wGame = new JFrame("Juego Cruz y Cero-JUEGO");
        // this place the window in the center of the screen
        wGame.setSize(600, 600);
        wGame.setLocationRelativeTo(null);
        wGame.setLayout(null);
        // destroy the windows when users close the game
        wGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wGame.setVisible(true);

        // this set the menu visible when users close the game windows
        visibleMenu(menu);// this
        // display buttons
        for (int i = 0; i <= 8; i++) {
            btnGame[i] = new JButton("");
            btnGame[i].setFont(new Font("Serif", Font.PLAIN, 22));
            btnGame[i].setBounds(166 * (i % 3), 166 * (i / 3), 155, 155);
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

    // set visible menu windows
    void visibleMenu(JFrame menu) {
        wGame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                menu.setVisible(true);
            }
        });
    }

    // function to determine who starts first
    // 60% of the time the computer starts
    boolean turno() {
        double firstTurn = Math.random();
        if (firstTurn < 0.2) { // <- determined 60% of the time
            JOptionPane.showMessageDialog(mDialog, "El primer turno es de la COMPUTADORA!");
            return false;
        } else {
            JOptionPane.showMessageDialog(mDialog, "El primer turno es de USTED!");
            return true; // <- other 40%
        }
    }

    /* Ejecuta la accion de mostrar la ventana del menu y ocultar la ventana de juego */
    public void actionPerformed(ActionEvent e) {

        btnTemporal = (JButton) e.getSource();
        if (e.getSource() == btnTemporal) {
            System.out.println("entrando al boton temporal");
        }
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

            minMax.assigValues(btnGame);
            // call the win function

            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "Empate");
                // this close de windows of the game to return to the menu
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // this close de windows of the game to return to the menu
                //wGame.dispose();
                // !!!!! i couldn't do that the menu windows set visible when the game is over
                // !!!!!!
                // visibleMenu(menu);
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);

            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
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
            minMax.assigValues(btnGame);
            if (minMax.tieGame()) {
                JOptionPane.showMessageDialog(mDialog, "EMPATE!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
            }
            if (win = minMax.winGame() == true) {
                JOptionPane.showMessageDialog(mDialog, "Has ganado!");
                // wGame.dispose();
                Menu.wMenu.setVisible(true);
                wGame.setVisible(false);
            }
        }

    }
}
