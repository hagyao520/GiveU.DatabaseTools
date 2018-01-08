package databasetools.ui.frame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import databasetools.util.*;

//TODO 逆天所在JDialog
@SuppressWarnings("serial")
public class LoginWindow extends JDialog {
	/** 主面板 */
	@SuppressWarnings("unused")
	private JPanel content;
	/** 最小化按钮 */
	private JLabel minButton;
	/** 退出按钮 */
	private JLabel exitButton;
	/** 头像 */
	private JLabel pictureLabel;
	/** 数据版本Txt */
	private JLabel DataVersionLabel;
	/** 数据版本Box */
//	private JComboBox DataVersionBox;
	@SuppressWarnings("rawtypes")
	public static JComboBox DataVersionBox;
	/** 账号 */
	private JTextField userNameField;
	/** 密码 */
	@SuppressWarnings("unused")
	private JPasswordField passWordField;
	/** 保存密码Box */
	private JLabel savePassCheckBox;
	/** 保存密码Txt */
	private JLabel savePassLabel;
	/** 自动登录Box */
	private JLabel autoLoginCheckBox;
	/** 自动登录Txt */
	private JLabel autoLoginLabel;
	/** 登陆按钮 */
	private JLabel loginButton;
	/** 注册账号 */
	@SuppressWarnings("unused")
	private JLabel registerLabel;
	/** 找回密码 */
	private JLabel findPassLabel;
	/** 坐标（拖动记录） */
	private Point point = new Point();
	
	private boolean isSavePass;
	private boolean isAutoLogin;
	private TrayIcon icon;
	private SystemTray tray;
	
	
	public static LoginWindow getInstance() {
		LoginWindow inst = new LoginWindow();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		return inst;
	}
	
