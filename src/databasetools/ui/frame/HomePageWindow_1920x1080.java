package databasetools.ui.frame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import databasetools.util.*;
import databasetools.ui.common.MyScrollBarUI;

@SuppressWarnings("serial")
public class HomePageWindow_1920x1080  extends JFrame{
	
	/** 主面板 */
	private JPanel content;
	
	/** 数据展示列表 */
	public static JScrollPane DataDisplayList;
	
	/** 合同号Txt */
	private JLabel contractLabel;
	/** 合同号输入框 */
	private JTextField contractField;
	/** 查询合同费用详情按钮 */
	private JLabel InquiryContractButton;

	/** SQLTxt */
	private JLabel SQLLabel;
	/** SQL输入框*/
	private JTextArea SQLArea;
	/** SQL输入框滑轮*/
	private JScrollPane SQLScroll;

	/** 查询SQL详情按钮 */
	private JLabel SQLButton;
	
	/** 挂起进程按钮 */
	private JLabel HangUpProcess;
	/** 挂起进程图标 */
	private TrayIcon icon;
	private SystemTray tray;

	public static HomePageWindow_1920x1080 getInstance() {
		HomePageWindow_1920x1080 inst = new HomePageWindow_1920x1080();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		return inst;
	}
	
	public HomePageWindow_1920x1080() {
		super();
		initGUI();
		initTrayIcon();
		initListener();
	}
	
	private void initGUI() {
		
	    try {			
			setTitle("By:小智出品，必属精品-----欢迎使用即有宝<等额本息商品贷>信息查询系统  ");
			setSize(1920,1080-30);
			setLocation(0,0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			content = new JPanel() {
			//设置背景图片	
//			private static final long serialVersionUID = 1L;
//			  protected void paintComponent(Graphics g) {
//					super.paintComponent(g);
//					g.drawImage(PictureUtil.getPicture("HomePage.png").getImage(), 0, 0, null);
//					this.setOpaque(false);
//			  }
			};
			content.setLayout(null);
			getContentPane().add(content, BorderLayout.CENTER);
			content.setBorder(Constants.GRAY_BORDER);
			
			DataDisplayList = new JScrollPane();
			DataDisplayList.setBounds(10,30,1900,800);
			//设置背景是否透明
			DataDisplayList.setOpaque(false);  
			DataDisplayList.getViewport().setOpaque(false);  
			content.add(DataDisplayList);
			
			contractLabel = new JLabel("合 同 号");
			contractLabel.setFont(Constants.BASIC_FONT);
			contractLabel.setBounds(730, 870, 70, 20);
			content.add(contractLabel);
			
			contractField = new JTextField();
			contractField.setBounds(800, 865, 240, 28);
			contractField.setBorder(Constants.LIGHT_GRAY_BORDER);
			content.add(contractField);
				
			InquiryContractButton = new JLabel("查询合同费用",JLabel.CENTER);
			InquiryContractButton.setFont(Constants.BASIC_FONT);
			InquiryContractButton.setBorder(null);
			InquiryContractButton.setBounds(1060, 865, 100, 30);
			InquiryContractButton.setOpaque(false);
			InquiryContractButton.setBackground(new Color(240, 245, 240, 60));
			content.add(InquiryContractButton);
			
			SQLLabel = new JLabel("S  Q  L");
			content.add(SQLLabel);
			SQLLabel.setFont(Constants.BASIC_FONT);
			SQLLabel.setBounds(730, 940, 70, 20);
	
			SQLScroll = new JScrollPane();
			content.add(SQLScroll);
			SQLArea = new JTextArea();
			SQLArea.setTabSize(2);//TAB键多少位 
			SQLArea.setLineWrap(true);//激活自动换行功能
			SQLArea.setWrapStyleWord(true);//激活断行不断字功能
			SQLScroll.setBorder(Constants.LIGHT_GRAY_BORDER);
			SQLScroll.setViewportView(SQLArea);
			SQLScroll.getVerticalScrollBar().setUI(new MyScrollBarUI());
			SQLScroll.setBounds(800, 920, 240, 60);
			
			SQLButton = new JLabel("查询SQL  (查询数据过大时，请务必加入条件rownum<10000)",JLabel.CENTER);
			SQLButton.setFont(Constants.BASIC_FONT);
			SQLButton.setBorder(null);
			SQLButton.setBounds(1070, 935, 350, 30);
			SQLButton.setOpaque(false);
			SQLButton.setBackground(new Color(240, 245, 240, 60));
			content.add(SQLButton);
			
			HangUpProcess = new JLabel("挂起进程",JLabel.CENTER);
			HangUpProcess.setFont(Constants.BASIC_FONT);
			HangUpProcess.setBorder(null);
			HangUpProcess.setBounds(1800, 950, 80, 30);
			HangUpProcess.setOpaque(false);
			HangUpProcess.setBackground(new Color(240, 245, 240, 60));
			content.add(HangUpProcess);
		
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO 这个地方可以考虑，tray就只要一个，在主窗体出来之后换掉其上面的监听
		private void initTrayIcon() {
			if (SystemTray.isSupported()) {
				try {
					tray = SystemTray.getSystemTray();
					icon = new TrayIcon(PictureUtil.getPicture("jyb_icon.png").getImage(), "即有宝");
					icon.setImageAutoSize(true); //自动适应大小
					icon.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							if (e.getButton() == MouseEvent.BUTTON1) {
								setVisible(true);
								//获取焦点
								requestFocus();
							}
						}
					});
					
					PopupMenu pm = new PopupMenu();
					MenuItem mit = new MenuItem("Exit");
					mit.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							tray.remove(icon);
							System.exit(0);
						}
					});
					pm.add(mit);
					icon.setPopupMenu(pm);
					tray.add(icon);

				} catch (AWTException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	private void initListener() {
				
		//查询合同费用详情按钮事件
		InquiryContractButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
//				loginButton.setIcon(PictureUtil.getPicture("login_button.png"));
				InquiryContractButton.setBorder(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				InquiryContractButton.setBorder(Constants.GRAY_BORDER);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				querycontrac();
			}
		});

		//查询SQL详情按钮事件
		SQLButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
