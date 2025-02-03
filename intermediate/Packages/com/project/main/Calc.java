package com.project.main;

import com.project.math.CalculationsModule;

class Calc {
    public static void main(String[] args) {

        CalculationsModule cModule = new CalculationsModule();
        System.out.println("Addition: " + cModule.add(10.5, 2.5));
        System.out.println("Substraction: " + cModule.sub(10, 7.5));
        System.out.println("Multiplication: " + cModule.mul(5.5, 5.5));
        System.out.println("Division: " + cModule.div(10, 0));
        System.out.println("Mod: " + cModule.mod(700, 7));
    }
}