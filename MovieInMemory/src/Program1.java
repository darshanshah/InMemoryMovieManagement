import java.io.*;
import java.sql.*;
import java.util.*;

public class Program1 {
	public static void main(String args[]) throws IOException {

		Connection connection;
		Statement queryStatement;

		String url = "jdbc:oracle:thin:@cslabdb:1525:cfedb";

		String Query = "select ename,sal  from empbb02 where pos!='coach' AND pos!='gm'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}

		catch (Exception e) {

			System.out.println("Unit Sit Queries.connectionstructor.Exception:"
					+ e);
		}

		try {

			connection = DriverManager.getConnection(url, "st37", "darshan");
			queryStatement = connection.createStatement();
			ResultSet resultSet = queryStatement.executeQuery(Query);

			ArrayList arrList = new ArrayList();

			System.out.println(" ");
			while (resultSet.next()) {
				String s1 = resultSet.getString("ENAME");
				arrList.add(s1);

				int s2 = resultSet.getInt("SARRLIST");
				System.out.println(s1 + "earns  " + s2);
			}

			System.out.println(" ");

			System.out.println("ArrayList Containts : " + arrList);
			System.out.println(" ");

			BufferedReader getdata = new BufferedReader(new InputStreamReader(
					System.in));

			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(10000);

			boolean done = false;

			while (!done) {

				System.out.println(" Enter a name of a player : ");

				String pname = getdata.readLine();

				if (arrList.contains(pname)) {
					done = true;
					Query = "UPDATE empbb02 SET sarrList=" + randomInt
							+ "WHERE ename='" + pname + "'";

					queryStatement = connection.createStatement();
					ResultSet resultSet1 = queryStatement.executeQuery(Query);

					System.out.println("");
					System.out.println("Sarr List array successfully updated to $"
							+ randomInt + " for " + pname + ".");
				}

				else {
					System.out
							.println(" Employee name not varr List id. Enter varr List id employee name.");
					continue;
				}

			}
		} catch (SQLException e) {
			System.err.println("OOPS" + e.getMessage());
		}
	}

}
