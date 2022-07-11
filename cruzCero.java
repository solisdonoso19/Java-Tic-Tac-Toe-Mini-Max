import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Font;

public class cruzCero extends MinMax implements ActionListener {
    // JFrame windows
    public static JFrame wGame, mDialog;
    // button array
    public static JButton[][] btnGame = new JButton[3][3];
    // booleans for character selected
    protected boolean team0, teamX;
    // Character X & 0
    public static String targetPC, targetHuman;
    // variable to determine first turn
    protected boolean win;
    // object of minmax
    protected MinMax minMax = new MinMax();

    protected JButton btnTemporal = new JButton();

    void printGameWindow(JFrame menu) {
        // initializing matriz on minmax
        minMax.initValues();
        // displays game windows on screen
        wGame = new JFrame("Juego Cruz y Cero-JUEGO");
        // this place the window in the center of the screen
        wGame.setSize(510, 530);
        wGame.setLocationRelativeTo(null);
        wGame.setLayout(null);
        // destroy the windows when users close the game
        wGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wGame.setVisible(true);

        // this set the menu visible when users close the game windows
        visibleMenu(menu);// this
        // display buttons
        for (int i = 0, y = 0; i <= 2; i++, y += 155) {
            for (int j = 0, x = 0; j <= 2; j++, x += 155) {
                btnGame[i][j] = new JButton("");
                btnGame[i][j].setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
                btnGame[i][j].setBounds(x, y, 155, 155);
                btnGame[i][j].addActionListener(this);
                wGame.add(btnGame[i][j]);
            }
        }
        // initializing target
        if (team0) {
            targetHuman = "0";
            targetPC = "X";
        } else {
            targetHuman = "X";
            targetPC = "0";
        }
        if (!turno()) {
            // this is the best movement to first player
            minMax.miniMax();
        }

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
        if (firstTurn < 0.7) { // <- determined 60% of the time
            if (Menu.x0=="0") {
                JOptionPane.showMessageDialog(mDialog, "Inicia la COMPUTADORA con X !");
                return false;
            } else {
                JOptionPane.showMessageDialog(mDialog, "Inicia la COMPUTADORA con 0 !");
                return false;
            }
            
        } else {
            JOptionPane.showMessageDialog(mDialog, "El primer turno es de USTED! \n            Juegas con "+Menu.x0);
            return true; // <- other 40%
        }
    }

    /*
     * Ejecuta la accion de mostrar la ventana del menu y ocultar la ventana de
     * juego
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (e.getSource() == btnGame[i][j] && minMax.gameValues[i][j] == 0) {
                    btnGame[i][j].setText(targetHuman);
                    minMax.gameValues[i][j] = 1;
                    minMax.consoleLog();
                    btnGame[i][j].removeActionListener(this);
                    if (!minMax.isFull() && (minMax.isWin() != 1 && minMax.isWin() != 2)) {
                        minMax.miniMax();
                    }
                    minMax.endMessage();/* esto hacia que se muestre 2 veces el mensaje que la pc gano, ya se corrigio*/
                    if (minMax.isFull()) {
                        JOptionPane.showMessageDialog(cruzCero.mDialog, "                  EMPATE!\n        SIGUE INTENTANDO!");
                        cruzCero.wGame.dispose();
                        Menu.wMenu.setVisible(true);

                    }
                }
            }
        }
    }
}
