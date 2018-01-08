package jtable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
public class PageTest extends JFrame implements ActionListener{
 public final  String[] columnHeaders = {"编号","工号","姓名","性别" };//定义表头
 //定义对象
 JTable table;
 JButton butSelect,butFlash,next,previous,first,last;//next:下一页，previous：上一页，first:首页，last:末页
 JScrollPane jsp;
 public String[][] str = null;
 StuHelper sz = new StuHelper();
 
 JTextField txtName;
 JPanel paneNorth,pane;
 JLabel labSelect,lab0;
 //数据库操作
 Connection conn;
 ResultSet rs;
 PreparedStatement ps;
 stuTable st;
 
 int x = sz.sqlCont();
 int countpage =0;//每页显示的记录数
 public PageTest(){
  sz.sqlCont();
  setTitle("数据分页");
  setBounds(100,100,560,530);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
  next  = new JButton("下一页");//下一页
  next.addActionListener(this);
 
  previous  = new JButton("上一页");//上一页
  previous.addActionListener(this);
 
  first = new JButton("首页");
  first.addActionListener(this);
 
  last = new JButton("尾页");
  last.addActionListener(this);
 
  StuHelper sz = new StuHelper();
  str = sz.selectSql(20,countpage);
 
  st = new stuTable();//清空数据表格模型
  table = new JTable(st);
  jsp = new JScrollPane(table);//把表格加载到滚动面板上
   TitledBorder tb = BorderFactory.createTitledBorder("员工信息");
 tb.setTitleColor(Color.blue);
 tb.setTitleFont(new Font("黑体",Font.BOLD,18));
 tb.setTitleJustification(TitledBorder.CENTER);
 tb.setBorder(BorderFactory.createLineBorder(Color.CYAN));
 jsp.setBorder(tb);
  table.setSelectionForeground(Color.RED);//选中的行文字变成红色
  table.setSelectionBackground(Color.YELLOW);//选中的行背景色
  table.setRowHeight(20);//行的高度
 
 //table表中的数据居中显示
 DefaultTableCellRenderer r = new DefaultTableCellRenderer(); 
 r.setHorizontalAlignment(JLabel.CENTER);
 table.setDefaultRenderer(Object.class,r);
  add(jsp,BorderLayout.CENTER);
  //添加北部控件，实现查询功能
  paneNorth = new JPanel();
  labSelect = new JLabel("请输入查询名字:");
  txtName = new JTextField();
  butSelect = new JButton("查询");
  butSelect.addActionListener(this);
  butFlash = new JButton("显示全部数据");
  butFlash.addActionListener(this);
  txtName.setColumns(20);
  paneNorth.add(labSelect);
  paneNorth.add(txtName);
  paneNorth.add(butSelect);
  paneNorth.add(butFlash);
  add(paneNorth,BorderLayout.NORTH);
  JLabel lab0 = new JLabel();
  lab0.setText("总记录数："+x);
  pane = new JPanel();
  pane.setLayout(new FlowLayout());
  pane.add(lab0);
  pane.add(first);
  pane.add(next);
  pane.add(previous);
  pane.add(last);
  add(pane, BorderLayout.SOUTH);
 
  setVisible(true);
 }
 public static void main(String[] args) {
     try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
     } catch (Throwable e) {
         e.printStackTrace();
     }
     EventQueue.invokeLater(new Runnable() {
         public void run() {
             try {
                 PageTest frame = new PageTest();
                 frame.setVisible(true);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     });
 }


 public void actionPerformed(ActionEvent e) {

  if(e.getSource()==first) {//实现首页查询
   countpage=1;
   str = sz.selectSql(20, countpage-1);
  
   table.updateUI();
   JOptionPane.showMessageDialog(this,"已经是首页了");
  
   first.setEnabled(false);
   next.setEnabled(true);
   last.setEnabled(true);
  }
  if(e.getSource()==last) {//实现最后一页
   
   countpage=x/20;
    str = sz.selectSql(20, x/20);
    table.updateUI();
    JOptionPane.showMessageDialog(this,"已经是最后一页了");
    last.setEnabled(false);
    first.setEnabled(true);
    previous.setEnabled(true);
    next.setEnabled(false);
   
  }
  if(e.getSource()==next){//下一页
   countpage++;
   if(countpage>x/20){
    JOptionPane.showMessageDialog(this,"没有下一页了");
    countpage--;
    next.setEnabled(false);
    last.setEnabled(false);
   }else{
    str = sz.selectSql(20, countpage);
    table.updateUI();
    first.setEnabled(true);
    previous.setEnabled(true);
    last.setEnabled(true);
   }
  }else if(e.getSource()==previous){//上一页
   countpage--;
   if(countpage<0){
    JOptionPane.showMessageDialog(this,"没有上一页了");
    countpage++;
    first.setEnabled(false);
    previous.setEnabled(false);
   }else{
    str = sz.selectSql(20, countpage);
    table.updateUI();
    last.setEnabled(true);
    next.setEnabled(true);
   }
  

  }
 }
 private class stuTable extends AbstractTableModel{//建立表格模型
  public String getColumnName(int col){
   return columnHeaders[col];
  }
  public int getColumnCount() {
   return str[0].length;
  }
  public int getRowCount() {
   return str.length;
  }
  public Object getValueAt(int row,int column){
   return str[row][column];
  }
 }

}