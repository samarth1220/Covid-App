package com.defiance.confine;

import java.util.Arrays;
import java.util.List;

public class FoodAvoid {

    public List<String> diarrhoea = Arrays.asList(
            "Milk and Dairy Products",
            "Spicy Foods",
            "Processed foods, especially those with Additive foods",
            "Pork and veal",
            "Sardines",
            "Raw Vegetables",
            "Onions",
            "Corn",
            "All Citrus Fruits",
            "Coffee, Soda and other caffeinated or carbonated drink"
    );
    public List<String> diabetes = Arrays.asList(
            "Sugar-sweetened beverages",
            "Trans Fat",
            "White Bread, Pasta, Rice",
            "Flavoured Yogurt",
            "Sweetened Breakfast Cereal",
            "Flavoured or Carbonated drnks",
            "Honey, Maple syrup, Nectar",
            "Packed Snacks",
            "Red Meat",
            "Processed meat or poultry"
    );

    public List<String> hypertension = Arrays.asList(
            "Salt",
            "Pickles",
            "Deli Meat",
            "Canned Products",
            "Sugar",
            "Trans Fat and Saturated Fat",
            "Alcohol",
            "Sauces and condiments",
            "Caffeine",
            "High Fat food"
    );
    public List<String> heart = Arrays.asList(
            "Coconut",
            "Full-Fat Milk",
            "Meat",
            "Trans Fat and Saturated fat",
            "Canned Fruit",
            "High fat snacks"
    );
    public List<String> kidney = Arrays.asList(
            "Colored Soda",
            "Avocado",
            "Canned Food",
            "Whole wheat bread",
            "Brown rice",
            "Banana",
            "Dairy Products",
            "Orange",
            "Processed Meat",
            "Pickles, Olives",
            "Apricot"
    );
    public List<String> liver = Arrays.asList(
            "Alcohol",
            "Fried Food",
            "Salt",
            "White Bread, rice and pasta",
            "Red Meat",
            "Refined carbs",
            "Sugar",
            "Poultry",
            "Saturated Food"
    );
    public List<String> immune = Arrays.asList(
            "Meat",
            "Fish",
            "Eggs",
            "Unpasteurized Beverages",
            "Soft Mold-ripened and Blue-Veined Cheese"
    );
    public List<String> lungs = Arrays.asList(
            "Cured Meat",
            "Excessive Salt",
            "Dairy Products",
            "Cruciferous Vegetables",
            "Fried Food",
            "Carbonated Beverages",
            "Acidic food and drinks"
    );

    public List<String> getDiarrhoea() {
        return diarrhoea;
    }

    public List<String> getDiabetes() {
        return diabetes;
    }

    public List<String> getHypertension() {
        return hypertension;
    }

    public List<String> getHeart() {
        return heart;
    }

    public List<String> getKidney() {
        return kidney;
    }

    public List<String> getLiver() {
        return liver;
    }

    public List<String> getImmune() {
        return immune;
    }

    public List<String> getLungs() {
        return lungs;
    }
}
