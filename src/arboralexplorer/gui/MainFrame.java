/*
 * Copyright 2016 Sander Verdonschot <sander.verdonschot at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package arboralexplorer.gui;

import arboralexplorer.algo.GreedyASS;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    public DrawPanel drawPanel;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(1000, 600));
        centerPanel.add(drawPanel, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        groundSetSizeLabel = new javax.swing.JLabel();
        extraPointsLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        pointSetMenu = new javax.swing.JMenu();
        randomMenuItem = new javax.swing.JMenuItem();
        randomPermutationMenuItem = new javax.swing.JMenuItem();
        solveMenu = new javax.swing.JMenu();
        greedyMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Editor");

        centerPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        centerPanel.setLayout(new java.awt.BorderLayout());

        groundSetSizeLabel.setText("Ground Set: X");

        extraPointsLabel.setText("Additional: Y");

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groundSetSizeLabel)
                .addGap(18, 18, 18)
                .addComponent(extraPointsLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groundSetSizeLabel)
                    .addComponent(extraPointsLabel))
                .addGap(6, 6, 6))
        );

        centerPanel.add(statusPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("New");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open...");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save...");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        pointSetMenu.setText("Point Set");

        randomMenuItem.setText("Random");
        randomMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomMenuItemActionPerformed(evt);
            }
        });
        pointSetMenu.add(randomMenuItem);

        randomPermutationMenuItem.setText("Random Permutation");
        randomPermutationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomPermutationMenuItemActionPerformed(evt);
            }
        });
        pointSetMenu.add(randomPermutationMenuItem);

        menuBar.add(pointSetMenu);

        solveMenu.setText("Solve");

        greedyMenuItem.setText("GreedyASS");
        greedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(greedyMenuItem);

        menuBar.add(solveMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed

    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        int n = 0, m = 0;

        do {
            String response = (String) JOptionPane.showInputDialog(this, "Specify n and m (e.g. \"7 4\"):", "Arboral Explorer", JOptionPane.QUESTION_MESSAGE, null, null, drawPanel.getGrid().length + " " + drawPanel.getGrid()[0].length);

            if (response == null || response.isEmpty()) {
                return;
            }

            String[] parts = response.split("\\s+");

            if (parts.length != 2) {
                continue;
            }

            try {
                n = Integer.parseInt(parts[0]);
                m = Integer.parseInt(parts[1]);
            } catch (NumberFormatException ex) {
            }
        } while (n <= 0 || m <= 0);

        drawPanel.setGrid(new boolean[n][m]);
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void randomPermutationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomPermutationMenuItemActionPerformed
        int n = drawPanel.getGrid().length;

        if (n > 0) {
            List<Integer> permutation = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                permutation.add(i);
            }

            Collections.shuffle(permutation);

            boolean[][] newGrid = new boolean[n][drawPanel.getGrid()[0].length];

            for (int j = 0; j < newGrid[0].length; j++) {
                newGrid[permutation.get(j % n)][j] = true;
            }

            drawPanel.setGrid(newGrid);
            drawPanel.setGroundSet(newGrid);
        }
    }//GEN-LAST:event_randomPermutationMenuItemActionPerformed

    private void randomMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomMenuItemActionPerformed
        int n = drawPanel.getGrid().length;

        if (n > 0) {
            int m = drawPanel.getGrid()[0].length;
            boolean[][] newGrid = new boolean[n][m];
            Random rand = new Random();

            for (int j = 0; j < m; j++) {
                newGrid[rand.nextInt(n)][j] = true;
            }

            drawPanel.setGrid(newGrid);
            drawPanel.setGroundSet(newGrid);
        }
    }//GEN-LAST:event_randomMenuItemActionPerformed

    private void greedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greedyMenuItemActionPerformed
        boolean[][] groundSet = drawPanel.getGroundSet();

        drawPanel.setGrid(GreedyASS.solve(groundSet));
        drawPanel.setGroundSet(groundSet);
    }//GEN-LAST:event_greedyMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel extraPointsLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem greedyMenuItem;
    private javax.swing.JLabel groundSetSizeLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenu pointSetMenu;
    private javax.swing.JMenuItem randomMenuItem;
    private javax.swing.JMenuItem randomPermutationMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenu solveMenu;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}
