package com.internousdev.ecsite2.util;

import java.sql.Connection;		/*双方向*/
import java.sql.DriverManager;	/*javaとデータベースをつなげるAPIの管理*/
import java.sql.SQLException;

public class DBConnector {
private static String diverName="com.mysql.jdbc.Driver";

private static String url="jdbc:mysql://localhost/ecsite2";
private static String user="root";
private static String password="mysql";

public Connection getConnection(){
	/*null入れないと余計な値が入る*/
	Connection con=null;

try{
	/*JDBCドライバをクラスローダにより読み込んでいる*/
	Class.forName(diverName);
	/*エラーが起きた際に処理するためここに記述
	getConnectionにurl, user, passを入れる
	（）は謎*/
	con=(Connection) DriverManager.getConnection(url, user, password);
}catch(ClassNotFoundException e){
	e.printStackTrace();
}catch(SQLException e){
	e.printStackTrace();
}
return con;
}
}