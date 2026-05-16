package com.insurance.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private  JsonUtil(){}

    public static <T> List<T> readList(String filePath, TypeReference<List<T>> typeReference) {
        try {
            File file = new File(filePath);

            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }

            return objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file " + filePath, e);
        }
    }

    public static <T> void writeList(String filePath, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filePath), data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write JSON file " + filePath, e);
        }
    }
}
