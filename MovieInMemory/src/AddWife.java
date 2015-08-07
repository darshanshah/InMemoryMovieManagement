import java.io.*;
import java.util.*;
import java.sql.*;

public class AddWife {
	static BufferedReader getData = new BufferedReader(new InputStreamReader(
			System.in));

	static String wife, empName;

	public static void main(String[] aa) throws IOException {
		String url;
		url = "jdbc:oracle:thin:@130.191.28.142:1525:cfedb";

		Connection conn;

		try { // invoke oracle thin driver; register it with DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("Unit Sit Queries.constructor.Exception: " + e);
		}
		try {
			conn = DriverManager.getConnection(url, "st37", "darshan");
			// establish connection to DBMS or database

			PreparedStatement pstmt = conn
					.prepareStatement("update infobb02 set WIFE=? where FNAME = ?"); // creates
																						// object
			// from which SQL commands can be sent to the DBMS

			boolean isSccess = false;
			while (!isSccess) {
				gimmeData();
				if (empName.equals("null")) {
					isSccess = true;

				}

				pstmt.setString(1, wife);
				pstmt.setString(2, empName);

				pstmt.executeUpdate();

			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("OOPS " + e.getMessage());
		}
	}

	static void gimmeData() throws IOException {
		System.out.println("Enter Name of Employee : ");
		empName = getData.readLine();

		if (!empName.equals("null")) {
			System.out.println("Enter Name of wife : ");
			wife = getData.readLine();

		}
	}
}
