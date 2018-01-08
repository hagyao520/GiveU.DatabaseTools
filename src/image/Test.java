package image;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class Test extends JFrame implements ActionListener {
private JPanel pan = new JPanel();
private JLabel contlab = new JLabel("合同号");
private JTextField conttext = new JTextField();
public JButton querycont  = new JButton("查询合同详情");

public Test(){
    Font font = new Font("宋体",Font.BOLD,12);
    super.setTitle("欢迎登录本系统");
    pan.setLayout(null);
//    this.setSize(330,400);
//    this.setLocation(200,100);
//    this.setLayout(null);
//    this.setResizable(true);
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    
    contlab.setBounds(20,50,60,30);
    conttext.setBounds(90,50,140,30);
    querycont.setBounds(80,100,120,30);

    pan.add(contlab);
    pan.add(conttext);
    pan.add(querycont);
    
    querycont.setFont(font);
    querycont.addActionListener(this);
     
    super.add(pan);
    super.setSize(300,250);
    super.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}
 
public static void main(String []args){
	
    new Test();
}
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource()==querycont){
    	querycont();
     }
    }
    //查询合同按钮的事件处理函数
    public void querycont(){
     test1 d  = new test1();
     String contract_no = conttext.getText();
      if(d.compare(contract_no)){
        JOptionPane.showMessageDialog(null,"查询成功！");
          super.setVisible(false);
      }
      d.btnShow_ActionPerformed(contract_no);
    } 
}