package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection
					("jdbc:mysql://localhost:3306/test","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select  * from testdata where FIRST_NAME = 'NARESH'");
			while(rs.next()) {
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+(rs.getObject(3)+"\t"+rs.getObject(4)));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
