package ru.training.at.hw7.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class MetalAndColorsPageDataProvider {

    @DataProvider(name = "MetalAndColorsPageTestData")
    public static Object[][] getTestData() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseReader(
            new FileReader(TestData.PATH_TO_TEST_DATA))
                                          .getAsJsonObject();
        List<MetalAndColorsData> dataValues = jsonObject.keySet().stream()
            .map(key -> gson.fromJson(jsonObject.get(key), MetalAndColorsData.class))
            .collect(Collectors.toList());
        return dataValues.stream().map(value -> new MetalAndColorsData[]{value})
                         .toArray(Object[][]::new);
    }
}
