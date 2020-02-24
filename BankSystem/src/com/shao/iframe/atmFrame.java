package com.shao.iframe;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.shao.Service.impl.AccountServiceImpl;
import com.shao.model.user;

public class atmFrame extends JFrame {

	private JPanel contentPane;
	private user user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmFrame frame = new atmFrame(null);
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
	public atmFrame(final String name) {
		AccountServiceImpl asi =new AccountServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 434);
		contentPane = new JPanel();
		setTitle(name);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.setFont(new Font("新宋体", Font.BOLD, 20));
		queryButton.setBounds(99, 101, 113, 27);
		contentPane.add(queryButton);
		queryButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			user = asi.query(name);
			DecimalFormat df = new DecimalFormat( "0.00 "); 
			JOptionPane.showMessageDialog(null,
		              "您的账户名:"+user.getName()+"\n"+"当前余额:￥"+user.getbalance()+"\n","信息提示",
		              JOptionPane.INFORMATION_MESSAGE);		
		}
		});
		
		JButton depositButton = new JButton("\u5B58\u6B3E");
		depositButton.setFont(new Font("新宋体", Font.BOLD, 20));
		depositButton.setBounds(99, 223, 113, 27);
		contentPane.add(depositButton);
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				depositFrame df = new depositFrame(name);
				setVisible(false);
				df.setVisible(true);
			}
			
		});
		
		JButton withdrawButton = new JButton("\u53D6\u6B3E");
		withdrawButton.setFont(new Font("新宋体", Font.BOLD, 20));
		withdrawButton.setBounds(288, 101, 113, 27);
		contentPane.add(withdrawButton);
		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				withdrawFrame wf = new withdrawFrame(name);
				setVisible(false);
				wf.setVisible(true);
			}
			
		});
		
		JButton transferButton = new JButton("\u8F6C\u8D26");
		transferButton.setFont(new Font("新宋体", Font.BOLD, 20));
		transferButton.setBounds(288, 223, 113, 27);
		contentPane.add(transferButton);
		transferButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transferFrame wf = new transferFrame(name);
				setVisible(false);
				wf.setVisible(true);
			}
			
		});
	}

}
