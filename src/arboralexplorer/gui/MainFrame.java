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

import arboralexplorer.algo.upperbound.GreedyASS;
import arboralexplorer.algo.upperbound.ILPSolver;
import arboralexplorer.algo.upperbound.OptStaticTree;
import arboralexplorer.algo.upperbound.StaticBalancedTree;
import arboralexplorer.algo.upperbound.StupidOpt;
import arboralexplorer.algo.lowerbound.SignedGreedy;
import arboralexplorer.data.GridSet;
import jCMPL.CmplException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame implements SetChangeListener {

    public final DrawPanel drawPanel;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        drawPanel = new DrawPanel();
        drawPanel.addChangeListener(this);
        drawPanel.setPreferredSize(new Dimension(1000, 600));
        centerPanel.add(drawPanel, BorderLayout.CENTER);
    }

    @Override
    public void gridChanged(DrawPanel source, GridSet newGrid) {
        groundSetSizeLabel.setText("Ground Set: " + newGrid.getGroundSetSize());
        extraPointsLabel.setText("Additional: " + (newGrid.getSize() - newGrid.getGroundSetSize()));
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
        fixGroundMenuItem = new javax.swing.JMenuItem();
        randomMenuItem = new javax.swing.JMenuItem();
        randomPermutationMenuItem = new javax.swing.JMenuItem();
        solveMenu = new javax.swing.JMenu();
        clearMenuItem = new javax.swing.JMenuItem();
        greedyMenuItem = new javax.swing.JMenuItem();
        staticBalancedMenuItem = new javax.swing.JMenuItem();
        optStaticTreeMenuItem = new javax.swing.JMenuItem();
        stupidOptMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        signedPositiveGreedyMenuItem = new javax.swing.JMenuItem();
        signedNegativeGreedyMenuItem = new javax.swing.JMenuItem();
        signedUnionGreedyMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arboral Explorer");
        getContentPane().setLayout(new java.awt.BorderLayout());

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

        pointSetMenu.setText("Ground Set");

        fixGroundMenuItem.setText("Use Current Points");
        fixGroundMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixGroundMenuItemActionPerformed(evt);
            }
        });
        pointSetMenu.add(fixGroundMenuItem);

        randomMenuItem.setText("Random");
        randomMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomMenuItemActionPerformed(evt);
            }
        });
        pointSetMenu.add(randomMenuItem);

        randomPermutationMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        randomPermutationMenuItem.setText("Random Permutation");
        randomPermutationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomPermutationMenuItemActionPerformed(evt);
            }
        });
        pointSetMenu.add(randomPermutationMenuItem);

        menuBar.add(pointSetMenu);

        solveMenu.setText("Solve");

        clearMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        clearMenuItem.setText("Clear Solution");
        clearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(clearMenuItem);

        greedyMenuItem.setText("GreedyASS");
        greedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(greedyMenuItem);

        staticBalancedMenuItem.setText("Static Balanced BST");
        staticBalancedMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticBalancedMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(staticBalancedMenuItem);

        optStaticTreeMenuItem.setText("Opt Static Tree");
        optStaticTreeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optStaticTreeMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(optStaticTreeMenuItem);

        stupidOptMenuItem.setText("Super slow opt");
        stupidOptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stupidOptMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(stupidOptMenuItem);

        jMenuItem1.setText("ILP Opt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        solveMenu.add(jMenuItem1);

        signedPositiveGreedyMenuItem.setText("Signed Positive Greedy");
        signedPositiveGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedPositiveGreedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(signedPositiveGreedyMenuItem);

        signedNegativeGreedyMenuItem.setText("Signed Negative Greedy");
        signedNegativeGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedNegativeGreedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(signedNegativeGreedyMenuItem);

        signedUnionGreedyMenuItem.setText("Signed Union Greedy");
        signedUnionGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedUnionGreedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(signedUnionGreedyMenuItem);

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
            String response = (String) JOptionPane.showInputDialog(this, "Specify n and m (e.g. \"7 4\"):", "Arboral Explorer", JOptionPane.QUESTION_MESSAGE, null, null, drawPanel.getGrid().getWidth() + " " + drawPanel.getGrid().getHeight());

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

        drawPanel.setGrid(new GridSet(new boolean[n][m]));
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void randomPermutationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomPermutationMenuItemActionPerformed
        int n = drawPanel.getGrid().getWidth();

        if (n > 0) {
            List<Integer> permutation = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                permutation.add(i);
            }

            Collections.shuffle(permutation);

            boolean[][] newGrid = new boolean[n][drawPanel.getGrid().getHeight()];

            for (int j = 0; j < newGrid[0].length; j++) {
                newGrid[permutation.get(j % n)][j] = true;
            }

            drawPanel.setGrid(new GridSet(newGrid));
        }
    }//GEN-LAST:event_randomPermutationMenuItemActionPerformed

    private void randomMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomMenuItemActionPerformed
        int n = drawPanel.getGrid().getWidth();

        if (n > 0) {
            int m = drawPanel.getGrid().getHeight();
            boolean[][] newGrid = new boolean[n][m];
            Random rand = new Random();

            for (int j = 0; j < m; j++) {
                newGrid[rand.nextInt(n)][j] = true;
            }

            drawPanel.setGrid(new GridSet(newGrid));
        }
    }//GEN-LAST:event_randomMenuItemActionPerformed

    private void greedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greedyMenuItemActionPerformed
        drawPanel.setGrid(GreedyASS.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_greedyMenuItemActionPerformed

    private void clearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMenuItemActionPerformed
        drawPanel.setGrid(new GridSet(drawPanel.getGrid().getGroundSet()));
    }//GEN-LAST:event_clearMenuItemActionPerformed

    private void fixGroundMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixGroundMenuItemActionPerformed
        drawPanel.setGrid(new GridSet(drawPanel.getGrid().getGridSet()));
    }//GEN-LAST:event_fixGroundMenuItemActionPerformed

    private void staticBalancedMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticBalancedMenuItemActionPerformed
        drawPanel.setGrid(StaticBalancedTree.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_staticBalancedMenuItemActionPerformed

    private void optStaticTreeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optStaticTreeMenuItemActionPerformed
        drawPanel.setGrid(OptStaticTree.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_optStaticTreeMenuItemActionPerformed

    private void stupidOptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stupidOptMenuItemActionPerformed
        drawPanel.setGrid(StupidOpt.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_stupidOptMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            drawPanel.setGrid(ILPSolver.solve(drawPanel.getGrid()));
        } catch (CmplException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void signedPositiveGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedPositiveGreedyMenuItemActionPerformed
        drawPanel.setGrid(SignedGreedy.solve(SignedGreedy.Sign.Positive, drawPanel.getGrid()));
    }//GEN-LAST:event_signedPositiveGreedyMenuItemActionPerformed

    private void signedNegativeGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedNegativeGreedyMenuItemActionPerformed
                drawPanel.setGrid(SignedGreedy.solve(SignedGreedy.Sign.Negative, drawPanel.getGrid()));
    }//GEN-LAST:event_signedNegativeGreedyMenuItemActionPerformed

    private void signedUnionGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedUnionGreedyMenuItemActionPerformed
        drawPanel.setGrid(SignedGreedy.solveSignedUnion(drawPanel.getGrid()));
    }//GEN-LAST:event_signedUnionGreedyMenuItemActionPerformed

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
    private javax.swing.JMenuItem clearMenuItem;
    private javax.swing.JLabel extraPointsLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fixGroundMenuItem;
    private javax.swing.JMenuItem greedyMenuItem;
    private javax.swing.JLabel groundSetSizeLabel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem optStaticTreeMenuItem;
    private javax.swing.JMenu pointSetMenu;
    private javax.swing.JMenuItem randomMenuItem;
    private javax.swing.JMenuItem randomPermutationMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem signedNegativeGreedyMenuItem;
    private javax.swing.JMenuItem signedPositiveGreedyMenuItem;
    private javax.swing.JMenuItem signedUnionGreedyMenuItem;
    private javax.swing.JMenu solveMenu;
    private javax.swing.JMenuItem staticBalancedMenuItem;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem stupidOptMenuItem;
    // End of variables declaration//GEN-END:variables

}
