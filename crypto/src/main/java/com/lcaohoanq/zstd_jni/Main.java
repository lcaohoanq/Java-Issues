package com.lcaohoanq.zstd_jni;

import com.github.luben.zstd.Zstd;

public class Main {

    public static void main(String[] args) {
        String originalString = "This is a string to compress and decompress using zstd.";

        byte[] data = originalString.getBytes();
        byte[] compressed = Zstd.compress(data);

        System.out.println("Original string: " + originalString);
        System.out.println("Compressed string: " + new String(compressed));

        byte[] decompressed = Zstd.decompress(compressed, originalString.length());
        System.out.println("Decompressed string: " + new String(decompressed));

    }

}