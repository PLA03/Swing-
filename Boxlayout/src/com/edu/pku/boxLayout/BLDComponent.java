package com.edu.pku.boxLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowStateListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BLDComponent extends JComponent implements MouseListener {

	private Dimension preferedSize;
	private float hub;
	private int shortSideSize;
	private boolean printSize;
	private boolean restrictMaximumSize;
	private float xAlignment;
	private Color color;

	public BLDComponent(float hub, int shortSideSize, boolean printSize, boolean restrictMaximumSize,
			float xAlignment) {
		super();
		this.hub = hub;
		this.shortSideSize = shortSideSize;
		this.printSize = printSize;
		this.restrictMaximumSize = restrictMaximumSize;
		this.xAlignment = xAlignment;

		setAlignmentX(xAlignment);
		color = Color.getHSBColor(hub, 0.4f, 0.85f);
		preferedSize = new Dimension(shortSideSize * 2, shortSideSize);
		// setPreferredSize(preferedSize);
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		float xAlignment = getAlignmentX();
		// draw the rectangle
		g.setColor(color);
		g.fill3DRect(0, 0, width, height, true);

		// draw the white line
		g.setColor(Color.white);
		int x = (int) (xAlignment * (float) width);
		g.drawLine(x, 0, x, height - 1);

		g.setColor(Color.black);
		g.drawString(xAlignment + "", 0, height - 3);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int width = getWidth();
		float xAlignment = (float) x / (float) width;
		// round to the nearest 1/10th
		int tmp = Math.round(xAlignment * 10.0f);
		xAlignment = (float) tmp / 10.0f;
		setAlignmentX(xAlignment);
		revalidate(); // the GUI needs ReLayout..
		repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	public static void createAndShowGUI() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("BoxLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BLDComponent bldComponent = new BLDComponent(0.0f, 30, true, true, 0.2f);
		frame.add(bldComponent);
		frame.pack();
		frame.setVisible(true);
	}

	public Dimension getPreferredSize() {
		return preferedSize;
	}

	public Dimension getMinimumSize() {
		return preferedSize;
	}

	public Dimension getMaximumSize() {
		if (restrictMaximumSize) {
			return preferedSize;
		} else {
			return super.getMaximumSize();
		}
	}

	/**
	 * Our bldComponent is completely opaque.
	 */
	@Override
	public boolean isOpaque() {
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setSizeRestriction(boolean restrictSize) {
		restrictMaximumSize = restrictSize;
	}
}