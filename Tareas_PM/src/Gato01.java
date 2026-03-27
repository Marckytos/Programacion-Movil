import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gato01 extends JFrame implements ActionListener {
    JButton botones[] = new JButton[9];
    boolean turnoX;
    Font fuente = new Font("Arial", 1, 50);
    JButton btnReiniciar;
    JPanel panelJuego, panelOpciones;

    public Gato01() {
        setSize(400, 400);
        setTitle("Juego Gato");
        setDefaultCloseOperation(3);

        panelJuego = new JPanel(new GridLayout(3, 3));
        panelOpciones = new JPanel();

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            panelJuego.add(botones[i]);
        }

        btnReiniciar = new JButton("Reiniciar Juego");
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < botones.length; i++) {
                    botones[i].setText("");
                    botones[i].setEnabled(true);
                    turnoX = true;
                }
            }
        });

        panelOpciones.add(btnReiniciar);
        add(panelJuego, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        String letra;
        if (turnoX) {
            letra = "X";
            turnoX = false;
        } else {
            letra = "O";
            turnoX = true;
        }

        for (int i = 0; i < botones.length; i++) {
            if (e.getSource() == botones[i]) {
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }
        }

        verificarGanador();
    }

    // NUEVO: método que verifica todas las combinaciones ganadoras
    private void verificarGanador() {
        int[][] combinaciones = {
                {0, 1, 2}, // fila superior
                {3, 4, 5}, // fila media
                {6, 7, 8}, // fila inferior
                {0, 3, 6}, // columna izquierda
                {1, 4, 7}, // columna central
                {2, 5, 8}, // columna derecha
                {0, 4, 8}, // diagonal principal
                {2, 4, 6}  // diagonal inversa
        };

        for (int[] combo : combinaciones) {
            String a = botones[combo[0]].getText();
            String b = botones[combo[1]].getText();
            String c = botones[combo[2]].getText();

            if (!a.isEmpty() && a.equals(b) && b.equals(c)) {
                JOptionPane.showMessageDialog(this, "¡El jugador " + a + " ha ganado!");
                bloquearTablero();
                return;
            }
        }

        // Verificar empate
        boolean empate = true;
        for (JButton btn : botones) {
            if (btn.getText().isEmpty()) {
                empate = false;
                break;
            }
        }

        if (empate) {
            JOptionPane.showMessageDialog(this, "¡Es un empate!");
        }
    }

    // NUEVO: bloquea todos los botones al terminar la partida
    private void bloquearTablero() {
        for (JButton btn : botones) {
            btn.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        Gato01 juego = new Gato01();
        juego.setVisible(true);
    }
}