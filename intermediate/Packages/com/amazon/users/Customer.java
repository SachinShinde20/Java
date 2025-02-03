package com.amazon.users;

import com.amazon.authentication.CustomerLogin;

public class Customer {
    public Customer() {
        System.out.println("\nI am a Customer.");
    }

    public static void main(String[] args) {
        new Customer();
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.login();
    }
}
