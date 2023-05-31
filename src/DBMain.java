import java.sql.*;

public class DBMain {
    public static void main(String[] args) {
        String sql = "select 1 + 1 as result";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("result"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
