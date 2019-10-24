package framework;

public class DataDaseTest {
	public static void main(String[] args) {
		Object[][] tableData = UtilityMethos.readDataFromDataBase_Into_TwoDimentionalARRY("select * from testdata");
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
}
