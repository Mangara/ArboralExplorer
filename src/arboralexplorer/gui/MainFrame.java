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

import arboralexplorer.algo.GridSetGenerator;
import arboralexplorer.algo.lowerbound.LinearProgramLB;
import arboralexplorer.algo.upperbound.GreedyASS;
import arboralexplorer.algo.upperbound.ILPSolver;
import arboralexplorer.algo.upperbound.OptStaticTree;
import arboralexplorer.algo.upperbound.StaticBalancedTree;
import arboralexplorer.algo.upperbound.StupidOpt;
import arboralexplorer.algo.lowerbound.SignedGreedy;
import arboralexplorer.algo.lowerbound.Wilber1;
import arboralexplorer.algo.upperbound.GreedyRectangle;
import arboralexplorer.algo.upperbound.IncreasingSS;
import arboralexplorer.algo.upperbound.RandomMinimal;
import arboralexplorer.data.GridSet;
import arboralexplorer.io.GridSetReader;
import arboralexplorer.io.GridSetWriter;
import jCMPL.CmplException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame implements SetChangeListener {

    public final DrawPanel drawPanel;
    private final JFileChooser openFileChooser;
    private final JFileChooser saveFileChooser;
    private final String myExtension = "ass";
    private final FileNameExtensionFilter myFilter = new FileNameExtensionFilter("Arborally Satisfied Sets", myExtension);

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        drawPanel = new DrawPanel();
        drawPanel.addChangeListener(this);
        drawPanel.setPreferredSize(new Dimension(1000, 600));
        centerPanel.add(drawPanel, BorderLayout.CENTER);

        // Initialize the file choosers
        openFileChooser = new JFileChooser(System.getProperty("user.dir"));
        openFileChooser.addChoosableFileFilter(myFilter);
        openFileChooser.setFileFilter(myFilter);
        saveFileChooser = new JFileChooser(System.getProperty("user.dir"));
        saveFileChooser.addChoosableFileFilter(myFilter);
        saveFileChooser.setFileFilter(myFilter);
    }

    @Override
    public void gridChanged(DrawPanel source, GridSet newGrid) {
        groundSetSizeLabel.setText("Ground Set: " + newGrid.getGroundSetSize());
        extraPointsLabel.setText("Additional: " + (newGrid.getSize() - newGrid.getGroundSetSize()));
        violationsLabel.setText("Violations: " + newGrid.getViolations().size());
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
        violationsLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        drawMenu = new javax.swing.JMenu();
        drawCriticalityMenuItem = new javax.swing.JCheckBoxMenuItem();
        pointSetMenu = new javax.swing.JMenu();
        fixGroundMenuItem = new javax.swing.JMenuItem();
        randomMenuItem = new javax.swing.JMenuItem();
        randomPermutationMenuItem = new javax.swing.JMenuItem();
        solveMenu = new javax.swing.JMenu();
        clearMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        greedyMenuItem = new javax.swing.JMenuItem();
        ilpOptMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        staticBalancedMenuItem = new javax.swing.JMenuItem();
        optStaticTreeMenuItem = new javax.swing.JMenuItem();
        stupidOptMenuItem = new javax.swing.JMenuItem();
        randMinimalMenuItem = new javax.swing.JMenuItem();
        lowerboundMenu = new javax.swing.JMenu();
        lplbMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        signedPositiveGreedyMenuItem = new javax.swing.JMenuItem();
        signedNegativeGreedyMenuItem = new javax.swing.JMenuItem();
        signedUnionGreedyMenuItem = new javax.swing.JMenuItem();
        bestSignedGreedyMenuItem = new javax.swing.JMenuItem();
        wilber1MenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        rectMenuItem = new javax.swing.JMenuItem();
        LISS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arboral Explorer");

        centerPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        centerPanel.setLayout(new java.awt.BorderLayout());

        groundSetSizeLabel.setText("Ground Set: X");

        extraPointsLabel.setText("Additional: Y");

        violationsLabel.setText("Violations: Z");

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groundSetSizeLabel)
                .addGap(18, 18, 18)
                .addComponent(extraPointsLabel)
                .addGap(18, 18, 18)
                .addComponent(violationsLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groundSetSizeLabel)
                    .addComponent(extraPointsLabel)
                    .addComponent(violationsLabel))
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

        drawMenu.setText("Drawing");

        drawCriticalityMenuItem.setSelected(true);
        drawCriticalityMenuItem.setText("Draw Criticality");
        drawCriticalityMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawCriticalityMenuItemActionPerformed(evt);
            }
        });
        drawMenu.add(drawCriticalityMenuItem);

        menuBar.add(drawMenu);

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
        solveMenu.add(jSeparator1);

        greedyMenuItem.setText("GreedyASS");
        greedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greedyMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(greedyMenuItem);

        ilpOptMenuItem.setText("ILP Opt");
        ilpOptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilpOptMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(ilpOptMenuItem);
        solveMenu.add(jSeparator2);

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

        randMinimalMenuItem.setText("Random Minimal");
        randMinimalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randMinimalMenuItemActionPerformed(evt);
            }
        });
        solveMenu.add(randMinimalMenuItem);

        menuBar.add(solveMenu);

        lowerboundMenu.setText("Lower Bound");

        lplbMenuItem.setText("Linear Program");
        lplbMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lplbMenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(lplbMenuItem);
        lowerboundMenu.add(jSeparator3);

        signedPositiveGreedyMenuItem.setText("Signed Positive Greedy");
        signedPositiveGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedPositiveGreedyMenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(signedPositiveGreedyMenuItem);

        signedNegativeGreedyMenuItem.setText("Signed Negative Greedy");
        signedNegativeGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedNegativeGreedyMenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(signedNegativeGreedyMenuItem);

        signedUnionGreedyMenuItem.setText("Signed Union Greedy");
        signedUnionGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signedUnionGreedyMenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(signedUnionGreedyMenuItem);

        bestSignedGreedyMenuItem.setText("Best Signed Greedy");
        bestSignedGreedyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestSignedGreedyMenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(bestSignedGreedyMenuItem);

        wilber1MenuItem.setText("Wilber 1");
        wilber1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wilber1MenuItemActionPerformed(evt);
            }
        });
        lowerboundMenu.add(wilber1MenuItem);

        menuBar.add(lowerboundMenu);

        jMenu1.setText("Misc");

        rectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        rectMenuItem.setText("GreedyRect");
        rectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(rectMenuItem);

        LISS.setText("LISS");
        LISS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISSActionPerformed(evt);
            }
        });
        jMenu1.add(LISS);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        int opened = openFileChooser.showOpenDialog(this);

        if (opened == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = openFileChooser.getSelectedFile();
                drawPanel.setGrid(GridSetReader.importGrid(selectedFile.toPath()));
                saveFileChooser.setCurrentDirectory(selectedFile);
            } catch (IOException ioe) {
                // Nice error
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "An error occurred while loading the data:\n"
                        + ioe.getMessage(),
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        int saved = saveFileChooser.showSaveDialog(this);

        if (saved == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = saveFileChooser.getSelectedFile();

                // Add an extension if that wasn't done already and save the current grid
                if (!selectedFile.getName().contains("." + myExtension)) {
                    selectedFile = new File(selectedFile.getParent(), selectedFile.getName() + "." + myExtension);
                }

                GridSetWriter.exportGrid(drawPanel.getGrid(), selectedFile.toPath());

                openFileChooser.setCurrentDirectory(selectedFile);
            } catch (IOException ioe) {
                // Nice error
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "An error occurred while saving the data:\n"
                        + ioe.getMessage(),
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
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
        drawPanel.setGrid(GridSetGenerator.randomPermutation(drawPanel.getGrid().getWidth(), drawPanel.getGrid().getHeight()));
    }//GEN-LAST:event_randomPermutationMenuItemActionPerformed

    private void randomMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomMenuItemActionPerformed
        drawPanel.setGrid(GridSetGenerator.random(drawPanel.getGrid().getWidth(), drawPanel.getGrid().getHeight()));
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
        ProgressMonitor progressMonitor = new ProgressMonitor(MainFrame.this, "Trying all subsets.", "", 0, 100);
        progressMonitor.setProgress(0);
        progressMonitor.setMillisToDecideToPopup(100);
        progressMonitor.setMillisToPopup(400);

        StupidOpt stupid = new StupidOpt(drawPanel, drawPanel.getGrid());
        stupid.addPropertyChangeListener((PropertyChangeEvent e) -> {
            if ("progress".equals(e.getPropertyName())) {
                int progress = (Integer) e.getNewValue();

                progressMonitor.setProgress(progress);
                progressMonitor.setNote(String.format("Completed %d%%.\n", progress));

                if (progressMonitor.isCanceled()) {
                    stupid.cancel(false);
                }

                if (stupid.isDone() || stupid.isCancelled()) {
                    // Clean up
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        stupid.execute();
    }//GEN-LAST:event_stupidOptMenuItemActionPerformed

    private void ilpOptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilpOptMenuItemActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            drawPanel.setGrid(ILPSolver.solve(drawPanel.getGrid(), true));
        } catch (CmplException ex) {
            ex.printStackTrace();
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_ilpOptMenuItemActionPerformed

    private void signedPositiveGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedPositiveGreedyMenuItemActionPerformed
        drawPanel.setGrid(SignedGreedy.solve(SignedGreedy.Sign.Positive, drawPanel.getGrid()));
    }//GEN-LAST:event_signedPositiveGreedyMenuItemActionPerformed

    private void signedNegativeGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedNegativeGreedyMenuItemActionPerformed
        drawPanel.setGrid(SignedGreedy.solve(SignedGreedy.Sign.Negative, drawPanel.getGrid()));
    }//GEN-LAST:event_signedNegativeGreedyMenuItemActionPerformed

    private void signedUnionGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signedUnionGreedyMenuItemActionPerformed
        drawPanel.setGrid(SignedGreedy.solveSignedUnion(drawPanel.getGrid()));
    }//GEN-LAST:event_signedUnionGreedyMenuItemActionPerformed

    private void lplbMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lplbMenuItemActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            drawPanel.setGrid(LinearProgramLB.solve(drawPanel.getGrid()));
        } catch (CmplException ex) {
            ex.printStackTrace();
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lplbMenuItemActionPerformed

    private void bestSignedGreedyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestSignedGreedyMenuItemActionPerformed
        GridSet positive = SignedGreedy.solve(SignedGreedy.Sign.Positive, drawPanel.getGrid());
        GridSet negative = SignedGreedy.solve(SignedGreedy.Sign.Negative, drawPanel.getGrid());

        if (positive.getSize() > negative.getSize()) {
            drawPanel.setGrid(positive);
        } else {
            drawPanel.setGrid(negative);
        }
    }//GEN-LAST:event_bestSignedGreedyMenuItemActionPerformed

    private void randMinimalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randMinimalMenuItemActionPerformed
        drawPanel.setGrid(RandomMinimal.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_randMinimalMenuItemActionPerformed

    private void rectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectMenuItemActionPerformed
        drawPanel.setGrid(GreedyRectangle.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_rectMenuItemActionPerformed

    private void LISSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISSActionPerformed
        drawPanel.setGrid(IncreasingSS.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_LISSActionPerformed

    private void wilber1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wilber1MenuItemActionPerformed
        drawPanel.setGrid(Wilber1.solve(drawPanel.getGrid()));
    }//GEN-LAST:event_wilber1MenuItemActionPerformed

    private void drawCriticalityMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawCriticalityMenuItemActionPerformed
        drawPanel.setDrawCriticality(drawCriticalityMenuItem.isSelected());
    }//GEN-LAST:event_drawCriticalityMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LISS;
    private javax.swing.JMenuItem bestSignedGreedyMenuItem;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JMenuItem clearMenuItem;
    private javax.swing.JCheckBoxMenuItem drawCriticalityMenuItem;
    private javax.swing.JMenu drawMenu;
    private javax.swing.JLabel extraPointsLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fixGroundMenuItem;
    private javax.swing.JMenuItem greedyMenuItem;
    private javax.swing.JLabel groundSetSizeLabel;
    private javax.swing.JMenuItem ilpOptMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu lowerboundMenu;
    private javax.swing.JMenuItem lplbMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem optStaticTreeMenuItem;
    private javax.swing.JMenu pointSetMenu;
    private javax.swing.JMenuItem randMinimalMenuItem;
    private javax.swing.JMenuItem randomMenuItem;
    private javax.swing.JMenuItem randomPermutationMenuItem;
    private javax.swing.JMenuItem rectMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem signedNegativeGreedyMenuItem;
    private javax.swing.JMenuItem signedPositiveGreedyMenuItem;
    private javax.swing.JMenuItem signedUnionGreedyMenuItem;
    private javax.swing.JMenu solveMenu;
    private javax.swing.JMenuItem staticBalancedMenuItem;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem stupidOptMenuItem;
    private javax.swing.JLabel violationsLabel;
    private javax.swing.JMenuItem wilber1MenuItem;
    // End of variables declaration//GEN-END:variables

}
