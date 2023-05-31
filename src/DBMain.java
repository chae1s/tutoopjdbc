import java.sql.*;

public class DBMain {
    public static void main(String[] args) {
        String sql = "select code, name from country order by code, name";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:world.db");
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString("code") + " ");
                System.out.println(rs.getString("name"));
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
