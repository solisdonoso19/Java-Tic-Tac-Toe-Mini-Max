import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.*;
import java.awt.Font;
import java.awt.event.*;

public class Menu extends cruzCero implements ActionListener {
    // JFrame windows
    protected JFrame wMenu, mDialog;
    // X & 0 buttons
    protected JButton[] team = new JButton[2];
    // exit button & start game button
    private JButton exit, gameInit;
    // JLabel for information
    private JLabel info;
    // object of game
    cruzCero game = new cruzCero();

    void printMenuWindow() {
        // displays menu windows on screen
        wMenu = new JFrame("Juego Cruz y Cero");
        wMenu.setSize(300, 500);
        // this place the window in the center of the screen
        wMenu.setLocationRelativeTo(null);
        wMenu.setLayout(null);
        wMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wMenu.setVisible(true);

        // display buttons
        for (int i = 0; i <= 1; i++) {
            team[i] = new JButton();
            team[i].setBounds(10 + 55 * (i % 1), 80 + 55 * (i / 1), 265, 50);
            team[i].addActionListener(this);
            wMenu.add(team[i]);
        }
        team[0].setText("0");
        team[1].setText("X");

        gameInit = new JButton("Iniciar Juego");
        gameInit.setBounds(10, 200, 265, 50);
        wMenu.add(gameInit);
        gameInit.addActionListener(this);

        exit = new JButton("Salir");
        exit.setBounds(10, 400, 265, 50);
        wMenu.add(exit);
        exit.addActionListener(this);
        // end display buttons

        // some information
        info = new JLabel("info");
        info.setBounds(10, 250, 200, 50);
        wMenu.add(info);

        info = new JLabel("Cruz & Cero");
        info.setBounds(10, 10, 200, 50);
        wMenu.add(info);

        /* JUAN añadio texto en ventana */
        info = new JLabel("Seleccione un caracter para jugar");
        /* info.setFont(new Font("Serif", Font.PLAIN,20)); */
        info.setBounds(10, 40, 500, 50);
        wMenu.add(info);
    }

    public void actionPerformed(ActionEvent e) {
        // if 0 button is selected
        if (e.getSource() == team[0]) {
            // this change button colors
            team[0].setBackground(new java.awt.Color(78, 212, 112));
            team[1].setBackground(new java.awt.Color(111, 118, 113));
            game.teamX = false;
            game.team0 = true;
        }
        // if X button is selected
        if (e.getSource() == team[1]) {
            // this change button colors
            team[0].setBackground(new java.awt.Color(111, 118, 113));
            team[1].setBackground(new java.awt.Color(78, 212, 112));
            game.teamX = true;
            game.team0 = false;
        }

        if (e.getSource() == gameInit) {
            // if user has no selected a character, display a message
            if (team0 == false && teamX == false) {
                JOptionPane.showMessageDialog(mDialog, "Por favor seleccione un caracter para jugar");
            } else {
                wMenu.setVisible(false);
                // this set the menu visible when users close the game windows
                game.printGameWindow(wMenu);
            }
        }

        // exit button
        if (e.getSource() == exit) {
            System.exit(0);
        }

    }

}
