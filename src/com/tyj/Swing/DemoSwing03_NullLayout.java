package com.tyj.Swing;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoSwing03_NullLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("绝度布局");
		frame.setLayout(null);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPanel=new JPanel(null);
		JButton button01=new JButton("01");
		JButton button02=new JButton("02");
		JButton button03=new JButton("03");
		button01.setBounds(175, 150, 50, 50);
		button02.setBounds(175, 225, 50, 50);
		jPanel.add(button01);
		jPanel.add(button02);
		jPanel.add(button03);
		frame.setContentPane(jPanel);
		frame.setVisible(true);
		button03.setBounds(jPanel.getWidth()-50, jPanel.getHeight()-50, 50, 50);
		
		button01.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				button03.setVisible(false);
			}
			
		});
		button02.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				button03.setVisible(true);
			}
			
		});
	}
}
