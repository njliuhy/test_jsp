<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	try
{
	Connection con;
	Statement stat;
	ResultSet rs;
	
	String userName = "root";
    String userPasswd = "111";
    
    String dbName="BookDB"; 
  //表名 
  String tableName="books"; 
  //联结字符串 
  String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd; 
  
	//String url = "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	Connection conn=DriverManager.getConnection(url); 

    //Class.forName("com.mysql.jdbc.Driver").newInstance();;

    //Connection conn = DriverManager.getConnection(url); 
	
	stat = conn.createStatement();
	stat.executeUpdate("insert into books(id,name,title,price)values('999','TOM','Tomcat',44.5)");
	
	rs = stat.executeQuery("select id, name, title, price from books");
	out.println("<table border=1 width = 400>");
	
	while(rs.next()){
		String col1 = rs.getString(1);
		String col2 = rs.getString(2);
		String col3 = rs.getString(3);
		float col4 = rs.getFloat(4);
		out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"+col3+"</td><td>"+col4+"</td></tr>");
		
	}
	out.println("/table");
	
	stat.execute("delete from books where id = '999'");
	
	//DriverManager.registerDriver(new Driver());
	rs.close();
	stat.close();
	conn.close();
	
}
finally{}


%>
</body>
</html>