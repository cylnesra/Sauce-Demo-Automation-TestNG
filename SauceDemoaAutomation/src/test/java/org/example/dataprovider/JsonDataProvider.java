package org.example.dataprovider;

import org.example.utilities.JsonUtility;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {
    @DataProvider(name = "viaJsonSource")
    public Object[][] getSourceFromJson() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/user_credentials.json";
        JsonUtility jsonUtility = new JsonUtility();
        return jsonUtility.getJsonData(filePath);
    }
}
