package tyj.exp.day01;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Listener extends MouseAdapter{
	private JTextField field;
	private JPasswordField passwordField;
	private JCheckBox checkBox[];
	private JTextArea textArea;
	private JRadioButton radioButton01,radioButton02;


	public Listener(JTextField field, JPasswordField passwordField, JCheckBox[] checkBox, JTextArea textArea,
			JRadioButton radioButton01, JRadioButton radioButton02) {
		super();
		this.field = field;
		this.passwordField = passwordField;
		this.checkBox = checkBox;
		this.textArea = textArea;
		this.radioButton01 = radioButton01;
		this.radioButton02 = radioButton02;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(getMessage());
	}


	private String getMessage() {
		String userName = field.getText();
		String userPWD = new String(passwordField.getPassword());
		String sex=null;
		if(radioButton01.isSelected()) {
			sex=radioButton01.getText();
		}
		if(radioButton02.isSelected()) {
			sex=radioButton02.getText();
		}
		StringBuffer hobbies=new StringBuffer("");
		for (JCheckBox jCheckBox : checkBox) {
			if(jCheckBox.isSelected()) {
				hobbies.append(jCheckBox.getText()+" ");
			}
		}
		String selfInfo = textArea.getText();
		String message="账号: "+userName+"\n密码: "+userPWD+"\n性别: "+sex+"\n爱好: "+hobbies+"\n简介: \n"+selfInfo;
		return message;
	}

	
}
