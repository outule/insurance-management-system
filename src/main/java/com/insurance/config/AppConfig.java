package com.insurance.config;

public class AppConfig {

    private static final String BASE_DATA_PATH = "src/main/resources/data/";

    private AppConfig() {}

    public static String getClientsFilePath() {
        return BASE_DATA_PATH + "clients.json";
    }

    public static String getPoliciesFilePath() {
        return BASE_DATA_PATH + "policies.json";
    }

    public static String getClaimsFilePath() {
        return BASE_DATA_PATH + "claims.json";
    }

    public static String getPaymentsFilePath() {
        return BASE_DATA_PATH + "payments.json";
    }

    public static String getAdminsFilePath(String id) {
        return BASE_DATA_PATH + "admins.json";
    }
}
