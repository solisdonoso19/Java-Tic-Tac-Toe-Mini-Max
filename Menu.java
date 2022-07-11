import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class Menu extends cruzCero implements ActionListener {
    // JFrame windows
    public static JFrame wMenu, mDialog;
    // X & 0 buttons
    protected JButton[] team = new JButton[2];
    protected JButton[] btnnivel = new JButton[3];
    // exit button & start game button
    private JButton exit, gameInit;
    // JLabel for information
    private JLabel info;
    // object of game
    cruzCero game = new cruzCero();
    // turn
    public static String x0;
    public static int nivdif = 0;
    public static int jugar = 0;
    public static int jugar2 = 0;
    public static int control = 0;

    void printMenuWindow() {

        Font fuente = new Font("Bookman Old Style", Font.BOLD, 16);

        // displays menu windows on screen
        wMenu = new JFrame("Juego X & 0");
        wMenu.setSize(600, 650);
        // this place the window in the center of the screen
        wMenu.setLocationRelativeTo(null);
        wMenu.setLayout(null);
        wMenu.getContentPane().setBackground(Color.WHITE);
        wMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wMenu.setVisible(true);

        info = new JLabel("EQUIS & CERO");
        info.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
        info.setBounds(140, 20, 200, 50);
        wMenu.add(info);

        // buttons X-0
        for (int i = 0; i <= 1; i++) {
            team[i] = new JButton();
            team[i].setFont(fuente);
            team[i].setBounds(50 + 55 * (i % 1), 130 + 55 * (i / 1), 245, 50);
            team[i].setBackground(new java.awt.Color(187, 252, 255));
            team[i].addActionListener(this);
            wMenu.add(team[i]);
        }
        team[0].setText("0");
        team[1].setText("X");

        /* crea botones de nivel de dificultad */
        for (int i = 0; i <= 2; i++) {
            btnnivel[i] = new JButton();
            btnnivel[i].setFont(fuente);
            btnnivel[i].setForeground(Color.WHITE);
            btnnivel[i].setBounds(380 + 55 * (i % 1), 130 + 55 * (i / 1), 150, 50);
            btnnivel[i].addActionListener(this);
            wMenu.add(btnnivel[i]);
        }

        btnnivel[0].setBackground(new java.awt.Color(19, 191, 0));/* verde */
        btnnivel[1].setBackground(new java.awt.Color(242, 205, 0));/* amarillo */
        btnnivel[2].setBackground(new java.awt.Color(191, 1, 1));/* rojo */
        btnnivel[0].setText("Facil");
        btnnivel[1].setText("Normal");
        btnnivel[2].setText("Dificil");

        gameInit = new JButton("Iniciar Juego");
        gameInit.setFont(fuente);
        gameInit.setBounds(40, 250, 265, 50);
        wMenu.add(gameInit);
        gameInit.setBackground(new java.awt.Color(187, 252, 255));
        gameInit.addActionListener(this);
        gameInit.setEnabled(false);/* deshabilita el boton de iniciar juego */

        exit = new JButton("Salir");
        exit.setFont(fuente);
        exit.setForeground(Color.WHITE);
        exit.setBounds(170, 540, 225, 50);
        exit.setBackground(new java.awt.Color(224, 46, 49));
        wMenu.add(exit);
        exit.addActionListener(this);
        // end display buttons

        // some information
        info = new JLabel("info");
        info.setFont(fuente);
        info.setBounds(20, 290, 200, 50);
        wMenu.add(info);

        /* JUAN añadio texto en ventana */
        info = new JLabel("Seleccione un caracter para jugar");
        info.setFont(fuente);
        info.setBounds(20, 80, 500, 50);
        wMenu.add(info);

        info = new JLabel("Nivel de dificultad:");
        info.setFont(fuente);
        info.setBounds(380, 80, 450, 50);
        wMenu.add(info);

        /*
         * JLabel etiqueta = new JLabel();
         * ImageIcon imageIcon=new ImageIcon("D:/gif_animado.gif");
         * etiqueta.setIcon(imageIcon);
         * imageIcon.setImageObserver(etiqueta);
         * wMenu.add(etiqueta);
         */
        initComponents();

    }

    public void actionPerformed(ActionEvent e) {
        // if 0 button is selected
        if (e.getSource() == team[0]) {
            // this change button colors
            team[0].setBackground(new java.awt.Color(78, 212, 112));/* verde de boton seleccionado */
            team[1].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            game.teamX = false;
            game.team0 = true;
            jugar = 1;
            // gameInit.setEnabled(true);/*habilita el boton de iniciar juego cuando se
            // selecciona X o 0*/
            x0 = "0";

        }
        // if X button is selected
        if (e.getSource() == team[1]) {
            // this change button colors
            team[0].setBackground(new java.awt.Color(111, 118, 113));
            team[1].setBackground(new java.awt.Color(78, 212, 112));
            game.teamX = true;
            game.team0 = false;
            jugar = 1;
            // gameInit.setEnabled(true);/*habilita el boton de iniciar juego cuando se
            // selecciona X o 0*/
            x0 = "X";

        }

        /* nivel facil */
        if (e.getSource() == btnnivel[0]) {
            nivdif = 0;
            btnnivel[1].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[1].setEnabled(false);/* desactiva el boton normal color amarrillo */
            btnnivel[2].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[2].setEnabled(false);/* desactiva el boton dificil color rojo */
            jugar2 = 1;
        }
        /* nivel normal */
        if (e.getSource() == btnnivel[1]) {
            nivdif = 2;
            btnnivel[0].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[0].setEnabled(false);/* desactiva el boton facil color verde */
            btnnivel[2].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[2].setEnabled(false);/* desactiva el boton dificil color rojo */
            jugar2 = 1;
        }
        /* nivel dificil */
        if (e.getSource() == btnnivel[2]) {
            nivdif = 5;
            btnnivel[1].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[1].setEnabled(false);/* desactiva el boton normal color amarrillo */
            btnnivel[0].setBackground(new java.awt.Color(111, 118, 113));/* gris */
            btnnivel[0].setEnabled(false);/* desactiva el boton facil color verde */
            jugar2 = 1;
        }

        control_inicio();

        if (control == 2) {
            // if user has no selected a character, display a message
            if (e.getSource() == gameInit) {
                // JOptionPane.showMessageDialog(mDialog, "Por favor seleccione un caracter para
                // jugar");
                wMenu.setVisible(false);
                // this set the menu visible when users close the game windows
                game.printGameWindow(wMenu);// this
                team[0].setBackground(new java.awt.Color(187, 252, 255));
                team[1].setBackground(new java.awt.Color(187, 252, 255));
                btnnivel[0].setEnabled(true);/* habilita el boton facil color verde */
                btnnivel[1].setEnabled(true);/* habilita el boton normal color amarrillo */
                btnnivel[2].setEnabled(true);/* habilita el boton dificil color rojo */

                btnnivel[0].setBackground(new java.awt.Color(19, 191, 0));/* regresa el color al boton verde */
                btnnivel[1].setBackground(new java.awt.Color(242, 205, 0));/* regresa el color al boton amarillo */
                btnnivel[2].setBackground(new java.awt.Color(191, 1, 1));/* regresa el color al boton rojo */
                gameInit.setEnabled(false);/* deshabilita el boton de iniciar juego */
                control = 0;
                jugar = 0;
                jugar2 = 0;
            }
        }

        // exit button
        if (e.getSource() == exit) {
            System.exit(0);
        }

        // System.out.println("el color es "+color);

    }

    public void control_inicio() {
        control = jugar + jugar2;
        gameInit.setEnabled(true);
    }

    private void initComponents() {

        JLabel jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagengif/tres-en-raya-02.gif"))); // Ubicacion
                                                                                                              // del
                                                                                                              // archivo
                                                                                                              // del gif

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(wMenu.getContentPane());
        wMenu.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(330)/* posicion en eje X del gif */
                                .addComponent(jLabel1)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0)/* posicion en eje Y del gif */
                                .addComponent(jLabel1)));
        wMenu.add(jLabel1);

    }

}
