package com.shao.iframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.shao.Service.impl.AccountServiceImpl;
import com.shao.model.user;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField u_name_Field;
	private JPasswordField u_password_field;

	//登录事件监听器
	class loginAction implements ActionListener {
		AccountServiceImpl asi =new AccountServiceImpl();
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			user user = new user();
			user = asi.check(u_name_Field.getText(),u_password_field.getText());  //登录验证
			if (user.getName() != null) {
				if (user.getPassword().equals(u_password_field.getText())) {
					try {
						atmFrame frame = new atmFrame(user.getName());
						frame.setTitle(user.getName());
						frame.setVisible(true);
						setVisible(false);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "密码不正确！请重新输入");
					u_name_Field.setText("");
					u_password_field.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "找不到该用户，请先注册！");
				u_name_Field.setText("");
				u_password_field.setText("");
			}
		}
	}
	
	
	//注册事件监听器
	class signAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SignFrame frame = new SignFrame();
			frame.setVisible(true);
			setVisible(false);
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u7F51\u4E0A\u94F6\u884C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 385);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.setFont(new Font("新宋体", Font.BOLD, 20));
		LoginButton.setBounds(92, 214, 120, 37);
		contentPane.add(LoginButton);
		LoginButton.addActionListener(new loginAction());
		
		JButton signButton = new JButton("\u6CE8\u518C");
		signButton.setFont(new Font("新宋体", Font.BOLD, 20));
		signButton.setBounds(283, 214, 113, 37);
		contentPane.add(signButton);
		signButton.addActionListener(new signAction());
		
		JLabel u_nameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		u_nameLabel.setFont(new Font("新宋体", Font.BOLD, 18));
		u_nameLabel.setBounds(92, 49, 88, 37);
		contentPane.add(u_nameLabel);
		
		JLabel u_passwordLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		u_passwordLabel_1.setFont(new Font("新宋体", Font.BOLD, 18));
		u_passwordLabel_1.setBounds(92, 130, 88, 27);
		contentPane.add(u_passwordLabel_1);
		
		u_name_Field = new JTextField();
		u_name_Field.setBounds(184, 57, 157, 29);
		contentPane.add(u_name_Field);
		u_name_Field.setColumns(10);
		
		u_password_field = new JPasswordField();
		u_password_field.setBounds(184, 133, 157, 27);
		contentPane.add(u_password_field);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6307\u5357");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(402, 307, 72, 31);
		contentPane.add(lblNewLabel);
	}
}


