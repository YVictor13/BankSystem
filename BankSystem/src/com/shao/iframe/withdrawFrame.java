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

public class withdrawFrame extends JFrame {

	private JPanel contentPane;
	private JTextField outputField;
	private com.shao.model.user user_query;
	private com.shao.model.user user_modMoney;


	/**
	 * Create the frame.
	 */
	public withdrawFrame(final String name) {
		AccountServiceImpl asi =new AccountServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle(name);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabe = new JLabel("\u53D6\u6B3E\u91D1\u989D\uFF1A");
		lblNewLabe.setFont(new Font("新宋体", Font.BOLD, 20));
		lblNewLabe.setBounds(84, 75, 117, 38);
		contentPane.add(lblNewLabe);
		
		outputField = new JTextField();
		outputField.setBounds(199, 84, 117, 24);
		contentPane.add(outputField);
		outputField.setColumns(10);
		
		JButton OKButton = new JButton("\u786E\u5B9A");
		OKButton.setFont(new Font("新宋体", Font.BOLD, 15));
		OKButton.setBounds(84, 159, 113, 27);
		contentPane.add(OKButton);
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Float.parseFloat(outputField.getText()) < 100000) {
					user_query = asi.query(name);
					if (user_query.getbalance() > Double.parseDouble(outputField.getText())) {
						double temp = user_query.getbalance() - Double.parseDouble(outputField.getText());
						DecimalFormat df = new DecimalFormat("0.00 ");
						asi.update(user_query.getName(), temp);
						setVisible(false);
						atmFrame frame = new atmFrame(name);
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "取钱交易成功！" + "\n" + "剩余余额为：" + df.format(temp));

					} else {
						JOptionPane.showMessageDialog(null, "余额不足，请重新输入！" + "\n" + "当前余额为：" + user_query.getbalance());
						outputField.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "输入金额大于100000，请重新输入！");
					outputField.setText("");
				}

			}

		});
		
		JButton backButton_1 = new JButton("\u8FD4\u56DE");
		backButton_1.setFont(new Font("新宋体", Font.BOLD, 15));
		backButton_1.setBounds(233, 159, 113, 27);
		contentPane.add(backButton_1);
		backButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				atmFrame af = new atmFrame(name);
				setVisible(false);
				af.setVisible(true);			
			}		
		});
		
		JLabel remindLabel = new JLabel("*\u5355\u7B14\u6700\u5927\u53EF\u53D610000");
		remindLabel.setForeground(Color.RED);
		remindLabel.setBounds(199, 126, 138, 18);
		contentPane.add(remindLabel);
	}

}