//				loginButton.setIcon(PictureUtil.getPicture("login_button.png"));
				SQLButton.setBorder(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SQLButton.setBorder(Constants.GRAY_BORDER);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				querySql();
			}
		});		
		
		//取消按钮事件
		HangUpProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				HangUpProcess.setBorder(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				HangUpProcess.setBorder(Constants.GRAY_BORDER);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		
		//合同号输入框焦点事件
		contractField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				contractField.setBorder(Constants.LIGHT_GRAY_BORDER);
			}
			@Override
			public void focusGained(FocusEvent e) {
				contractField.setBorder(Constants.DARKGRAY_BORDER);
			}
		});

		//SQL输入框焦点事件
		SQLArea.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				SQLArea.setBorder(Constants.LIGHT_GRAY_BORDER);
			}
			@Override
			public void focusGained(FocusEvent e) {
				SQLArea.setBorder(Constants.DARKGRAY_BORDER);
			}
		});		
	}
	
	//查询合同详情按钮处理事件
	private void querycontrac() {
		String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
		String contract_no = String.valueOf(contractField.getText());
		// 验证
		if (StringUtil.isEmpty(contract_no)) {
			JOptionPane.showMessageDialog(null, "请输入查询的合同号！");
			return;
		}
		if (StringUtil.contractcompare(DataVersion,contract_no)) {
			JOptionPane.showMessageDialog(null,"查询成功！");
			super.setVisible(true);
		}
		StringUtil_1920x1080.btnShow_ActionPerformed(DataVersion,contract_no);
	}
	
	//查询SQL详情按钮处理事件
	private void querySql() {
		String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
		String Sql = String.valueOf(SQLArea.getText());
		// 验证
		if (StringUtil.isEmpty(Sql)) {
			JOptionPane.showMessageDialog(null, "请输入查询的SQL！");
			return;
		}
		StringUtil_1920x1080.btnSQLButton(DataVersion,Sql);
	}	
}
