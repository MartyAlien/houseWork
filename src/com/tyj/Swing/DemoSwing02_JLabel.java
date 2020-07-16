package com.tyj.Swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DemoSwing02_JLabel {
	public static void main(String[] args) {
		// �������㴰��
		JFrame frame=new JFrame("测试");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jPanel=new JPanel();
		JLabel jLabel=new JLabel("测试按钮");
		jLabel.setFont(new Font(null,Font.BOLD,20));
		jLabel.setForeground(Color.white);
		jLabel.setIcon(new ImageIcon("01.png"));
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		jPanel.add(jLabel);
		frame.add(jPanel);
		// ���ö��㴰�ڿɼ�
		frame.pack();
		frame.setVisible(true);
	}
}
