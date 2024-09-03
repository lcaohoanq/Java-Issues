package com.lcaohoanq.java13;

public class TextBlock {

    public static void main(String[] args) {

        String JSON_STRING
            = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n"
            + "}";

        String TEXT_BLOCK_JSON = """
            {
                "name" : "Baeldung",
                "website" : "https://www.%s.com/"
            }
            """;

        System.out.println("JSON_STRING: " + JSON_STRING);

        System.out.println("TEXT_BLOCK_JSON: " + TEXT_BLOCK_JSON);

    }

}
