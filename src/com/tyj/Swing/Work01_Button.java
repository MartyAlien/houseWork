package com.tyj.Swing;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Work01_Button {
	static boolean isClicked=false;
	public static void main(String[] args) {
		// 创建顶层窗口
		JFrame frame=new JFrame("测试窗口");
		frame.setLocationRelativeTo(null);
		frame.setSize(300,260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 创建按钮
		JPanel jPanel=new JPanel();
		JButton button=new JButton();
		button.setSize(60,32);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		// 设置按钮默认的图片
		button.setIcon(new ImageIcon("display.png"));
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!isClicked) {
					button.setIcon(new ImageIcon("play.png"));
					isClicked=true;
				}else {
					button.setIcon(new ImageIcon("display.png"));
					isClicked=false;
				}
			}
			
		});
		jPanel.add(button);
		frame.add(jPanel,BorderLayout.PAGE_END);
		// 设置顶层窗口可见
		frame.setVisible(true);
	}
}
