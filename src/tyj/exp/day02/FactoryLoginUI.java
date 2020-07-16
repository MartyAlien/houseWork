package tyj.exp.day02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FactoryLoginUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = -1804462002L;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JComboBox<String> box;
	private JButton logButton,minButton,closeButton;
	private JPanel headPanel ;
	private JPanel centerPanel;
	private JPanel floorJPanel;
	private JButton registButton;
	int mouseAtX = 0;
	int mouseAtY = 0;

	public FactoryLoginUI() throws HeadlessException {
		setUndecorated(true);
		setSize(600,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(190,230,240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(this.bgHead(),BorderLayout.PAGE_START);
		add(this.floorBtn(),BorderLayout.PAGE_END);
		add(this.cenPanel(),BorderLayout.CENTER);
	    setAlwaysOnTop(true);
	    // 注册可拖拽监听
	    this.canDraged(headPanel);
		setVisible(true); 
	}
	// 窗体可拖拽
	private void canDraged(JPanel p) {
		MouseAdapter frameDrageAdapter=new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
                mouseAtX = e.getPoint().x;
                mouseAtY = e.getPoint().y;
            }
		};
		MouseMotionAdapter motionAdapter=new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
	              setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//设置拖拽后，窗口的位置
	          }
		};
		p.addMouseListener(frameDrageAdapter);
		p.addMouseMotionListener(motionAdapter);
	}
	private JPanel bgHead() {
		headPanel =new JPanel(null);
		headPanel.setPreferredSize(new Dimension(600, 315));
		
		minButton = new JButton();
		closeButton = new JButton();
		// 设置按钮格式
		minButton.setBounds(488, 0, 54, 50);
		closeButton.setBounds(542, 0, 58, 50);
		minButton.setFocusPainted(false);
		closeButton.setFocusPainted(false);
		minButton.setBorderPainted(false);
		closeButton.setBorderPainted(false);
		minButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minButton.setIcon(new ImageIcon("FacLogImgs/min.png"));
		minButton.setRolloverIcon(new ImageIcon("FacLogImgs/min2.png"));
		closeButton.setIcon(new ImageIcon("FacLogImgs/close.png"));
		closeButton.setRolloverIcon(new ImageIcon("FacLogImgs/close2.png"));
		closeButton.setPressedIcon(new ImageIcon("FacLogImgs/close3.png"));
		//设置背景
		JLabel bgImgJLabel=new JLabel(new ImageIcon("FacLogImgs/bg.gif"), JLabel.CENTER);
		bgImgJLabel.setBounds(0, 0, 600, 315);
		headPanel.add(minButton);
		headPanel.add(closeButton);
		headPanel.add(bgImgJLabel);
		// 注册监听
		minButton.addActionListener(this);
		closeButton.addActionListener(this);
		return headPanel;
	}
	
	private JPanel cenPanel() {
		centerPanel=new JPanel(null);
		centerPanel.setPreferredSize(new Dimension(600,0));
		centerPanel.setBackground(new Color(190,230,240));
		Font font=new Font("微软雅黑",Font.BOLD,24);
		// 账号+输入框
		JLabel jLabel=new JLabel("账  号");
		userNameField=new JTextField();
		jLabel.setBounds(170, 0, 65, 60);
		userNameField.setBounds(238, 10, 220, 40);
		jLabel.setFont(font);
		userNameField.setFont(font);
		centerPanel.add(jLabel);
		centerPanel.add(userNameField);
		
		// 密码+密码框
		JLabel jLabel2=new JLabel("密  码");
		passwordField=new JPasswordField();
		jLabel2.setBounds(170,70,65,60);
		passwordField.setBounds(238, 80, 220, 40);
		jLabel2.setFont(font);
		passwordField.setFont(font);
		centerPanel.add(jLabel2);
		centerPanel.add(passwordField);
		
		// 登录模式
		JLabel jLabel3=new JLabel("登录模式");
		box=new JComboBox<String>();
		box.addItem("普通用户");
		box.addItem("后台用户");
		jLabel3.setBounds(170, 140, 154, 60);
		box.setBounds(300, 150, 124, 40);
		jLabel3.setFont(font);
		box.setFont(new Font("幼圆",Font.PLAIN,17));
		centerPanel.add(jLabel3);
		centerPanel.add(box);
		return centerPanel;
	}
	
	private JPanel floorBtn() {
		floorJPanel=new JPanel(null);
		floorJPanel.setPreferredSize(new Dimension(600,75));
		floorJPanel.setBackground(new Color(190,230,240));
		logButton=new JButton();
		// 设置按钮格式
		logButton.setBounds(216, 3, 168, 68);
		logButton.setToolTipText("登录");
		logButton.setFocusPainted(false);
		logButton.setBorderPainted(false);
		logButton.setBackground(null);
		logButton.setIcon(new ImageIcon("FacLogImgs/oldBtn.png"));
		logButton.setPressedIcon(new ImageIcon("FacLogImgs/pressedBtn.png"));
		logButton.setRolloverIcon(new ImageIcon("FacLogImgs/rolloverBtn.png"));
		floorJPanel.add(logButton);
		
		registButton=new JButton();
		registButton.setToolTipText("注册账户");
		registButton.setFocusPainted(false);
		registButton.setBorderPainted(false);
		registButton.setBackground(null);
		registButton.setIcon(new ImageIcon("FacLogImgs/oldRegist.png"));
		registButton.setRolloverIcon(new ImageIcon("FacLogImgs/rolloverRegist.png"));
		registButton.setPressedIcon(new ImageIcon("FacLogImgs/pressedRegist.png"));
		registButton.setBounds(540, 20, 50, 50);
		registButton.addActionListener(this);
		floorJPanel.add(registButton);
		
		return floorJPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==closeButton) {
			this.dispose();
		}
		if(e.getSource()==minButton) {
			 this.setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==registButton) {
			System.out.println("你点击了注册按钮");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new FactoryLoginUI());
	}
}
