package view;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) throws Exception {
        //MainView mf = new MainView("航空订票系统");
    	System.out.println(getConnection());
    }
    private static Connection getConnection() throws Exception {
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/m";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "001011";
        Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
    }
}
