package jadx.gui.ui;

import javax.swing.JPanel;

import jadx.gui.treemodel.JNode;

abstract class ContentPanel extends JPanel {

    protected final TabbedPane tabbedPane;
    protected final JNode node;

    ContentPanel(TabbedPane panel, JNode jnode) {
        tabbedPane = panel;
        node = jnode;
    }

    public abstract void loadSettings();

    TabbedPane getTabbedPane() {
        return tabbedPane;
    }

    JNode getNode() {
        return node;
    }
}
