package com.example.orderservice.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class OrderCodeGenerator {
    private static final Random random = new Random();
    private static final String PREFIX = "ORD";
    private static final String SUFFIX = "END";

    public String generateRandomCode() {
        return String.format("%03d", random.nextInt(1000));
    }

    public String generateRandomCodeWithDate() {
        String date = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
        return generateRandomCode() + "_" + date;
    }

    public String generatePrefixedSuffixedCode() {
        return PREFIX + "_" + generateRandomCode() + "_" + SUFFIX;
    }
}