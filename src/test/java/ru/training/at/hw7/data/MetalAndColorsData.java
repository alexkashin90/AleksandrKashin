package ru.training.at.hw7.data;

import java.util.Arrays;
import java.util.List;

public class MetalAndColorsData {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalAndColorsData(List<Integer> summary, List<String> elements, String color, String metals,
                              List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    private Integer getSum() {
        return getSummary()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public List<String> getExpectedResult() {
        return Arrays.asList(
            "Summary: " + (getSum()),
            "Elements: " + elements.toString().replace("[", "").replace("]", ""),
            "Color: " + color,
            "Metal: " + metals,
            "Vegetables: " + vegetables.toString().replace("[", "").replace("]", "")
        );
    }
}
