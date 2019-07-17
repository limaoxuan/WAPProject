package dao;

import model.AdminUser;
import model.BookingList;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private static DataBase dataBase;
    private HashMap<String, User> users;
    private HashMap<String, ArrayList<BookingList>> shoppingCarts = new HashMap<>();
    private ArrayList<Product> products;
    private int productIndex = 4;

    private HashMap<String, AdminUser> adminUsers;

    public ArrayList<Product> getProducts() {
        return products;
    }

    private DataBase() {

    }

    public static DataBase getDataBaseInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
            dataBase.initUserData();
            dataBase.initProductsData();
            dataBase.addAdminUsers();
        }

        return dataBase;
    }


    public void addUserShoppingCart(String username, BookingList bookingList) {

        ArrayList<BookingList> carts = null;
        if (!shoppingCarts.containsKey(username)) {
            carts = new ArrayList<>();
        } else {
            carts = shoppingCarts.get(username);
        }
        carts.add(bookingList);
        shoppingCarts.put(username, carts);
    }

    public void updateUserShoppingCart(String username, BookingList bookingList) {
        ArrayList<BookingList> carts = null;
        if (!shoppingCarts.containsKey(username)) {
            carts = new ArrayList<>();
        } else {
            carts = shoppingCarts.get(username);
        }

        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getProduct().getId().equals(bookingList.getProduct().getId())) {
                carts.get(i).setNumber(bookingList.getNumber());
                carts.get(i).setProduct(bookingList.getProduct());
                break;
            }
        }
    }

    public void deleteUserShoppingCart(String username, BookingList bookingList) {

        ArrayList<BookingList> carts = null;
        if (!shoppingCarts.containsKey(username)) {
            carts = new ArrayList<>();
        } else {
            carts = shoppingCarts.get(username);
        }

        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getProduct().getId().equals(bookingList.getProduct().getId())) {
                carts.remove(i);
                break;
            }
        }
    }

    public ArrayList<BookingList> getUserShoppingCart(String username) {

        ArrayList<BookingList> carts = null;
        if (!shoppingCarts.containsKey(username)) {
            carts = new ArrayList<>();
        } else {
            carts = shoppingCarts.get(username);
        }
        return carts;
    }


    private void initProductsData() {
        products = new ArrayList<>();
        Product product = new Product("1", "The Three-Body Problem",
                "(Remembrance of Earth's Past Book 1) ", 27.49, "https://images-na.ssl-images-amazon.com/images/I/51c6PKzjPLL.jpg");
        Product product1 = new Product("2", "The Dark Forest",
                "(Remembrance of Earth's Past Book 2) Kindle Edition", 14.97,
                "https://images-na.ssl-images-amazon.com/images/I/51IUteV-e7L.jpg");
        Product product2 = new Product("3", "The Redemption of Time",
                "Remembrance of Earth's Past Book 4", 22.98, "https://images-na.ssl-images-amazon.com/images/I/51wBNTyBhaL.jpg");
        products.add(product);
        products.add(product1);
        products.add(product2);
//        product.ad
    }

    public void addProduct(Product product) {
        product.setId(String.valueOf(productIndex));
        products.add(product);
        productIndex++;
    }

    public void removeProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                break;
            }
        }
    }

    public void updateProduct(Product upProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(upProduct.getId())) {
                products.set(i, upProduct);
                break;
            }
        }
    }


    private void initUserData() {
        users = new HashMap<>();
        User user = new User("max", "123");
        User user1 = new User("lex", "123");
        users.put(user.getUsername(), user);
        users.put(user1.getUsername(), user1);
    }

    public void addUser(String username, String password){
        User user = new User(username, password);
        users.put(username, user);
    }

    private void addAdminUsers() {
        adminUsers = new HashMap<>();
        AdminUser admin1 = new AdminUser("admin", "123");
        AdminUser admin2 = new AdminUser("xyz", "456");
        adminUsers.put(admin1.getLoginName(), admin1);
        adminUsers.put(admin2.getLoginName(), admin2);
    }

    public HashMap<String, AdminUser> getAdminUsers() {
        return adminUsers;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
