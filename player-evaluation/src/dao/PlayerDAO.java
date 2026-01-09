import java.sql.*;
import java.util.*;
import model.Player;
import util.DBConnection;

public class PlayerDAO {

    public void insert(Player p) throws Exception {
        String sql = "INSERT INTO player(name, full_name, age, index_id) VALUES (?,?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getFullName());
        ps.setInt(3, p.getAge());
        ps.setInt(4, p.getIndexId());
        ps.executeUpdate();
    }

    public List<Player> getAll() throws Exception {
        List<Player> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM player");

        while (rs.next()) {
            Player p = new Player();
            p.setPlayerId(rs.getInt("player_id"));
            p.setName(rs.getString("name"));
            p.setFullName(rs.getString("full_name"));
            p.setAge(rs.getInt("age"));
            p.setIndexId(rs.getInt("index_id"));
            list.add(p);
        }
        return list;
    }

    public Player getById(int id) throws Exception {
        String sql = "SELECT * FROM player WHERE player_id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Player p = new Player();
            p.setPlayerId(id);
            p.setName(rs.getString("name"));
            p.setFullName(rs.getString("full_name"));
            p.setAge(rs.getInt("age"));
            p.setIndexId(rs.getInt("index_id"));
            return p;
        }
        return null;
    }

    public void update(Player p) throws Exception {
        String sql = "UPDATE player SET name=?, full_name=?, age=?, index_id=? WHERE player_id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getFullName());
        ps.setInt(3, p.getAge());
        ps.setInt(4, p.getIndexId());
        ps.setInt(5, p.getPlayerId());
        ps.executeUpdate();
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM player WHERE player_id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
