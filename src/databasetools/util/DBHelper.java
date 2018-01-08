package databasetools.util;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库操作类
 */
public class DBHelper {
    
    private static final Logger LOG = LoggerFactory.getLogger(DBHelper.class);
    
    private static final String Oracle_FDRIVER = Config_Util.getProperty("Oracle.jdbc.Fdriver", Constants.CONFIG_JDBC);
   
    private static final String Oracle_FURL = Config_Util.getProperty("Oracle.jdbc.Furl", Constants.CONFIG_JDBC);
    
    private static final String Oracle_FUSERNAME = Config_Util.getProperty("Oracle.jdbc.Fusername", Constants.CONFIG_JDBC);
    
    private static final String Oracle_FPASSWORD = Config_Util.getProperty("Oracle.jdbc.Fpassword", Constants.CONFIG_JDBC);
    
    
    private static final String Oracle_TDRIVER = Config_Util.getProperty("Oracle.jdbc.Tdriver", Constants.CONFIG_JDBC);
    
    private static final String Oracle_TURL = Config_Util.getProperty("Oracle.jdbc.Turl", Constants.CONFIG_JDBC);
    
    private static final String Oracle_TUSERNAME = Config_Util.getProperty("Oracle.jdbc.Tusername", Constants.CONFIG_JDBC);
    
    private static final String Oracle_TPASSWORD = Config_Util.getProperty("Oracle.jdbc.Tpassword", Constants.CONFIG_JDBC);
    
    
    private static final String Oracle_DDRIVER = Config_Util.getProperty("Oracle.jdbc.Ddriver", Constants.CONFIG_JDBC);
    
    private static final String Oracle_DURL = Config_Util.getProperty("Oracle.jdbc.Durl", Constants.CONFIG_JDBC);
    
    private static final String Oracle_DUSERNAME = Config_Util.getProperty("Oracle.jdbc.Dusername", Constants.CONFIG_JDBC);
    
    private static final String Oracle_DPASSWORD = Config_Util.getProperty("Oracle.jdbc.Dpassword", Constants.CONFIG_JDBC);
    
    
    private static final String MySql_DRIVER = Config_Util.getProperty("MySql.jdbc.driver", Constants.CONFIG_JDBC);
    
    private static final String MySql_URL = Config_Util.getProperty("MySql.jdbc.url", Constants.CONFIG_JDBC);
    
    private static final String MySql_USERNAME = Config_Util.getProperty("MySql.jdbc.username", Constants.CONFIG_JDBC);
    
    private static final String MySql_PASSWORD = Config_Util.getProperty("MySql.jdbc.password", Constants.CONFIG_JDBC);
   
    private static Connection con;
 
    private static Statement sm;
    
    /**
     * 执行数据库操作
     * @param sql
     * @param type
     * @return
     * @throws SQLException 
     */
    private static int executeUpdate(String DataVersion, String sql) throws SQLException{
    	checkConnection_Oracle(DataVersion);
        PreparedStatement ps = null;
        LOG.info("Sql: " + sql);
        try {
            ps = con.prepareStatement(sql);
            int result = ps.executeUpdate();
            LOG.info("Result: " + result);
            return result;
        } catch (SQLException e) {
            LOG.error("失败", e.fillInStackTrace());
        } finally {
        	ps.close();
        }
        return -1;
    }
    
    public static boolean logincompare(String DataVersion, String username){
	    boolean m = false;
	    String sql = "select id from dafy_sales.sys_user_list where id="+ username +"";
	    try{
	    	checkConnection_Oracle(DataVersion);
	        ResultSet rs = sm.executeQuery(sql);
	        if(rs.next()){
	            String pa = rs.getString(1);
	            System.out.println(pa + " " + username);
	            if(pa.equals(username)){
	                m = true;
	            }else {
	                   JOptionPane.showMessageDialog(null, "密码错误！");
	            }
	        }else {
	               JOptionPane.showMessageDialog(null, "用户名不存在！");
	        }
	        close(sm,rs);
	    }catch(SQLException e){
	        e.printStackTrace();
	    }   
	    return m;
	}
 
    static void checkConnection_Oracle(String DataVersion){
        try {
            if(con == null || con.isClosed())
            	connect_Oracle(DataVersion);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    private static void checkConnection_MySql(){
        try {
            if(con == null || con.isClosed())
            	connect_MySql();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e.fillInStackTrace());
        }
    }
    
    /**
     * 连接Oracle数据库
     * @throws Exception
     */
    public static void connect_Oracle(String DataVersion) throws Exception{
        try {
        	if("正式版本".equals(DataVersion)){
	    	    Class.forName(Oracle_FDRIVER);
	    	    con = DriverManager.getConnection(Oracle_FURL, Oracle_FUSERNAME, Oracle_FPASSWORD); 
	    	    sm = con.createStatement();
	    	}
	    	if("测试版本".equals(DataVersion)){
	    		Class.forName(Oracle_TDRIVER);
	    	    con = DriverManager.getConnection(Oracle_TURL, Oracle_TUSERNAME, Oracle_TPASSWORD); 
	    	    sm = con.createStatement();
		    }
	    	if("开发版本".equals(DataVersion)){
	    		Class.forName(Oracle_DDRIVER);
	    	    con = DriverManager.getConnection(Oracle_DURL, Oracle_DUSERNAME, Oracle_DPASSWORD); 
	    	    sm = con.createStatement();
		    }
            LOG.info("数据库连接成功");
        } catch (Exception e) {
            String message = "数据库连接失败";
            if(e instanceof ClassNotFoundException)
                message = "数据库驱动类未找到";
            throw new Exception(message, e.fillInStackTrace());
        } 
    }
    
    /**
     * 连接MySql数据库
     * @throws Exception
     */
    public static void connect_MySql() throws Exception{
        try {
            Class.forName(MySql_DRIVER);
            con = DriverManager.getConnection(MySql_URL, MySql_USERNAME, MySql_PASSWORD);
            LOG.info("数据库连接成功");
        } catch (Exception e) {
            String message = "数据库连接失败";
            if(e instanceof ClassNotFoundException)
                message = "数据库驱动类未找到";
            throw new Exception(message, e.fillInStackTrace());
        } 
    }
     
    /**
     * 释放资源并关闭数据库
     */
    public static void close(Statement sm, ResultSet rs){
    	try {
    		if(sm != null){
                sm.close();
                sm = null;
            }
            if(rs != null){
                rs.close();
                rs = null;
            }  
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("数据库资源释放失败！");
        }
        try {
            if(con != null && !con.isClosed())
            	con.close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接关闭失败！");
        }
    }


}
