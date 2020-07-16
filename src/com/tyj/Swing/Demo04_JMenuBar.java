package com.tyj.Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/*
 * 下拉菜单栏
 * 弹出式菜单：通过鼠标右键点击，弹出菜单
 */
public class Demo04_JMenuBar extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1804462006L;
	private JFrame jframe;
	static private JMenuItem[] itmes_F = { new JMenuItem("新建"),
			new JMenuItem("打开"), new JMenuItem("保存"), new JMenuItem("另存为"),
			new JMenuItem("退出") };
	static private JMenuItem[] itmes_E = { new JMenuItem("撤销"),
			new JMenuItem("全选"), new JMenuItem("复制"), new JMenuItem("剪切") };
	static private JMenuItem[] itmes_O = { new JMenuItem("换行"),
			new JMenuItem("字体") };
	static private JMenuItem[] itmes_V = { new JCheckBoxMenuItem("状态栏(S)") };
	static private JMenuItem[] itmes_H = { new JMenuItem("查看帮助(H)"),
			new JMenuItem("发送反馈(F)"), new JMenuItem("关于我们(A)") };
	private JMenuBar bar;
	private JMenu[] jMenus = { new JMenu("文件(F)"), new JMenu("编辑(E)"),
			new JMenu("格式(O)"), new JMenu("查看(V)"), new JMenu("帮助(H)") };
	private JPanel stateJpanel;
	private JLabel jLabel01;
	private JTextArea jTextArea;
	private JScrollPane jScrollPane;

	// 构造方法
	public Demo04_JMenuBar() {
		this.jframe = new JFrame("模仿记事本");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jframe.setSize((int) (screenSize.getWidth()) / 2,
				(int) (screenSize.getHeight()) / 2);
		jframe.setLocation(
				(int) (screenSize.getWidth() - jframe.getWidth()) / 2,
				(int) (screenSize.getHeight() - jframe.getHeight()) / 2);
		jframe.setLayout(new BorderLayout());
		jframe.setResizable(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initJMenuBar();
		this.initJPopupMenu();
		this.doListener();
		this.initJTextArea();
		this.stateBar();
		jframe.setVisible(true);
	}

	// 初始化菜单栏
	private void initJMenuBar() {
		// 创建菜单栏
		this.bar = new JMenuBar();
		this.bar.setBackground(Color.WHITE);
		this.bar.setBorderPainted(false);
		// 将菜单项加入菜单
		for (JMenuItem jMenuItem : itmes_F) {
			jMenuItem.setBackground(Color.white);
			if (jMenuItem.getText().equals("保存")
					|| jMenuItem.getText().equals("退出")) {
				jMenus[0].addSeparator();
			}
			jMenus[0].add(jMenuItem);
		}
		for (JMenuItem jMenuItem : itmes_E) {
			jMenuItem.setBackground(Color.white);
			if (jMenuItem.getText().equals("复制")) {
				jMenus[1].addSeparator();
			}
			jMenus[1].add(jMenuItem);
		}
		for (JMenuItem jMenuItem : itmes_O) {
			jMenuItem.setBackground(Color.white);
			jMenus[2].add(jMenuItem);
		}
		for (JMenuItem jMenuItem : itmes_V) {
			jMenuItem.setBackground(Color.white);
			jMenus[3].add(jMenuItem);
		}
		for (JMenuItem jMenuItem : itmes_H) {
			jMenuItem.setBackground(Color.white);
			if (jMenuItem.getText().equals("关于我们(A)")) {
				jMenus[4].addSeparator();
			}
			jMenus[4].add(jMenuItem);
		}
		// 将菜单加入到菜单栏
		for (JMenu jMenu : jMenus) {
			this.bar.add(jMenu);
		}
		// 将菜单栏加入到窗口顶部
		this.jframe.setJMenuBar(this.bar);
		this.setKeys();
	}

	private void doListener() {
		for (int i = 0; i < itmes_F.length; i++) {
			itmes_F[i].addActionListener(this);
		}
		for (int i = 0; i < itmes_E.length; i++) {
			itmes_E[i].addActionListener(this);
		}
		for (int i = 0; i < itmes_O.length; i++) {
			itmes_O[i].addActionListener(this);
		}
		for (int i = 0; i < itmes_V.length; i++) {
			itmes_V[i].addActionListener(this);
		}
		for (int i = 0; i < itmes_H.length; i++) {
			itmes_H[i].addActionListener(this);
		}
	}

	private void setKeys() {
		// 菜单的快捷热键
		jMenus[0].setMnemonic(KeyEvent.VK_F);
		jMenus[1].setMnemonic(KeyEvent.VK_E);
		jMenus[2].setMnemonic(KeyEvent.VK_O);
		jMenus[3].setMnemonic(KeyEvent.VK_V);
		jMenus[4].setMnemonic(KeyEvent.VK_H);
		// 菜单项的快捷组合键
		itmes_F[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		itmes_F[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		itmes_F[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		itmes_F[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.SHIFT_MASK | ActionEvent.ALT_MASK, true));
		itmes_F[4].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.SHIFT_MASK | ActionEvent.ALT_MASK, true));

		itmes_E[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		itmes_E[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		itmes_E[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		itmes_E[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));

		itmes_V[0].setMnemonic(KeyEvent.VK_S);
		;

		itmes_H[0].setMnemonic(KeyEvent.VK_H);
		;
		itmes_H[1].setMnemonic(KeyEvent.VK_F);
		;
		itmes_H[1].setMnemonic(KeyEvent.VK_A);
		;
	}

	private void tempDialog() {
		JOptionPane.showMessageDialog(jframe, "功能待开发");
	}

	private void stateBar() {
		stateJpanel = new JPanel();
		stateJpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		stateJpanel.setPreferredSize(new Dimension(jframe.getWidth(), 35));
		this.jLabel01 = new JLabel("第1行,第1列");
		JLabel jLabel02 = new JLabel("100%");
		JLabel jLabel03 = new JLabel("Windows(CRLF)");
		JLabel jLabel04 = new JLabel("UTF-8");
		jLabel01.setPreferredSize(new Dimension(120, 30));
		jLabel02.setPreferredSize(new Dimension(60, 30));
		jLabel03.setPreferredSize(new Dimension(140, 30));
		jLabel04.setPreferredSize(new Dimension(80, 30));
		jLabel01.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jLabel02.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jLabel03.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jLabel04.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		stateJpanel.add(jLabel01);
		stateJpanel.add(jLabel02);
		stateJpanel.add(jLabel03);
		stateJpanel.add(jLabel04);
		stateJpanel.setVisible(false); // 状态栏默认设置不可见
		jframe.add(stateJpanel, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itmes_F[itmes_F.length - 1]) {
			System.exit(0);
		} else if (e.getSource() == itmes_V[0]) {
			if (itmes_V[0].isSelected())
				stateJpanel.setVisible(true);
			else
				stateJpanel.setVisible(false);
		} else {
			tempDialog();
		}
	}

	private void initJPopupMenu() {
		// 创建弹出式菜单对象
		JPopupMenu jPopupMenu = new JPopupMenu();

		// 创建菜单项
		String[] s = new String[] { "查看", "选项", "放大", "刷新", "退出系统" };
		JMenuItem[] items = new JMenuItem[s.length];
		for (int i = 0; i < s.length; i++) {
			items[i] = new JMenuItem(s[i]);
		}

		// 将菜单项加入到菜单中
		for (JMenuItem jMenuItem : items) {
			jPopupMenu.add(jMenuItem);
			jPopupMenu.addSeparator();
		}

		// 为jFrame窗体添加鼠标事件：右击弹出菜单
		this.jframe.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 检测鼠标右键点击
				if (e.getButton() == MouseEvent.BUTTON3) {
					jPopupMenu.show(e.getComponent(), e.getX() + 20, e.getY());
				}
			}

		});
		items[items.length - 1].addActionListener(e -> System.exit(0));
	}

	private void initJTextArea() {
		this.jTextArea = new JTextArea();
		jTextArea.setTabSize(2);
		jTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		this.jScrollPane = new JScrollPane();
		jScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.jScrollPane.setViewportView(this.jTextArea);
		// 简体文本域中光标的位置
		jTextArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				try {
					// e.getDot() 获得插入符的位置。
					int offset = e.getDot();

					// getLineOfOffset(int offset) 将组件文本中的偏移量转换为行号
					int row = jTextArea.getLineOfOffset(offset);

					// getLineStartOffset(int line) 取得给定行起始处的偏移量。
					// getLineEndOffset(int line) 取得给定行结尾处的偏移量。
					int column = e.getDot() - jTextArea.getLineStartOffset(row);

					// 在状态栏中显示当前光标所在行号、所在列号
					// 实时更改状态栏信息
					jLabel01.setText("第" + (row + 1) + "行,第" + (column + 1)+ "列");
					jLabel01.setPreferredSize(new Dimension(jLabel01.getText().length()*8+60,jLabel01.getHeight()));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		this.jframe.add(jScrollPane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Demo04_JMenuBar());
	}
}
