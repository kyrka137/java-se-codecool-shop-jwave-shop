package com.codecool.shop.model;

/**
 * Created by zahoranszky on 2017.04.27..
 */
import java.util.List;
import java.util.Scanner;


/**
 * The type Ui.
 */
public class UI {

    /**
     * The Cart.
     */
    Cart cart = new Cart();
    private int ch = 0;

    /**
     * Instantiates a new Ui.
     */
    public UI() {
        menu();
    }

    /**
     * Start screen.
     */
    public void startScreen () {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");
    }

    /**
     * Store products menu.
     */
    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }

    /**
     * Menu.
     */
    public void menu () {
        do {
            startScreen();
            getUserInput();

            switch (ch) {
                case 1:
                    displayStoreProducts();
                    storeProductsMenu();
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (ch != 0);
    }

    private void innerChoice1() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:

                break;
        }
    }

    private int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    private void displayStoreProducts() {
        List<Pro> products = new Products().getProducts();
        for (Pro prod: products) {
            System.out.println(
                    prod.getPid() + "- " +
                            prod.getName() + " " +
                            prod.getPrice() + " " +
                            prod.getStock()
            );
        }
    }

    private void addProductToCart() {
        int pid = getUserInput();
        cart.addProductToCartByPID(pid);
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProductByPID(pid);
    }


}
