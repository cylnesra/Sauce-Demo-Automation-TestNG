package org.example.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtility {
    public Object[][] getJsonData(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Object> dataList = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });

            Object[][] dataArray = new Object[dataList.size()][1];
            for (int i = 0; i < dataList.size(); i++) {
                dataArray[i][0] = dataList.get(i);
            }
            return dataArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
