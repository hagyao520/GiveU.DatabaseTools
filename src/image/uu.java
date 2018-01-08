package image;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * Swing界面优化示例
 * @author SongFei
 * @date 2015年5月17日
 */
public class uu extends JFrame {

	private uuu content;
	private Point point = new Point();

	public uu() {
		initGUI();
		initListener();
	}
	
	/**
	 * 初始化界面
	 */
	private void initGUI() {
		setSize(850, 350);
		setTitle("course");
		// 去边框
		setUndecorated(true);
		// 初始化自定义panel时需要将自己带过去，因为设置大小之类的操作需要用到
		content = new uuu(this);
		// 加入到容器
		// 大家这里注意一下
		// 虽然getContentPane()取出来的容器，我们可以直接进行操作，但是有可能涉及到重绘什么的，
		// 所以还是再将我们自定义的一层panel覆盖上比较好，操作自己的东西是可控的
		getContentPane().add(content);
	}

	/**
	 * 初始化鼠标事件
	 */
	private void initListener() {
		// 窗体事件，用于拖动窗体位置
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 记录下鼠标点击的那一刻坐标
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// 右
				if (getCursor().getType() == Cursor.E_RESIZE_CURSOR) {
					setSize(e.getX(), getHeight());
					content.fixedButtonPoint();
				// 左
				} else if (getCursor().getType() == Cursor.W_RESIZE_CURSOR) {
					setSize(getWidth() - e.getX(), getHeight());
					setLocation(getLocationOnScreen().x + e.getX(), getLocationOnScreen().y);
					content.fixedButtonPoint();
				// 下
				} else if (getCursor().getType() == Cursor.S_RESIZE_CURSOR) {
					setSize(getWidth(), e.getY());
				// 上
				} else if (getCursor().getType() == Cursor.N_RESIZE_CURSOR) {
					setSize(getWidth(), getHeight() - e.getY());
					setLocation(getLocationOnScreen().x, getLocationOnScreen().y + e.getY());
				} else {
					Point p = getLocation();
					setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
				}
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				// 根据边界和鼠标坐标的对比来决定鼠标的样式
				// 这里范围大家实际考量，这里只是我自己写的一个范围，大家看看就好
				if (e.getX() == 0 || e.getX() == 1 || e.getX() == 2 
						|| e.getX() == 3 || e.getX() == 4 || e.getX() == 5) {
					setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
					
				} else if (e.getX() == getWidth() || e.getX() == getWidth()-1 || e.getX() == getWidth()-2 
						|| e.getX() == getWidth()-3 || e.getX() == getWidth()-4 || e.getX() == getWidth()-5) {
					setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
					
				} else if (e.getY() == 0 || e.getY() == 1 || e.getY() == 2 
						|| e.getY() == 3 || e.getY() == 4 || e.getY() == 5) {
					setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
					
				} else if (e.getY() == getHeight() || e.getY() == getHeight()-1 || e.getY() == getHeight()-2 
						|| e.getY() == getHeight()-3 ||e.getY() == getHeight()-4 || e.getY() == getHeight()-5) {
					setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
					
				} else {
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
	}
	
	public static void main(String[] args) {
		uu demo1 = new uu();
		demo1.setVisible(true);
		demo1.setLocationRelativeTo(null);
	}

}