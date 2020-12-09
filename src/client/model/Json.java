package client.model;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import shared.transferObjects.AccountRelated.Account;
import shared.transferObjects.OrderRelated.Order;
import shared.transferObjects.RecipeRelated.Category;
import shared.transferObjects.RecipeRelated.Ingredient;
import shared.transferObjects.RecipeRelated.Recipe;
import shared.transferObjects.ShopRelated.Shop;
import shared.transferObjects.ShopRelated.ShopIngredient;

import java.io.IOException;
import java.util.List;

public class Json {
    private final static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultobjectMapper = new ObjectMapper();
        defaultobjectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultobjectMapper;
    }

    public static List<Account> parseAccountList(String src) throws IOException{
        TypeReference<List<Account>> mapType = new TypeReference<List<Account>>() {};
        List<Account> accounts = objectMapper.readValue(src,mapType);
        return accounts;
    }

    public static List<Ingredient> parseIngredientList(String src) throws IOException{
        TypeReference<List<Ingredient>> mapType = new TypeReference<List<Ingredient>>() {};
        List<Ingredient> ingredients = objectMapper.readValue(src,mapType);
        return ingredients;
    }

    public static List<Recipe> parseRecipeList(String src) throws IOException{
        TypeReference<List<Recipe>> mapType = new TypeReference<List<Recipe>>() {};
        List<Recipe> recipes = objectMapper.readValue(src,mapType);
        return recipes;
    }

    public static List<Shop> parseShopList(String src) throws IOException {
        TypeReference<List<Shop>> mapType = new TypeReference<List<Shop>>(){};
        List<Shop> shops = objectMapper.readValue(src,mapType);
        return shops;
    }

    public static List<Category> parseCategoryList(String src)throws IOException {
        TypeReference<List<Category>> mapType = new TypeReference<List<Category>>(){};
        List<Category> categories = objectMapper.readValue(src,mapType);
        return categories;
    }

    public static List<ShopIngredient> parseShopIngredientList(String src)throws IOException {
        TypeReference<List<ShopIngredient>> mapType = new TypeReference<List<ShopIngredient>>(){};
        List<ShopIngredient> shopIngredients= objectMapper.readValue(src,mapType);
        return shopIngredients;
    }

    public static List<Order> parseOrderList(String src)throws IOException{
        TypeReference<List<Order>> mapType = new TypeReference<List<Order>>(){};
        List<Order> orders = objectMapper.readValue(src,mapType);
        return orders;
    }

    public static String convertObjectToString(Object obj)throws IOException{
        String toReturn = objectMapper.writeValueAsString(obj);
        return toReturn;
    }
}
