package ru.gb.perov.Part1.HomeWork4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static ru.gb.perov.Part1.HomeWork4.HomeWork4.*;

public class MyWindow extends JFrame {
    int gap = 1;
    int cellsSize = (50 * SIZE + gap * (SIZE + 1)) < 350 ? (int) (350 / SIZE) : 50;

    String pathCrest = "crest.png";
    String pathZero = "zero.png";

    public MyWindow() throws HeadlessException {
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(cellsSize * SIZE + gap * (SIZE + 1), (cellsSize * SIZE + gap * (SIZE + 1)+60));
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon iconCrest = createIcon(pathCrest);
        ImageIcon iconZero = createIcon(pathZero);
        setLayout(new BorderLayout());
        JPanel numberPanel = new JPanel();
        GridLayout numberLayout = new GridLayout(SIZE, SIZE, gap, gap);
        numberPanel.setLayout(numberLayout);
        JLabel info = new JLabel();
        info.setFont(new Font("Arial", Font.BOLD, 12));
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setText("<html><p align=center><font color=\"blue\" >Победит тот, чья непрерывная цепочка будет не менее «" + DOTS_TO_WIN + " в ряд» (в том числе по диагонали)</p></html>");
        add(info, BorderLayout.BEFORE_FIRST_LINE);

        JButton[][] jButtons = new JButton[SIZE][SIZE];

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                for (int i = 0; i < SIZE; ++i) {
                    for (int j = 0; j < SIZE; j++) {
                        if (jButtons[i][j] == button && map[i][j] == DOT_EMPTY) {
                            button.setIcon(iconCrest);
                            button.repaint();
                            if (humanTurnGUI(i, j)) {
                                PopUpJava("Победил человек!");
                                gameOver(jButtons);
                            } else {
                                if (isMapFull()) {
                                    PopUpJava("Ничья!");
                                    gameOver(jButtons);
                                }
                                int[] turnAI = aiTurnGUI();
                                jButtons[turnAI[0]][turnAI[1]].setIcon(iconZero);
                                jButtons[turnAI[0]][turnAI[1]].repaint();

                                if (checkWin(turnAI[0], turnAI[1], 0, false)[2] > 0) {
                                    PopUpJava("Победил искусственный интеллект!");
                                    gameOver(jButtons);
                                } else {
                                    //printMap();
                                    if (isMapFull()) {
                                        PopUpJava("Ничья!");
                                        gameOver(jButtons);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        };

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                jButtons[i][j] = new JButton("");
                numberPanel.add(jButtons[i][j]);
                jButtons[i][j].addActionListener(actionListener);
            }
        }
        add(numberPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    protected ImageIcon createIcon(String path) {
        URL imgURL = MyWindow.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }

    public void gameOver(JButton[][] jButtons) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                jButtons[i][j].setEnabled(false);
            }
        }
    }

    public void PopUpJava(String message) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, message);
    }
}
