import java.sql.*;
import model.Indexer;
import util.DBConnection;

public class IndexerDAO {

    public Indexer getById(int id) throws Exception {
        String sql = "SELECT * FROM indexer WHERE index_id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Indexer i = new Indexer();
            i.setIndexId(id);
            i.setName(rs.getString("name"));
            i.setValueMin(rs.getFloat("valueMin"));
            i.setValueMax(rs.getFloat("valueMax"));
            return i;
        }
        return null;
    }
}


