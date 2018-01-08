package image;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
 
public class Jdbcs {
@SuppressWarnings("rawtypes")
public Vector rowData, columnName;
Connection con = null;
Statement statement = null;
ResultSet res = null;
String driver = "oracle.jdbc.driver.OracleDriver";
String url  = "jdbc:oracle:thin:@idcdbtest.dafycredit.com:1521:dbtest01";
String name = "dafy_sales";
String passwd = "Ju$2017";
 
public Jdbcs(){
    try{
    Class.forName(driver).newInstance();
    con = DriverManager.getConnection(url,name,passwd);
    statement = con.createStatement();
     
    }catch(SQLException e){
        e.printStackTrace();
    }catch(Exception e){
        e.printStackTrace();
        }
}
//对用户信息的修改实际上就是对密码的修改
public boolean update(String username1,String password1,String newpassword){
    boolean judge = false;
    boolean s =compare(username1,password1);
    if(s){
    String sql = "update user set password=\""+newpassword+"\"where username=\""+username1+"\"";
    try {
        int a = statement.executeUpdate(sql);
        if(a==1){
            JOptionPane.showMessageDialog(null,"密码修改成功！");
            judge = true;
        }
        con.close();
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "用户不存在！");
        e.printStackTrace();
    }
    }
    else{
         JOptionPane.showMessageDialog(null, "修改失败");
    }
    return judge;
}
//删除用户信息
public void delete(String username,String password){
    if(compare(username,password)){
        JOptionPane.showMessageDialog(null,"已经完成删除");
    }else{
        return;
    }
    String sql = "delete from user where username=\""+username+"\"";
    try{
        @SuppressWarnings("unused")
		int a =  statement.executeUpdate(sql);
        con.close();
        statement.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"不存在该用户！");
        e.printStackTrace();
    }
     
}
//查询合同信息
@SuppressWarnings({ "rawtypes", "unchecked" })
public void querycont(String contract_no){
	Connection c = null;
    Statement stmt = null;

    String sql = "select c.contract_no as 合同号,c.credit_model as 合同资金模式,f.credit_amount as f贷款金额,c.credit_amount as c贷款金额,g.goods_credit_amount as g贷款金额,c.init_pay c首付,g.goods_init_pay as g首付,c.price as c商品价格,g.goods_price as g商品价格,(c.credit_amount+c.init_pay) as s商品价格,c.deduct_date as c首次扣款日,e.fst_date_pay as e首次扣款日,(round((f.credit_amount*p.month_ratio_eir)/100,0))+(f.insurance_fee)+(f.power_fee)+(f.treasure_box_fee) as s每月总还款额,i.type_instalment as i本金1,i.value_instalment as i本金费用,f.principal as f第一期本金,ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3) as s第一期本金,i.type_instalment as i利息2,i.value_instalment as i利息费用,f.interest as f第一期利息,ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3) as s第一期利息,(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))as s每月应还本息,(round((f.credit_amount*p.month_ratio_eir)/100,0))-((ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))) as s每月应付费用,f.cs_fee as f月服务费,(f.annuity - f.principal - f.interest - f.account_fee) as s月服务费,f.cs_fee_rate as f月服务费率,round(((f.annuity - f.principal - f.interest - f.account_fee) / f.credit_amount * 100),3) as s月服务费率,c.repay_style as c还款方式,f.annuity as f纯月还款额,c.annuity as c纯月还款额,round((f.credit_amount*p.month_ratio_eir)/100,0) as s纯月还款额,c.power_flag as c权益包购买状态,f.power_fee as f权益包费用,c.power_fee as c权益包费用,e.is_ssi as e是否购买保险,g.insurance_supplier as 保险类型,i.type_instalment as i保险70,i.value_instalment as i保险费,f.insurance_fee as f保险费,c.insurance_fee as c保险费,e.insurance_fee as e保险费,FLOOR(f.credit_amount*0.008) as s保险费,f.discount_amount as f每月优惠金额,round((f.credit_amount*p.month_ratio_bir)/100)-round((f.credit_amount*p.month_ratio_eir)/100) s每月优惠金额,f.lead_amount as f前置咨询费,f.month_ir as f月贷款利率,p.month_ir as p月贷款利率,f.account_fee_rate as f月咨询费用率,p.account_fee as p月咨询费率,f.coupon_amount as f买立减优惠金额,e.coupon_amount as e买立减优惠金额,round(f.credit_amount*p.overpay_year*(1-0.9)/12/100,0) as s买立减优惠金额,f.credit_type as f合同类别,f.account_fee as f月咨询费,round((f.credit_amount*f.account_fee_rate/100),3) as s月咨询费,f.seller_service_fee as f前置商家服务费,(f.credit_amount*p.seller_bonus) as s前置商家服务费,f.customer_service_fee as f前置客户服务费,f.interest_coupon as f每期利息减免,f.finance_coupon as f每期财务费减免,f.stamp_amount as f印花税,(f.credit_amount*0.00005) as s印花税,f.seller_return_fee as f商家返点费用,(f.credit_amount * p.seller_bonus / 100) as s商家返点费用,f.sa_bonus_fee as f销售提成费用,(f.credit_amount * p.sa_bonus / 100) as s销售提成费用,f.cs_fee2 as f月咨询费用2,f.cs_fee_rate2 as f月咨询费率2,f.giveu_month_ir as f即有年化率,p.month_ir as p即有年化率,f.cs_coupon as f每期咨询费减免,f.accident_insurance_fee as f手Q意外保险费用,f.coupon_sales as f抵用券售价,(f.credit_amount*0.1) as s抵用券售价,f.voucher_amount as f抵用券面值,ceil((f.credit_amount*0.1)/100)*100 as s抵用券面值,f.voucher_count as f抵用券数量,(f.voucher_amount/100) as s抵用券数量,i.type_instalment as i百宝箱92,i.value_instalment as i百宝箱费用,f.treasure_box_fee as f百宝箱费用,FLOOR(f.credit_amount*t.treasure_box_rate/100) as s百宝箱费用,f.treasure_box_flag as f百宝箱是否购买,g.broken_screen_type as 碎屏零未购买二已购买,g.stag_insurance_type as 碎屏零未购买二已购买,f.broken_screen_service as f碎屏,g.BROKEN_SCREEN_SERVICE as g碎屏,f.stag_insurance_service as f延保,g.STAG_INSURANCE_SERVICE as g延保,y.service_category as 一延保二碎屏,y.goods_category as 零通用一普通二苹果,y.payment_num_price as s碎屏延保费用  from dafy_sales.cs_credit c inner join dafy_sales.product p on p.ID = c.id_product inner join dafy_sales.cs_credit_fee f on c.id=f.id_credit inner join dafy_sales.cs_experience e on c.id=e.id_credit inner join dafy_sales.cs_goods g on c.id=g.id_credit inner join dafy_sales.TREASURE_BOX_TABLES t on t.search_type=p.search_type inner join dafy_sales.product_added_services y on y.payment_num=p.payment_num inner join dafy_sales.instalment i on i.id_credit=c.id where c.credit_amount >= y.min_price and c.credit_amount <= y.max_price and y.verson=1 and i.num_instalment=1 and i.status='a' and "
    		+ "c.contract_no="+ contract_no +""
    		+ "order by i.type_instalment";
    
    rowData = new Vector();
    try {
        c = DriverManager.getConnection(url, name, passwd);  
        c.setAutoCommit(false);
        stmt = c.createStatement();
        res = statement.executeQuery(sql);
        ResultSetMetaData data = res.getMetaData();
        columnName = new Vector();  
        for (int i = 1; i <= data.getColumnCount(); i++) {
            columnName.add(data.getColumnName(i));//这里是列名
        }
        while (res.next()) {
            Vector line1 = new Vector();
           for (int k = 1; k <= data.getColumnCount(); k++) {
                line1.add(res.getString(data.getColumnName(k)));//这里是添加行数据
           }
                rowData.add(line1);
        }
        res.close();
        stmt.close();
        c.close();
        JOptionPane.showMessageDialog(null,"查询成功！");
    } catch (Exception e) {
    	JOptionPane.showMessageDialog(null,"合同号不存在！");
        e.printStackTrace();
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }      
}

//用户注册功能的实现，添加数据
public void insert(String username,String password){
    String sql = "insert into user(username,password) values(\""+username+"\",\""+password+"\")";
    try{
        int a = statement.executeUpdate(sql);
        con.close();
        statement.close();
        if(a==1){
            JOptionPane.showMessageDialog(null,"注册成功！");
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
        e.printStackTrace();
    }
}
//对比用户名和密码是不匹配
public boolean compare(String username, String password){
    boolean m = false;
    String sql = "select PASSWORD from sys_user_list where id="+ username +"";
    try{
        res = statement.executeQuery(sql);
        if(res.next()){
            String pa = res.getString(1);
            System.out.println(pa+" " +password);
            if(pa.equals(password)){
                m = true;
            }else {
                JOptionPane.showMessageDialog(null, "密码错误！");
            }
        }else {
            JOptionPane.showMessageDialog(null, "用户名不存在！");
        }
        res.close();
        con.close();
        statement.close();
         
    }catch(SQLException e){
        e.printStackTrace();
    }
    return m;
}
 
}