	public LoginWindow() {
		super();
		initGUI();
//		initTrayIcon();
		initListener();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initGUI() {
		
	   try {
			//主面板
			setSize(435, 330);
			setUndecorated(true);
//			TODO 这个API导致输入中文白屏
//			AWTUtilities.setWindowOpaque(this, false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
			JPanel content = new JPanel() {
				private static final long serialVersionUID = 1L;
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(PictureUtil.getPicture("LoginWindow.png").getImage(), 0, 0, null);
					this.setOpaque(false);
				}
			};
			content.setLayout(null);
			content.setBorder(Constants.GRAY_BORDER);
			getContentPane().add(content, BorderLayout.CENTER);
			
			//最小化按钮
			minButton = new JLabel();
			content.add(minButton);
			minButton.setBounds(370, 0, 30, 20);
			minButton.setIcon(PictureUtil.getPicture("minimize.png"));
		
			//关闭按钮
			exitButton = new JLabel();
			content.add(exitButton);
			exitButton.setBounds(400, 0, 40, 20);
			exitButton.setIcon(PictureUtil.getPicture("close.png"));
			
			//头像区域
			pictureLabel = new JLabel();
			content.add(pictureLabel);
			pictureLabel.setBounds(50, 200, 75, 70);
			pictureLabel.setBorder(Constants.LIGHT_GRAY_BORDER);
			pictureLabel.setIcon(PictureUtil.getPicture("HeadPortrait.png"));
		   
			//数据版本Box
			DataVersionBox = new JComboBox();  
			DataVersionBox.addItem("正式版本");  
	        DataVersionBox.addItem("测试版本");  
	        DataVersionBox.addItem("开发版本");  
	        DataVersionBox.setFont(Constants.BASIC_FONT3);
	        content.add(DataVersionBox); 
	        DataVersionBox.setBounds(138, 195, 194, 27);
	        DataVersionBox.setSelectedIndex(1);

			//数据版本Txt
			DataVersionLabel =new JLabel("数据版本");  
			content.add(DataVersionLabel);  
			DataVersionLabel.setFont(Constants.BASIC_FONT);
			DataVersionLabel.setBounds(340, 195, 62, 24);
			
	        //用户工号Field
			userNameField = new JTextField();
			content.add(userNameField);
			userNameField.setBounds(138, 225, 195, 27);
			userNameField.setBorder(Constants.LIGHT_GRAY_BORDER);
			userNameField.setText("请输入工号...");
			userNameField.setFont(Constants.BASIC_FONT4);
			userNameField.setForeground(Color.GRAY);
	        	
			//用户工号Txt
			findPassLabel = new JLabel("用户工号");
			content.add(findPassLabel);
			findPassLabel.setFont(Constants.BASIC_FONT);
			findPassLabel.setBounds(340, 225, 62, 27);
			
//			//账号
//			userNameField = new JTextField();
//			content.add(userNameField);
//			userNameField.setBounds(138, 190, 190, 30);
//			userNameField.setBorder(Constants.LIGHT_GRAY_BORDER);
				
//			//密码Field
//			passWordField = new JPasswordField();
//			content.add(passWordField);
//			passWordField.setBounds(138, 220, 190, 30);
//			passWordField.setBorder(Constants.LIGHT_GRAY_BORDER);
		
			//保存密码Box
			savePassCheckBox = new JLabel();
			content.add(savePassCheckBox);
			savePassCheckBox.setBounds(138, 255, 18, 20);
			savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
		
			//保存密码Txt
			savePassLabel = new JLabel("保存密码");
			content.add(savePassLabel);
			savePassLabel.setFont(Constants.BASIC_FONT);
			savePassLabel.setBounds(163, 253, 54, 24);
		
			//自动登录Box
			autoLoginCheckBox = new JLabel();
			content.add(autoLoginCheckBox);
			autoLoginCheckBox.setBounds(258, 255, 18, 20);
			autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
		
			//自动登录Txt
			autoLoginLabel = new JLabel("自动登录");
			content.add(autoLoginLabel);
			autoLoginLabel.setFont(Constants.BASIC_FONT);
			autoLoginLabel.setBounds(280, 253, 52, 24);
		
			//登陆按钮
			loginButton = new JLabel();
			content.add(loginButton);
			loginButton.setBounds(141, 280, 190, 45);
			loginButton.setIcon(PictureUtil.getPicture("login_button.png"));
			
//			//注册账号
//			registerLabel = new JLabel("注册账号");
//			content.add(registerLabel);
//			registerLabel.setFont(Constants.BASIC_FONT);
//			registerLabel.setBounds(338, 195, 62, 24);
//			
//			//找回密码
//			findPassLabel = new JLabel("找回密码");
//			content.add(findPassLabel);
//			findPassLabel.setFont(Constants.BASIC_FONT);
//			findPassLabel.setBounds(338, 223, 62, 27);
			
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}
	}

	//TODO 这个地方可以考虑，tray就只要一个，在主窗体出来之后换掉其上面的监听
	@SuppressWarnings("unused")
	private void initTrayIcon() {
		if (SystemTray.isSupported()) {
			try {
				tray = SystemTray.getSystemTray();
				icon = new TrayIcon(PictureUtil.getPicture("/jyb_icon.png").getImage(), "即有宝");
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
		
		//主窗体事件
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});
		
		//最小化按钮事件
		minButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				minButton.setIcon(PictureUtil.getPicture("minimize.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				minButton.setIcon(PictureUtil.getPicture("minimize_active.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
			}
		});
		
		//退出按钮事件
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(PictureUtil.getPicture("close.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(PictureUtil.getPicture("close_active.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
//				tray.remove(icon);
//				System.exit(0);
				dispose();
			}
		});
		
		//账号输入框-焦点事件
		userNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				userNameField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(userNameField.getText());
				if (StringUtil2_1920x1080.isEmpty(contract_no)) {
					userNameField.setText("请输入工号...");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				userNameField.setBorder(Constants.DARKGRAY_BORDER);
				userNameField.setText("");
			}
		});
		userNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				}
			}
		});
		
