package com.lcaohoanq.jdbc.maven.mysql;

public class Main {
    public static void main(String[] args) {
        DatabaseQuery dbQuery = new DatabaseQuery();
        dbQuery.selectUsernameAndScore().forEach(System.out::println);
    }
}
