package com.shao.iframe;

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

public class SignFrame extends JFrame {

	private JPanel contentPane;
	private JTextField u_name;
	private JPasswordField u_password;
	private JPasswordField u_password_1;
	private user user;



	
	//注册按钮监听器
	class OKButtonAction implements ActionListener {
		
		AccountServiceImpl asi =new AccountServiceImpl();

		public void actionPerformed(ActionEvent e) {
			  user = asi.query(u_name.getText());
			// TODO Auto-generated method stub
			if (!u_name.getText().equals("")) {
				if (!u_password.getText().equals("")) {
					if (!u_password_1.getText().equals("")) {
						if (u_password.getText().equals(u_password_1.getText())) {                              
							if (user==null) {   //  !u_name.getText().trim().equals(user.getName())                             //  !u_name.getText().equals(user.getName())
								asi.addUser(u_name.getText(),u_password.getText());
								setVisible(false);
								LoginFrame frame = new LoginFrame();
								frame.setVisible(true);
								JOptionPane.showMessageDialog(null, "注册成功,可以继续登录！");
							} else {
								JOptionPane.showMessageDialog(null, "用户名已经存在！");
							}
						} else {
							JOptionPane.showMessageDialog(null, "密码确认不符！");
						}

					} else {
						JOptionPane.showMessageDialog(null, "未输入确认密码！");
					}

				} else {
					JOptionPane.showMessageDialog(null, "未输入密码！");
				}
			} else {
				JOptionPane.showMessageDialog(null, "未输入用户名！");
			}
		}

	}

	/**
	 * Create the frame.
	 */
	public SignFrame() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(74, 78, 102, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 18));
		lblNewLabel_1.setBounds(88, 149, 88, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 18));
		lblNewLabel_2.setBounds(69, 211, 101, 28);
		contentPane.add(lblNewLabel_2);
		
		u_name = new JTextField();
		u_name.setBounds(187, 85, 123, 24);
		contentPane.add(u_name);
		u_name.setColumns(10);
		
		u_password = new JPasswordField();
		u_password.setBounds(187, 153, 123, 24);
		contentPane.add(u_password);
		
		u_password_1 = new JPasswordField();
		u_password_1.setBounds(187, 215, 123, 24);
		contentPane.add(u_password_1);
		
		JButton OKButton = new JButton("\u786E\u5B9A");
		OKButton.setFont(new Font("新宋体", Font.BOLD, 20));
		OKButton.setBounds(171, 277, 113, 27);
		contentPane.add(OKButton);
		OKButton.addActionListener(new OKButtonAction());
	}
}
