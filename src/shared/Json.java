package shared;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;
import transferobjects.Account;
import transferobjects.Ingredient;
import transferobjects.Shop;

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
        List<Account> accounts;
        return accounts = objectMapper.readValue(src,new TypeReference<List<Account>>(){});
    }

    public static List<Ingredient> parseIngredientList(String src) throws IOException{
        TypeReference<List<Ingredient>> mapType = new TypeReference<List<Ingredient>>() {};
        List<Ingredient> ingredients = objectMapper.readValue(src,mapType);
        return ingredients;
    }

    public static List<Shop> parseShopList(String src) throws IOException {
        List<Shop> shops;
        return shops = objectMapper.readValue(src, new TypeReference<List<Shop>>(){});
    }

    public static String convertObjectToString(Object obj)throws IOException{
        Ingredient temp = (Ingredient)obj;
        System.out.println(temp);
        return objectMapper.writeValueAsString(obj);
    }
}
