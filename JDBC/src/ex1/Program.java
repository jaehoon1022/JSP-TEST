package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost/test01";	// 데이터베이스 호출할 주소
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";		// 쿼리(테이블) 호출
		
		Class.forName("com.mysql.cj.jdbc.Driver");	// 6.0 이후로 cj를 사용
		Connection con = DriverManager.getConnection(url,"root","26543434");	// 연결
		Statement st  = con.createStatement();	// 실행도구
		ResultSet rs = st.executeQuery(sql);	// 쿼리를 함수를 통해 설정, 서버쪽에는 결과의 집함이 만들어짐
												// 그 결과를 사용하기위해서 ResultSet이라는 그릇역할과 커서를 움직일수 있는 도구
		
//		if(rs.next())	// next를 호출했는데 next를 호출할 상황이 아니다.
						// next는 boolean형이므로 만약 쿼리?데이터?가 존재한다면 출력 그렇지않다면 출력하지 않는다.
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
