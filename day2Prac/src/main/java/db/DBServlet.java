package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movieDB")
public class DBServlet  extends  HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter   out  =resp.getWriter();
		
		
		//
		
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String  password="tiger";
		
		
		//
		try {
			Class.forName(driver);
			Connection con  = DriverManager.getConnection(url, user, password);
			Statement  st  = con.createStatement();
			
			String sql=" select  * from  movie " ;
			
			ResultSet rs =st.executeQuery(sql);
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			
			while( rs.next()) {
				
				
				out.println(rs.getString(1));
				out.println(rs.getString(2) +"<br>");
				
				
			}
			
			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
