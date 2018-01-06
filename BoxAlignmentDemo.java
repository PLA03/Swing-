package com.edu.pku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BoxAlignmentDemo extends JPanel {

	public BoxAlignmentDemo() {
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel buttonRow = new JPanel();
		// use default flowLayout
		buttonRow.add(createButtonRow(false));
		buttonRow.add(createButtonRow(true));

		JPanel labelAndComponet = new JPanel();
		// use default flowLayout
		labelAndComponet.add(createLabelAndComponent(false));
		labelAndComponet.add(createLabelAndComponent(true));

		JPanel yAlignmentDemo = new JPanel();
		// use default flowLayout
		yAlignmentDemo.add(createYAlignmentExample(false));
		yAlignmentDemo.add(createYAlignmentExample(true));

		tabbedPane.addTab("Alterting alignments", buttonRow);
		tabbedPane.addTab("X Alignment mismatch", labelAndComponet);
		tabbedPane.addTab("Y Alignment mismatch", yAlignmentDemo);
		add(tabbedPane, BorderLayout.CENTER);
	}

	public static JPanel createButtonRow(boolean changeAlignment) {
		JButton button1 = new JButton("A JButton", createImageIcon("images/middle.gif"));
		button1.setVerticalTextPosition(AbstractButton.BOTTOM);
		button1.setHorizontalAlignment(AbstractButton.CENTER);

		JButton button2 = new JButton("Another JButton", createImageIcon("images/geek-cght.gif"));
		button1.setVerticalTextPosition(AbstractButton.BOTTOM);
		button1.setHorizontalAlignment(AbstractButton.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		String title;
		if (changeAlignment) {
			title = "desired";
			button1.setAlignmentY(BOTTOM_ALIGNMENT);
			button2.setAlignmentY(BOTTOM_ALIGNMENT);
		} else {
			title = "Default";
		}
		panel.setBorder(BorderFactory.createTitledBorder(title));
		panel.add(button1);
		panel.add(button2);
		return panel;
	}

	public static JPanel createLabelAndComponent(boolean doItRight) {
		JPanel pane = new JPanel();
		JComponent component = new JPanel();
		Dimension size = new Dimension(150, 100);
		component.setMaximumSize(size);
		component.setPreferredSize(size);
		component.setMinimumSize(size);
		TitledBorder border = new TitledBorder(new LineBorder(Color.black), "A JPanel", TitledBorder.CENTER,
				TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component.setBorder(border);

		JLabel label = new JLabel("This is a JLabel");
		String title;
		if (doItRight) {
			title = "Matched";
			label.setAlignmentX(CENTER_ALIGNMENT);
		} else {
			title = "Mismatched";
		}

		pane.setBorder(BorderFactory.createTitledBorder(title));
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(label);
		pane.add(component);
		return pane;
	}

	public static JPanel createYAlignmentExample(boolean doItRight) {
		JPanel pane = new JPanel();
		String title;

		JComponent component1 = new JPanel();
		Dimension size = new Dimension(100, 50);
		component1.setMaximumSize(size);
		component1.setPreferredSize(size);
		component1.setMinimumSize(size);
		TitledBorder border = new TitledBorder(new LineBorder(Color.black), "A JPanel", TitledBorder.CENTER,
				TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component1.setBorder(border);

		JComponent component2 = new JPanel();
		size = new Dimension(100, 50);
		component2.setMaximumSize(size);
		component2.setPreferredSize(size);
		component2.setMinimumSize(size);
		border = new TitledBorder(new LineBorder(Color.black), "A JPanel", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.black);
		component2.setBorder(border);

		if (doItRight) {
			title = "Matched";
		} else {
			component1.setAlignmentY(TOP_ALIGNMENT);
			title = "Mismatched";
		}

		pane.setBorder(BorderFactory.createTitledBorder(title));
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		pane.add(component1);
		pane.add(component2);
		return pane;
	}

	public static ImageIcon createImageIcon(String url) {
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	public static void createAndShowGui() {
		JFrame frame = new JFrame("BoxAlignmentDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoxAlignmentDemo boxAlignmentDemo = new BoxAlignmentDemo();
		frame.add(boxAlignmentDemo);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * For thread safety
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGui();
		});
	}
}