//		//密码输入框焦点事件
//		passWordField.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				passWordField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			}
//			@Override
//			public void focusGained(FocusEvent e) {
//				passWordField.setBorder(Constants.ORANGE_BORDER);
//			}
//		});
//		passWordField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
////					login();
//				}
//			}
//		});
		
		//保存密码复选框事件
		savePassCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isSavePass) {
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isSavePass = false;
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isAutoLogin = false;
				} else {
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isSavePass = true;
				}
			}
		});
		
		//保存密码字体事件
		savePassLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isSavePass) {
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isSavePass = false;
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isAutoLogin = false;
				} else {
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isSavePass = true;
				}
			}
		});
		
		//自动登录复选框事件
		autoLoginCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isAutoLogin) {
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isAutoLogin = false;
				} else {
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isAutoLogin = true;
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isSavePass = true;
				}
			}
		});
		
		//自动登录字体事件
		autoLoginLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isAutoLogin) {
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-No.png"));
					isAutoLogin = false;
				} else {
					autoLoginCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isAutoLogin = true;
					savePassCheckBox.setIcon(PictureUtil.getPicture("Reelection-Yes.png"));
					isSavePass = true;
				}
			}
		});
		
		//登陆按钮事件
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setIcon(PictureUtil.getPicture("login_button.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setIcon(PictureUtil.getPicture("login_active.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				login();		
			}
		});
		
//		//注册账号鼠标事件
//		registerLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseExited(MouseEvent e) {
//				registerLabel.setText("\u6ce8\u518c\u8d26\u53f7");
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				registerLabel.setText("<html><u>\u6ce8\u518c\u8d26\u53f7</u><html>");
//			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (null == StringUtil.getHomePage()) {					
//					HomePageWindow.getInstance();
//				} else {
//					JOptionPane.showMessageDialog(null, "主页窗口已存在！");
//					return;
//				}
//			}
//		});
		
//		//找回密码鼠标事件
//		findPassLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseExited(MouseEvent e) {
//				findPassLabel.setText("\u627e\u56de\u5bc6\u7801");
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				findPassLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				findPassLabel.setText("<html><u>\u627e\u56de\u5bc6\u7801</u><html>");
//			}
//		});
	}
	
//	//登录按钮处理事件
//	private void login() {
//		String username = userNameField.getText();
//		String password = String.valueOf(passWordField.getPassword());
//		if (StringUtil.isEmpty(username)) {
//			JOptionPane.showMessageDialog(null, "请输入账号！");
//			return;
//		}
//		if (StringUtil.isEmpty(password)) {
//			JOptionPane.showMessageDialog(null, "请输入密码！");
//			return;
//		}
//		if(StringUtil.logincompare(username,password)){
//		    JOptionPane.showMessageDialog(null,"登录成功！");
//		    super.setVisible(false);
////		    HomePageWindow.getInstance();
////			HomePageWindow_1600x900.getInstance();
//			HomePageWindow_1920x1080.getInstance();	
//		}
////		super.setVisible(false);
////		HomePageWindow.getInstance();
////		HomePageWindow_1600x900.getInstance();
////		HomePageWindow_1920x1080.getInstance();	
//	}	
	
	//登录按钮处理事件
	private void login() {
		String DataVersion = DataVersionBox.getSelectedItem().toString();
		String username = userNameField.getText();
		if("请输入工号...".equals(username)){
			JOptionPane.showMessageDialog(null, "请输入工号！");
			return;
		}
		if (StringUtil2.logincompare(DataVersion,username)) {
			JOptionPane.showMessageDialog(null,"登录成功！");
		    super.setVisible(false);
//			HomePageWindow_1600x900.getInstance();
//			HomePageWindow_1920x1080.getInstance();	
//			HomePageWindow2_1600x900.getInstance();
			HomePageWindow2_1920x1080.getInstance();	
		}
//		super.setVisible(false);
//		HomePageWindow.getInstance();
//		HomePageWindow_1600x900.getInstance();
//		HomePageWindow_1920x1080.getInstance();	
//		HomePageWindow2_1600x900.getInstance();
//		HomePageWindow2_1920x1080.getInstance();
	}		
}
