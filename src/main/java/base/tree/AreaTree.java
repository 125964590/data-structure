package base.tree;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhengyi
 * @date 2018/10/16 11:01 AM
 **/
public class AreaTree {
    /**
     * 数据库连接
     */
    private static Connection connection;

    @BeforeAll
    public static void dataSourceConfig() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.100.210:3307?&useSSL=false");
        config.setUsername("root");
        config.setPassword("huatu2017mysqltest1121");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        connection = ds.getConnection();
    }


    @Test
    public void getAreaList() throws SQLException {
        String sql = "select * from essay.v_essay_area";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Area> areas = new LinkedList<Area>();
        while (resultSet.next()) {
            Area area = new Area();
            area.setId(resultSet.getLong("id"));
            area.setName(resultSet.getString("name"));
            area.setpId(resultSet.getLong("p_id"));
            areas.add(area);
        }
        areas.forEach(System.out::print);
    }


}