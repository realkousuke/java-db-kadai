package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement statement = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"Kousuke516!"
				);
			
			System.out.println("データベース接続成功");
			
			String dropSql = "DROP TABLE IF EXISTS employees";
			statement = con.createStatement();
			String sql = """
						CREATE TABLE employees (
						id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
						nama VARCHAR(60) NOT NULL,
						email VARCHAR(255),
						age INT(11),
						address VARCHAR(255)
						);
					    """;
			
			int rowCnt = statement.executeUpdate(sql);
			System.out.println("社員テーブルを作成しました:更新レコード数=" + rowCnt);
		} catch(SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if( statement != null ) {
				try { statement.close(); } catch(SQLException ignore) {}
			}
			if( con != null ) {
				try { con.close(); } catch(SQLException ignore) {}
			}
		}
	}
}
