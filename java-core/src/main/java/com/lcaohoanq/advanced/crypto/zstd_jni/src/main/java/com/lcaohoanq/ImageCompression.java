package com.lcaohoanq.advanced.crypto.zstd_jni.src.main.java.com.lcaohoanq;

import com.github.luben.zstd.Zstd;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ImageCompression {

    public static void main(String[] args) {
        String originalImagePath = "src/main/resources/dontopenthis.png";
        String compressedImagePath = "src/main/resources/compression/image.zst";
        String decompressedImagePath = "src/main/resources/decompression/image.jpg";

        try {
            // Read the original image
            byte[] originalData = Files.readAllBytes(Paths.get(originalImagePath));

            // Compress the image data
            byte[] compressedData = Zstd.compress(originalData);
            Files.write(Paths.get(compressedImagePath), compressedData);

            // Decompress the image data
            byte[] decompressedData = Zstd.decompress(compressedData, originalData.length);
            Files.write(Paths.get(decompressedImagePath), decompressedData);

            System.out.println("Compression and decompression completed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}