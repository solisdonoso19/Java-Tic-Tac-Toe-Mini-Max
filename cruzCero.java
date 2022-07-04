import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class cruzCero implements ActionListener {
    protected JFrame wGame, mDialog;
    protected JButton[] btnGame = new JButton[9];
    protected JButton btnTemporal = new JButton();;
    protected boolean team0, teamX;

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
        btnTemporal.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("entrando al action performed");
        btnTemporal = (JButton) e.getSource();
        if (btnTemporal == e.getSource()) {
            System.out.println(team0 + " | " + teamX);
        }
    }
}
