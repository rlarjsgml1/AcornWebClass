package day02;

 

 

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {

    String URL = "jdbc:oracle:thin:@localhost:1521:testdb";
    String USER = "scott";
    String PASSWORD = "tiger";

    public ArrayList<Movie2> selectAll() {

        ArrayList<Movie2> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM MOVIE";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String genre = rs.getString("GENRE");
                int duration = rs.getInt("DURATION");

                Movie2 movie = new Movie2(id, title, genre, duration);
                list.add(movie);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}