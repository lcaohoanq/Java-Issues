package com.lcaohoanq;

public class Main {

    public static void main(String[] args) {
        String url = "https://github.com/lcaohoanq/Web-Snake-Game-Backend";

        String nameFolder = url.substring(url.lastIndexOf("/") + 1, url.length());

        System.out.println(nameFolder);
    }
}