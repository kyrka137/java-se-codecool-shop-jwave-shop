package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.ShopCart;
import com.codecool.shop.model.Supplier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {

    public static ModelAndView renderProducts(Request req, Response res) {
//        ProductDao productDataStore = ProductDaoMem.getInstance();
//        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
//        SupplierDao supplierCategoryStore = SupplierDaoMem.getInstance();
        ProductDaoJdbc productDataStore = new ProductDaoJdbc();
        ProductCategoryDaoJdbc productCategoryDataStore = new ProductCategoryDaoJdbc();
        SupplierDaoJdbc supplierDataStore = new SupplierDaoJdbc();
        ShopCart cart = ShopCart.getInstance();
        List<Product> cartProducts = cart.getAllCarts();



        Map params = new HashMap<>();
        params.put("category", productCategoryDataStore.find(1));

        params.put("cart", cartProducts);

        List<ProductCategory> categories = productCategoryDataStore.getAll();
        params.put("categories", categories);


        params.put("supplier", supplierDataStore.find(1));

        List<Supplier> suppliers = supplierDataStore.getAll();
        params.put("suppliers", suppliers);

        String selectedSupplierName = req.params(":supplierName");
        String selectedCategoryName = req.params(":categoryName");

        if (selectedSupplierName != null) {
            Supplier selectedSupplier = supplierDataStore.find(selectedSupplierName);
            params.put("products", productDataStore.getBy(selectedSupplier));
        } else if (selectedCategoryName != null) {
            ProductCategory selectedCategory = productCategoryDataStore.find(selectedCategoryName);
            params.put("products", productDataStore.getBy(selectedCategory));
        } else {
            params.put("products", productDataStore.getAll());
        }

        return new ModelAndView(params, "product/index");
    }


    public static ModelAndView renderShoppingCarts(Request req, Response res) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        String id = req.params(":id");
        Product newProduct = productDataStore.find(Integer.parseInt(id));

        ShopCart cart = ShopCart.getInstance();
        for (Product carti : cart.getAllCarts()) {
            if (carti.getId() == Integer.parseInt(id))
                return ProductController.renderProducts(req, res);
        }

        cart.addShoppingCart(newProduct);
        return ProductController.renderProducts(req, res);



    }
}

/*
    public static ModelAndView renderShopCart(Request req, Response res) {
        Map params = new HashMap<>();
        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        params.put("cart", shoppingCartDataStore.getAll());
        params.put("TotalPrice", shoppingCartDataStore.getTotal());
        return new ModelAndView(params, "product/cart");
    }


    }
*/









