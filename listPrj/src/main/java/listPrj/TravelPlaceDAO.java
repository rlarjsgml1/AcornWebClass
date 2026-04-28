package listPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TravelPlaceDAO {

    // Oracle DB 연결
    private Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:testdb",  // DB URL
            "scott",                                // DB 사용자
            "tiger"                                 // 비밀번호
        );
    }

    // 리스트 전체 UPDATE (배치 사용)
    public void updateAll(List<TravelPlace> placeList) {
        String sql = "UPDATE TravelPlace SET latitude = ?, longitude = ?, content = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false); // 트랜잭션 수동 제어

            for (TravelPlace p : placeList) {
                ps.setDouble(1, p.getLatitude());
                ps.setDouble(2, p.getLongitude());
                ps.setString(3, p.getContent());
                ps.setInt(4, p.getId()); // WHERE 조건
                ps.addBatch();
            }

            int[] results = ps.executeBatch();
            conn.commit();

            System.out.println("업데이트 완료: " + results.length + "건");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리스트 전체 INSERT (배치)
    public void insertAll(List<TravelPlace> placeList) {
        String sql = "INSERT INTO TravelPlace(id, latitude, longitude, content) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (TravelPlace p : placeList) {
                ps.setInt(1, p.getId());
                ps.setDouble(2, p.getLatitude());
                ps.setDouble(3, p.getLongitude());
                ps.setString(4, p.getContent());
                ps.addBatch();
            }

            int[] results = ps.executeBatch();
            conn.commit();

            System.out.println("삽입 완료: " + results.length + "건");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
