package com.tyj.Swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Demo01Swing {
	public static void main(String[] args) {
		JFrame frame=new JFrame("测试");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPanel=new JPanel();
		JButton button=new JButton("测试按钮");
		
		jPanel.add(button);
		frame.setContentPane(jPanel);
		
		JPanel jPanel2=new JPanel();
		JLabel jLabel=new JLabel("我是图片上的文字");
		jLabel.setFont(new Font(null,Font.BOLD,20));
		jLabel.setForeground(Color.white);
		jLabel.setIcon(new ImageIcon("01.png"));
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		jPanel2.add(jLabel);
		frame.add(jPanel2);
		frame.pack();
		frame.getContentPane().setBackground(new Color(95, 175, 190));
		frame.setVisible(true);
	}
}
