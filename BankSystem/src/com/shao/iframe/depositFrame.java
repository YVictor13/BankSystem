package com.shao.iframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.shao.Service.impl.AccountServiceImpl;
import com.shao.model.user;

public class depositFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private user user_query;
	private user user_modMoney;



	/**
	 * Create the frame.
	 */
	public depositFrame(final String name) {
		AccountServiceImpl asi =new AccountServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 354);
		setTitle(name);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 92, 121, 27);
		contentPane.add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setBounds(225, 95, 133, 24);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JButton OKButton = new JButton("\u786E\u8BA4");
		OKButton.setFont(new Font("新宋体", Font.BOLD, 15));
		OKButton.setBounds(102, 188, 113, 27);
		contentPane.add(OKButton);
		OKButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Float.parseFloat(inputField.getText())<100000){
					user_query = asi.query(name);
					double temp = user_query.getbalance()+Double.parseDouble(inputField.getText());
					DecimalFormat df = new DecimalFormat( "0.00 "); 
					asi.update(user_query.getName(), temp);
						setVisible(false);
						atmFrame frame = new atmFrame(name);
						frame.setVisible(true);
						user_query = asi.query(name);
						JOptionPane.showMessageDialog(null, "交易成功！"+"\n" + "当前余额为：" + user_query.getbalance());							
				}else{
					JOptionPane.showMessageDialog(null, "输入金额大于1000000，请重新输入！");
					inputField.setText("");
				}				
			}
			
		});
		
		JButton backButton_1 = new JButton("\u8FD4\u56DE");
		backButton_1.setFont(new Font("新宋体", Font.BOLD, 15));
		backButton_1.setBounds(268, 188, 113, 27);
		contentPane.add(backButton_1);
		backButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				atmFrame af = new atmFrame(name);
				setVisible(false);
				af.setVisible(true);			
			}		
		});
		
		JLabel lblNewLabel_1 = new JLabel("*\u9650\u989D100000");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(369, 98, 105, 18);
		contentPane.add(lblNewLabel_1);
	}
}
