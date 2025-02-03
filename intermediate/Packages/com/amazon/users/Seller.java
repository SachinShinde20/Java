package com.amazon.users;

import com.amazon.authentication.SellerLogin;

public class Seller {
    public Seller() {
        System.out.println("\nI am a Seller.");
    }

    public static void main(String[] args) {
        new Seller();
        SellerLogin sellerLogin = new SellerLogin();
        sellerLogin.login();
    }
}
