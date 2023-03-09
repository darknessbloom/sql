package bluecandy;

import java.sql.Connection;//연결된 데이터베이스 객체를 가리키는 객체
import java.sql.PreparedStatement;//sql문을 실행시키기위한 객체
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PhoneBook {
	static Connection con=DBConnect.makeConnection();
	static PreparedStatement ps =null;
	static ResultSet rs = null;//select한  결과를 리턴받는 객체
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		select();
		insert();
		select();
		

	}
	public static void select() {
		if(con != null) {
			String sql="select * from person";
			try {
				ps = con.prepareStatement(sql);//prepareStatement-> 메서드
				rs= ps.executeQuery();//select실행시 ->테이블 변화 없음
				//ps.executeUpdate();//insert,delete,update 실행시 ->테이블 변화줌
				System.out.println("==========phonebook==========");
				System.out.println("이름"+"\t"+"전화번호"+"\t"+"이메일"+"\t"+"나이"+"\t");
				while(rs.next()==true)
					System.out.println(rs.getString("name")+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt("age"));//첫번재부터 차례로 가리키는 메서드 sql 인덱스는 1번 부터
					//System.out.println(rs.getRow());열번호만 나옴..
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ps 객체생성 오류");
				e.printStackTrace();//추적정보출력
			}
			
		}
		
	}
	public static void insert() {
		Scanner in=new Scanner(System.in);
		if(con != null) {
			System.out.println("추가할 정보를 입력 이름 전화번호 이메일 나이순");
			String n=in.nextLine();
			String p=in.nextLine();
			String e=in.nextLine();
			int a=in.nextInt();
			String sql="insert into person values(?,?,?,?)";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,n);
				ps.setString(2,p);
				ps.setString(3,e);
				ps.setInt(4,a);
				ps.executeUpdate();
				
				
			}catch(SQLException ex){
				System.out.println("추가 실패");
				ex.printStackTrace();
				
			}
		}
		
		
	}

}
