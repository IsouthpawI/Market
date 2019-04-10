package sk.itsovy.projectMarket.Database;

import sk.itsovy.projectMarket.main.Global;
import sk.itsovy.projectMarket.bill.Bill;
import sk.itsovy.projectMarket.items.*;
import sk.itsovy.projectMarket.interfaces.*;

import java.sql.*;

public class Database {

    private static Database db = new Database();

    private Database() {

    }

    public static Database getInstance() {

        return db;
    }

    public void insertNewBill(Bill bill) throws SQLException {
        Connection conn = Global.getConnection();

        try {
            sqlPreparedStatement = conn.prepareStatement("INSERT INTO Bill (Date, TotalPrice) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            statement.setDate(1, new java.sql.Date(bill.getDate().getTime()));
            statement.setDouble(2, (Double) bill.getFinalPrice());

            statement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
            conn.close();
        }
    }
}