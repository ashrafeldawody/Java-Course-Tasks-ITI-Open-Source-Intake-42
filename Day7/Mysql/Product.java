import java.sql.*;
import java.util.ArrayList;

public class Product {
    static String tableName = "products";
    private int id;
    public String name;
    public int quantity;
    public double price;
    
    public int getId(){
        return id;
    }
    public Product(){
        
    }
    public Product(String name,int quantity,double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    static DatabaseAccess da = new DatabaseAccess();
    public static ArrayList<Product> getAll() {
        ArrayList<Product> productsArrayList = new ArrayList<Product>();
        String query = "SELECT * FROM " + tableName;
        try (Statement st = da.getConnection().createStatement()) {
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                Product prod = new Product();
                prod.id = result.getInt("id");
                prod.name = result.getString("name");
                prod.quantity = result.getInt("quantity");
                prod.price = result.getDouble("price");
                productsArrayList.add(prod);
            }
            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsArrayList;
    }

    public static ArrayList<Product> getByColumn(String colName, String colValue) {
        ArrayList<Product> productsArrayList = new ArrayList<Product>();
        String query = "SELECT * FROM " + tableName + " WHERE " + colName + " = " + colValue;
        try (Statement st = da.getConnection().createStatement()) {
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                Product prod = new Product();
                prod.id = result.getInt("id");
                prod.name = result.getString("name");
                prod.quantity = result.getInt("quantity");
                prod.price = result.getDouble("price");
                productsArrayList.add(prod);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsArrayList;
    }
    public Product getByID(String id){
        ArrayList<Product> products = getByColumn("id",id);
        if(products.size() > 0){
            this.id = products.get(0).id;
            this.name = products.get(0).name;
            this.quantity = products.get(0).quantity;
            this.price = products.get(0).price;
            return this;
        }
        return null;
    }
    public void insert() {
        String query = "insert into " + tableName +" (name,quantity,price) values(?,?,?)";
        try (PreparedStatement preparedStmt = da.getConnection().prepareStatement(query)) {
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, quantity);
            preparedStmt.setDouble(3, price);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        String query = "update " + tableName +" set name = ?,quantity= ? , price= ? where id = ?";
        try (PreparedStatement preparedStmt = da.getConnection().prepareStatement(query)) {
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, quantity);
            preparedStmt.setDouble(3, price);
            preparedStmt.setInt(4, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete() {
        String query = "DELETE FROM " + tableName +" where id = ?";
        try (PreparedStatement preparedStmt = da.getConnection().prepareStatement(query)) {
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printProduct() {
        System.out.format("%s, %s, %s, %s \n", id, name, quantity, price);
    }
}
