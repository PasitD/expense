import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnector implements Connector{
    private static String myDriver = "org.sqlite.JDBC";
    private static String url = "jdbc:sqlite:Database.db";

    private static final DBConnector instance = new DBConnector();

    static public DBConnector getInstance() {
        return instance;
    }

    private DBConnector() {}

    @Override
    public ObservableList<History> viewHistory() {
        ObservableList<History> data = FXCollections.observableArrayList();
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(url);
            if (connection != null) {
                String query = "select * from history";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    String money = resultSet.getString("money");
                    String description = resultSet.getString("description");
                    data.add(new History(type, money, description));
                }
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void add(String type, String money, String description) {
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(url);
            if (connection != null) {
                String query = "insert into history (type, money, description) values ('" + type + "' , '" + money + "' , '" + description + "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
            }
            connection.close();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
