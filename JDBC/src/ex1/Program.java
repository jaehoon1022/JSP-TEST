package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost/test01";	// �����ͺ��̽� ȣ���� �ּ�
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";		// ����(���̺�) ȣ��
		
		Class.forName("com.mysql.cj.jdbc.Driver");	// 6.0 ���ķ� cj�� ���
		Connection con = DriverManager.getConnection(url,"root","26543434");	// ����
		Statement st  = con.createStatement();	// ���൵��
		ResultSet rs = st.executeQuery(sql);	// ������ �Լ��� ���� ����, �����ʿ��� ����� ������ �������
												// �� ����� ����ϱ����ؼ� ResultSet�̶�� �׸����Ұ� Ŀ���� �����ϼ� �ִ� ����
		
//		if(rs.next())	// next�� ȣ���ߴµ� next�� ȣ���� ��Ȳ�� �ƴϴ�.
						// next�� boolean���̹Ƿ� ���� ����?������?�� �����Ѵٸ� ��� �׷����ʴٸ� ������� �ʴ´�.
		while(rs.next())
		{
		int id = rs.getInt("ID");	
		String title = rs.getString("TITLE");
		String writerId = rs.getString("WRITER_ID");
		Date regDate = rs.getDate("REGDATE");
		String content = rs.getString("CONTENT");
		int hit = rs.getInt("HIT");
		
		System.out.printf("id: %d, title: %s, writerId: %s, redDate: %s, content: %s, hit: %d\n"
				,id,title,writerId,regDate,content,hit);
		
//		System.out.println(title);
//		System.out.printf("NAME:%s\n",name);
		}
		rs.close();
		st.close();
		con.close();
		
	}

}
