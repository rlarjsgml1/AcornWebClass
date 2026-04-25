package day05Prac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import day05Prac.dto.Acorn;

public class AcornDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	// lib->ojdbc8.jar 두기 ( 오라클이 제공하는 데이터베이스연동 라이브러리)
	//
	public Connection dbcon() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	// 전체조회하기 selectAll
	// 데이터베이스 조회결과 -> ArrayList<Acorn>으로 만들고 반환하기

	public ArrayList<Acorn> selectAll() {
		ArrayList<Acorn> list = new ArrayList<>();

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from acorntbl ";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			// 데이터베이스 조회결과 -> ArrayList<Acorn>으로 만들고 반환하기
			while (rs.next()) { // rs => 조회결과 하나의 행 정보를 가지고 있다
				System.out.println(rs.getString(1));

				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date birth = rs.getDate(5); //

				// n(String id, String pw, String name, int point, Date birth) {

				Acorn acorn = new Acorn(id, pw, name, point, birth);
				list.add(acorn);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;

	}

	// 등록
	public int insert(Acorn acorn) { // acorn => 데이터베이스 등록 insert
		Connection con = dbcon();
		String sql = "insert into acorntbl(id,pw,name,point,birthday) values(?,?,?,?,?)";

		PreparedStatement pst = null;
		int rowCnt = 0;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());
			pst.setInt(4, acorn.getPoint());
			// util.Date => sql.Date 변환하
			java.sql.Date sqlBirth = new java.sql.Date(acorn.getBirth().getTime());
			pst.setDate(5, sqlBirth);

			rowCnt = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rowCnt;

	}

	public Acorn findById(String id) {
		Connection con = dbcon();
		String sql = "select * from acorntbl where id = ?"; // 수정

		PreparedStatement pst = null;
		ResultSet rs = null;
		Acorn acorn = null;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				String tid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date birth = rs.getDate(5);

				acorn = new Acorn();
				acorn.setId(tid);
				acorn.setPw(pw);
				acorn.setPoint(point);
				acorn.setName(name);
				acorn.setBirth(birth);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (pst != null)
					pst.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}

		return acorn;
	}

	// 변경

	public int update(Acorn acorn) {
		Connection con = dbcon();
		String sql = "update acorntbl set pw = ?, point = ? where id = ?";
		PreparedStatement pst = null;
		int rowCnt = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getPw());
			pst.setInt(2, acorn.getPoint());
			pst.setString(3, acorn.getId());
			rowCnt = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return rowCnt;
	}

	// 삭제하기

	public int delete(String id) {
		Connection con = dbcon();
		String sql = "delete from acorntbl where id = ?"; // 수정
		PreparedStatement pst = null;
		int rowCnt = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rowCnt = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rowCnt;
	}

	public static void main(String[] args) {
		AcornDAO dao = new AcornDAO();
//		Connection con  =dao.dbcon();
//		System.out.println(con);  //  dkdkdkkdk@1212551
//		if( con != null)  System.out.println("ok");

//		ArrayList<Acorn> list = dao.selectAll();
//		System.out.println(list);
//		Acorn acorn = new Acorn();
//		acorn.setId("test0421");
//		acorn.setPw("1234");
//		acorn.setName("t0410");
//		acorn.setPoint(50000);
//		// String -> Date
//
//		Date birthDate = null;
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			birthDate = df.parse("2000-10-10");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		acorn.setBirth(birthDate);
//		
//		int r = dao.insert(acorn);
//		System.out.println(r);

//		Acorn acorn = dao.findById("victoai");
//		System.out.println(acorn);

//		Acorn acorn = new Acorn();
//		acorn.setId("victoai");
//		acorn.setPw("5555");
//		acorn.setPoint(9000);
//		
//		int rowCnt = dao.update(acorn);
//		System.out.println(rowCnt);

//		int rowCnt = dao.delete("test0421");
//		System.out.println(rowCnt);

	}

}
