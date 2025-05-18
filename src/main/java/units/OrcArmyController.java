package units;

import javax.swing.*;
import javax.swing.tree.*;

public class OrcArmyController {
    private JTree orcTree;
    private DefaultTreeModel treeModel;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> tribeComboBox;
    private JButton createButton;
    
    // Info display components
    private JTextPane namePane, typePane, tribePane, weaponPane, armorPane, bannerPane;
    private JProgressBar intelligenceBar, healthBar, strengthBar, agilityBar;
    
    private OrcDirector orcDirector = new OrcDirector();
    
    public OrcArmyController(JTree orcTree, JComboBox<String> typeComboBox, 
                           JComboBox<String> tribeComboBox, JButton createButton,
                           JTextPane namePane, JTextPane typePane, JTextPane tribePane,
                           JTextPane weaponPane, JTextPane armorPane, JTextPane bannerPane,
                           JProgressBar intelligenceBar, JProgressBar healthBar,
                           JProgressBar strengthBar, JProgressBar agilityBar) {
        
        this.orcTree = orcTree;
        this.treeModel = (DefaultTreeModel) orcTree.getModel();
        this.typeComboBox = typeComboBox;
        this.tribeComboBox = tribeComboBox;
        this.createButton = createButton;
        
        // Info display components
        this.namePane = namePane;
        this.typePane = typePane;
        this.tribePane = tribePane;
        this.weaponPane = weaponPane;
        this.armorPane = armorPane;
        this.bannerPane = bannerPane;
        this.intelligenceBar = intelligenceBar;
        this.healthBar = healthBar;
        this.strengthBar = strengthBar;
        this.agilityBar = agilityBar;
        
        setupListeners();
    }
    
    private void setupListeners() {
        createButton.addActionListener(e -> createNewOrc());
        
        orcTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) 
                orcTree.getLastSelectedPathComponent();
            
            if (selectedNode != null && selectedNode.getUserObject() instanceof Orc) {
                displayOrcInfo((Orc) selectedNode.getUserObject());
            }
        });
    }
    
    private void createNewOrc() {
        String orcType = (String) typeComboBox.getSelectedItem();
        String orcTribe = (String) tribeComboBox.getSelectedItem();
        
        Orc newOrc = orcDirector.createBasicOrk(orcTribe, orcType);
        if (newOrc != null) {
            System.out.println("newOrc: " + newOrc.getHealth());
            addOrcToTree(newOrc);
        }
    }
    
    private void addOrcToTree(Orc orc) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
        DefaultMutableTreeNode tribeNode = null;

        System.out.println("Looking for tribe: " + orc.getTribe()); // Debug print

        // Find the tribe node
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
            System.out.println("Checking node: " + node.toString()); // Debug print

            if (node.toString().equals(orc.getTribe())) {
                tribeNode = node;
                System.out.println("Found matching tribe node!"); // Debug print
                break;
            }
        }

        if (tribeNode != null) {
            DefaultMutableTreeNode orcNode = new DefaultMutableTreeNode(orc);
            treeModel.insertNodeInto(orcNode, tribeNode, tribeNode.getChildCount());

            // Expand the tree to show the new orc
            orcTree.expandPath(new TreePath(tribeNode.getPath()));
            System.out.println("Added orc to tree!"); // Debug print

            // Force tree update
            treeModel.reload(tribeNode);
        } else {
            System.out.println("No matching tribe node found!"); // Debug print
        }
    }
    
    private void displayOrcInfo(Orc orc) {
        namePane.setText(orc.getName());
        typePane.setText(orc.getorcClass());
        tribePane.setText(orc.getTribe());
        weaponPane.setText(orc.getWeapon());
        armorPane.setText(orc.getArmor());
        bannerPane.setText(orc.getBanner());
        
        intelligenceBar.setValue((int) (orc.getIntelligence()));
        healthBar.setValue((int) (orc.getHealth()));
        strengthBar.setValue((int) (orc.getStrength()));
        agilityBar.setValue((int) (orc.getAgility()));
    }
}