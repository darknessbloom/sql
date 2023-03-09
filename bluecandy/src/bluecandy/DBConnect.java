package bluecandy;
import java.sql.*;
public class DBConnect {
	public static Connection makeConnection() {
		String url=
				"jdbc:mysql://localhost:3306/myapp?serverTimezone=Asia/Seoul";
		String id="root";
		String pw="1234";
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//드라이버로딩
			System.out.println("데이터베이스연결중");
			con=DriverManager.getConnection(url,id,pw);//db연결명령
			System.out.println("데이터베이스 연결성공");
		}catch(ClassNotFoundException e) {//com.mysql.cj.jdbc.Driver 로딩시 예외가 발생할때(위치에 없거나..) 실행할 구문
			System.out.println("jdbc 드라이버를 찾지 못했습니다");
			
		}catch(SQLException e){//SQLException e ->SQLException를 줄여서 e로 쓰기
			System.out.println("데이터베이스 연결실패");
			System.out.println(e.getMessage());
		}
		return con;
		
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeConnection();
		/*
		try {
			예외가 발생할 수 있는 명령어
		}
		catch(예외의 종류(객체)){
			위의 예외가 발생시 출력or 명령할 구문
		}
		finally {
			예외 발생 상관없이 무조건 실행할 구문
		}
		
	

	}*/

}
