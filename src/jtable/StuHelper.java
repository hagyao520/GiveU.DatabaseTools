package jtable;

import java.sql.*;

public class StuHelper{
 public  static String[][] dataValues =null;
 Connection conn = null;
 ResultSet rs;
 PreparedStatement ps;
 
 public   Connection connSql(){//加载驱动，连接数据库
 
  try {
   Class.forName("oracle.jdbc.driver.OracleDriver");
   conn = DriverManager.getConnection("jdbc:oracle:thin:@idcdbtest.dafycredit.com:1521:dbtest01","dafy_sales","Ju$2017") ;
   System.out.println("连接成");
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return conn;
 }

 public int sqlCont(){
  int x = 0;//定义行记录
  try {
   Connection conn = connSql();
   String sql = "select * from cs_person";
   Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
   ResultSet re = st.executeQuery(sql);
   re.last();//移动最后一行
   x = re.getRow();//返回当前行
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return x;
 }
 //查询数据
 /**
  *
  * @param x:每页记录数
  * @param y：页数
  * @return
  */
 public   String[][] selectSql(int x,int y){
  dataValues = new String[x][4];
  int count = 0 ;
  Connection conn = connSql();
  String sql = "select rownum,id,name,sex from cs_person where rownum>"+x+" and rownum  not in (select rownum from cs_person where rownum<"+y*20+") order by rownum";
  try {
   Statement st = conn.createStatement();
   ResultSet re = st.executeQuery(sql);
   while(re.next()){
    dataValues[count][0]=re.getString(1);//String.valueOf((re.getInt(1)));
    dataValues[count][1]=re.getString(2);
    dataValues[count][2]=re.getString(3);
    dataValues[count][3]=re.getString(4);
    count++;
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return dataValues;
 } 
 public ResultSet queryExecute(String sql,String[] pars) {
 
  try {
  ps=conn.prepareStatement(sql);
  for(int i=0;i<pars.length;i++) {
   ps.setString(i+1, pars[i]);
  }
  rs=ps.executeQuery();

 } catch (Exception e) {
  // TODO: handle exception
 }
  return rs;
 }
}
