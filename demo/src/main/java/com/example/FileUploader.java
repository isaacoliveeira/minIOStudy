package com.example;


import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class FileUploader {
  public static void main(String[] args)
      throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      // Create a minioClient with the MinIO server playground, its access key and secret key.
      MinioClient minioClient =
          MinioClient.builder()
              .endpoint("http://192.168.1.138:9000 ")
              .credentials("KKwkr9LVUmLJZFNC8Rnu", "f5REtbVZx3uu9fHRknjNdWi9CA5r9iwdsgErTqBr")
              .build();


      minioClient.uploadObject(
          UploadObjectArgs.builder()
              .bucket("project")
              .object("Amor")
              .filename("C://Users//Isaac Oliveira//Downloads//nos.jpeg")
              .build());
      System.out.println(
          "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
              + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
    } catch (MinioException e) {
      System.out.println("Error occurred: " + e);
      System.out.println("HTTP trace: " + e.httpTrace());
    }
  }
}
