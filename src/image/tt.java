package image;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class tt extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField codeTxt;
	private JButton btn;
	private JTable table;
	private Object[] columnNames = { "商品编码", "条码", "商品名称" };
	private String code;
	private Object[][] cells;
	private DefaultTableModel model;

	public tt(String code) {
		this.code = code;
		initComponents();
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				Dialog dialog = (Dialog) evt.getSource();
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
	}

	private void initComponents() {
		JPanel topPanel = new JPanel();
		JLabel codeLabel = new JLabel();
		codeLabel.setText("编码");
		codeTxt = new JTextField();
		codeTxt.setColumns(5);
		btn = new JButton("搜索");
		codeTxt.setText(code);
		topPanel.add(codeLabel);
		topPanel.add(codeTxt);
		topPanel.add(btn);

		table = new JTable();
		buildTable(code);
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.NORTH);

//		 table.setPreferredScrollableViewportSize(new Dimension(600, 600));
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(500);
		table.setPreferredSize(new Dimension(1000, 1000));

		JScrollPane panel = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		panel.setPreferredSize(new Dimension(500, 300));

		add(panel, BorderLayout.CENTER);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String code = codeTxt.getText();
				if (code != null && !code.trim().equals("")) {
					buildTable(code);
				}
			}
		});
	}

	public void buildTable(String code) {
		model = new DefaultTableModel();
		cells = new Object[20][columnNames.length];

		for (int i = 0; i < cells.length; i++) {			
			cells[i][0] = "pluCode";
			cells[i][1] = "barCode";
			cells[i][2] = "pluName";
		}

		model.setDataVector(cells, columnNames);
		table.setModel(model);
	}
	
	public static void main(String[] args) {
		new tt("");
	}
	
}
