package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import framework.UtilityMethos;

public class DataBaseTest {
	public static void main(String[] args) {
		Object[][] tableData = 
				UtilityMethos.readDataFromDataBase_Into_TwoDimentionalARRY
				("select * from testdata");
		for (int rowCount = 0; rowCount < tableData.length; rowCount++) {
			for (int columnCount = 0; columnCount < tableData.length; columnCount++) {
				if (tableData[rowCount][columnCount] != null) {		
					if (columnCount==0 && rowCount !=0) {
						System.out.println();
					}
					System.out.print(tableData[rowCount][columnCount]+"\t");
				}else {
					break ;
				}
			}
		}
	}
	public static Object[][] readDataFromDataBase_Into_TwoDimentionalARRY(String query) {
		Object[][] tableData = new Object[10][10];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost:3306/test", "root","root");
			Statement stmt = (Statement) con.createStatement();
		
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			int rowCount = 0;
			while (rs.next()) {
				int count = rs.getMetaData().getColumnCount() - 1;
				for (int columnCount = 0; columnCount <= count; columnCount++) {
					tableData[rowCount][columnCount] = rs.getString(columnCount + 1);
				}
				rowCount++;
			}
			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return tableData;
	}

}
