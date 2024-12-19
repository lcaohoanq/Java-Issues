package com.lcaohoanq.advanced.crypto.PBKDF2.src.main.java;

public class Main {

    public static void main(String[] args) {
        String password = "Iloveyou123!";

        PBKDF2 pbkdf2 = new PBKDF2();

        String hashed = pbkdf2.hash(password.toCharArray());

        System.out.println("Hashed password: " + hashed); //$31$16$8oXu-hMTX4bjO0DAZHWTDfQQle_cQVs6f9bTqYJV3kg

        boolean matched = pbkdf2.authenticate(password.toCharArray(), hashed);

        System.out.println("Password matched: " + matched); //true
    }

}
