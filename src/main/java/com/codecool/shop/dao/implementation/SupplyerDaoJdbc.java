package com.codecool.shop.dao.implementation;

/**
 * Created by gabor on 2017.05.08..
 */
//public class SupplyerDaoJdbc implements SupplierDao {
//
//    private static final String DATABASE = "jdbc:postgresql://localhost:5432/codecoolshop";
//    private static final String DB_USER = "gabor";
//    private static final String DB_PASSWORD = "gabor";
//
//    @Override
//    public void add(Supplier supplier) {
//
//        String query = "INSERT INTO supplier (name, id) VALUES(?, ?) ";
//
//
//        try {
//            PreparedStatement stmt = getConnection().prepareStatement(query);
//            stmt.setString(1, supplier.getName());
//            stmt.setInt(2, supplier.getId());
//            //stmt.setString(3, supplier.status==Status.ACTIVE?"ACTIVE":"COMPLETED");
//            stmt.executeQuery();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//    @Override
//    public Supplier find(String id) {
//
//        String query = "SELECT * FROM codecoolshop WHERE id = ?";
//
//
//        try (Connection connection = getConnection();
//
//        ) {
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Supplier result = new Supplier(resultSet.getString("name"),
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"));
//                return result;
//            } else {
//                return null;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public void remove(String id) {
//        String query = "DELETE FROM suppliers WHERE id = '" + id +"';";
//        executeQuery(query);
//    }
//
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(
//                DATABASE,
//                DB_USER,
//                DB_PASSWORD);
//    }
//
//
//    private void executeQuery(String query) {
//
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();
//        ) {
//            statement.execute(query);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
