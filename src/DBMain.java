import model.BaseDAO;

import java.sql.*;

public class DBMain extends BaseDAO {
    public static void main(String[] args) {
        DBMain dbMain = new DBMain();
        dbMain.initPerson();
        dbMain.insertPerson("nana");
        dbMain.insertPerson("choonsik");
    }

    private void initPerson() {
        String sql = """
                create table person (
                id integer primary key autoincrement, 
                name String
                )
                """;
        try {
            getConn();
            smt = conn.createStatement();

            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
    }

    private int insertPerson(String name) {
        int count = 0;
        String sql = "insert into person(name) values(?)";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, name);
            count = psmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }

        return count;
    }

    private void getCodeName() {
        String sql = "select code, name from country order by code, name";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("code") + "\t");
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }

    }
}
