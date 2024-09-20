package com.test;



import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;

import java.util.Arrays;
import java.util.Base64;


public class BAWS3DownloadFileBase64 {


    public static String getContentType(String region,String bucketName, String keyName, String path) {
        S3Client s3 = S3Client.builder()
                .region(Region.AF_SOUTH_1)
                .build();
        HeadObjectRequest objectRequest = HeadObjectRequest.builder()
                .key(keyName)
                .bucket(bucketName)
                .build();
        return s3.headObject(objectRequest).contentType();


    }

    public static String getContentAsBase64(String region,String bucketName, String keyName, String path) {
        S3Client s3 = S3Client.builder()
                .region(Region.AF_SOUTH_1)
                .build();
        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .key(keyName)
                .bucket(bucketName)
                .build();
        byte[] value  = s3.getObjectAsBytes(objectRequest).asByteArray();

        return Base64.getEncoder().encodeToString(value);

    }



}