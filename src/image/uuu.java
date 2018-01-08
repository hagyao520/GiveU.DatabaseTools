package image;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 自定义Jpanel
 * 为了动态调用其paintComponent方法
 * @author SongFei
 * @date 2015年5月18日
 */
public class uuu extends JPanel {

	private JLabel minButton;
	private JLabel maxButton;
	private JLabel exitButton;
	private JFrame frame;
	
	private JButton backButton1;
	private JButton backButton2;
	private JButton backButton3;
	private JButton backButton4;
	private JButton backButton5;
	
	private ImageIcon imageIcon;
	
	public uuu(JFrame frame) {
		this.frame = frame;
		initGUI();
		initListener();
		// 给imageIcon指定默认图片
//		imageIcon = produceImage("back0.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
	
	/**
	 * 初始化界面
	 */
	private void initGUI() {
		setLayout(null);
		
		minButton = new JLabel();
		minButton.setBounds(357, 0, 31, 20);
//		minButton.setIcon(produceImage("min.png"));
		add(minButton);
		
		maxButton = new JLabel();
		maxButton.setBounds(383, 0, 31, 20);
//		maxButton.setIcon(produceImage("max.png"));
		add(maxButton);

		exitButton = new JLabel();
		exitButton.setBounds(411, 0, 39, 20);
//		exitButton.setIcon(produceImage("close.png"));
		add(exitButton);
		
		backButton1 = new JButton("背景1");
		backButton1.setBounds(170, 25, 100, 45);
		add(backButton1);
		backButton2 = new JButton("背景2");
		backButton2.setBounds(170, 90, 100, 45);
		add(backButton2);
		backButton3 = new JButton("背景3");
		backButton3.setBounds(170, 155, 100, 45);
		add(backButton3);
		backButton4 = new JButton("背景4");
		backButton4.setBounds(170, 220, 100, 45);
		add(backButton4);
		backButton5 = new JButton("背景5");
		backButton5.setBounds(170, 285, 100, 45);
		add(backButton5);
	}

	/**
	 * 初始化监听
	 */
	private void initListener() {
		// 最小化按钮事件
		minButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
//				minButton.setIcon(produceImage("min.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
//				minButton.setIcon(produceImage("min_active.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setExtendedState(Frame.ICONIFIED);
			}
		});
		// 最大化按钮事件
		maxButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if (frame.getExtendedState() != Frame.MAXIMIZED_BOTH) {
//					maxButton.setIcon(produceImage("max.png"));
				} else {
//					maxButton.setIcon(produceImage("restore.png"));
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (frame.getExtendedState() != Frame.MAXIMIZED_BOTH) {
//					maxButton.setIcon(produceImage("max_active.png"));
				} else {
//					maxButton.setIcon(produceImage("restore_active.png"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// 若是最大化过了，就直接还原大小
				if (frame.getExtendedState() == Frame.MAXIMIZED_BOTH) {
					frame.setSize(450, 350);// 还原大小
					frame.setLocationRelativeTo(null);// 这里需要重新设置坐标
//					maxButton.setIcon(produceImage("max.png"));
				} else {
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
//					maxButton.setIcon(produceImage("restore.png"));
				}
				// 按比例放置按钮
				fixedButtonPoint();
			}
		});
		// 退出按钮事件
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
//				exitButton.setIcon(produceImage("close.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
//				exitButton.setIcon(produceImage("close_active.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		
		backButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				backButton1.setText(backButton1.getText()+"-我被选中啦");
				imageIcon = produceImage("back0.png");
				// 重点：此方法会去调用paintComponent()方法来进行绘制工作
				repaint();
			}
		});
		backButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				imageIcon = produceImage("back1.png");
				repaint();
			}
		});
		backButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				imageIcon = produceImage("back2.jpg");
				repaint();
			}
		});
		backButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				imageIcon = produceImage("back3.jpg");
				repaint();
			}
		});
		backButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				imageIcon = produceImage("back4.jpg");
				repaint();
			}
		});
	}
	
	/**
	 * 获取图片
	 * @param name 图片名称
	 * @return
	 */
	private ImageIcon produceImage(String name) {
		ImageIcon backImage = new ImageIcon(getClass().getClassLoader().getResource(name));
		return backImage;
	}
	
	/**
	 * 按比例放置按钮，不管放大还是缩小窗体，按钮永远在右上角
	 */
	public void fixedButtonPoint() {
		// 里面这些39、28的数字是自己的算法比例
		minButton.setBounds(frame.getWidth()-39-28-28, 0, 31, 20);
		maxButton.setBounds(frame.getWidth()-39-28, 0, 31, 20);
		exitButton.setBounds(frame.getWidth()-39, 0, 39, 20);
	}
	
}