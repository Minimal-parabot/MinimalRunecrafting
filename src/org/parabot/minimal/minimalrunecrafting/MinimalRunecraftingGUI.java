package org.parabot.minimal.minimalrunecrafting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinimalRunecraftingGUI extends JFrame
{
    private JPanel buttonPanel;

    private Font font = new Font("Helvetica", Font.PLAIN, 18);

    private JComboBox<Altar> altarComboBox = new JComboBox<>();

    private final int WINDOW_WIDTH = 250;
    private final int WINDOW_HEIGHT = 125;

    public MinimalRunecraftingGUI()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buildButtonPanel();

        add(buttonPanel);
    }

    private void buildButtonPanel()
    {
        buttonPanel = new JPanel();

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        altarComboBox = new JComboBox<>();
        altarComboBox.setFont(font);
        altarComboBox.setRenderer(dlcr);

        for (Altar a : Altar.getAltars())
        {
            altarComboBox.addItem(a);
        }

        JButton startButton = new JButton("Start");
        startButton.setFont(font);
        startButton.addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });

        buttonPanel.add(altarComboBox);
        buttonPanel.add(startButton);
    }

    /**
     * Gets the selected altar from the altarComboBox
     * @return altar
     */
    public Altar getAltar()
    {
        return (Altar) altarComboBox.getSelectedItem();
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                MinimalRunecraftingGUI gui = new MinimalRunecraftingGUI();

                gui.setVisible(true);
            }
        });
    }
}