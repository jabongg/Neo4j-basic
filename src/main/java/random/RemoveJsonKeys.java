package random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RemoveJsonKeys {

    public static void main(String[] args) {
        String str = "[{\"vehicleId\":39271,\"timeStamp\":1575524696030,\"speed\":48,\"latitude\":18.812371,\"longitude\":84.468116,\"address\":\"Srikakulam - Ichchapuram Hwy, Raghunadhapuram, Andhra Pradesh 532243, India\",\"odometerReadingMeters\":86400167,\"vehicleName\":\"KA01AJ0640\",\"temperature\":-19.2,\"city\":null,\"state\":null},{\"vehicleId\":39272,\"timeStamp\":1574144072000,\"speed\":46,\"latitude\":18.389047,\"longitude\":73.856602,\"address\":\"Pune - Bengaluru Hwy, Maharashtra 411046, India\",\"odometerReadingMeters\":83328362,\"vehicleName\":\"KA01AJ0641\",\"temperature\":24.2,\"city\":null,\"state\":null}]";
        String str2 = str.replace("\\\"", "\"");
        Gson gson = new Gson();
        VehicleDetails[] vehicleDetails = gson.fromJson(str, VehicleDetails[].class);
        System.out.printf("json:" + new Gson().toJson(vehicleDetails));

        String[] keyToTrim = new String[]  {"speed"};
        getTrimmedVehicleDetails(vehicleDetails, keyToTrim);
        //GetData();
       // GetData(str);
       // getArrayList();
    }

    private static VehicleDetails[] getTrimmedVehicleDetails(VehicleDetails[] vehicleDetails, String[] keysToTrim) {
        for (VehicleDetails vehicleDetail : vehicleDetails) {
            Class aClass = VehicleDetails.class;
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                for (String keyToTrim : keysToTrim) {
                    if (keyToTrim.equals(field.getName())) {
                        System.out.println(field.getName());
                    }
                }
            }
        }
        return vehicleDetails;
    }

    private static ArrayList<VehicleDetails> GetData(String str) {
        String JsonArrayData = str; //"[\"Test1\",\"Test2\"]";
        Type listType = new TypeToken<ArrayList<VehicleDetails>>() {
        }.getType();
        ArrayList<VehicleDetails> data = new Gson().fromJson(JsonArrayData, listType);
        return data;


        /**
         *   JsonElement yourJson =  "[\"Test1\",\"Test2\"]";
         *         Type listType = new TypeToken<List<String>>() {}.getType();
         *
         *         List<String> yourList = new Gson().fromJson(yourJson, listType);
         */


        /**
         *         String jsonArrayData = "[\"Test1\",\"Test2\"]";
         *         ArrayList<String> data = new Gson().fromJson(jsonArrayData, ArrayList.class);
         */
    }

    private static void getArrayList(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> valueList =
                objectMapper.readValue(objectMapper.readTree(jsonString).get("childs").asText(), new TypeReference<List<String>>() {
                });
    }

    private static void getArrayList() {
        Gson gson = new Gson();
        //Collection<Integer> ints = Lists.immutableList(1, 2, 3, 4, 5);
        Collection<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        // Serialization
        String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

        // Deserialization
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        Collection<Integer> ints2 = gson.fromJson(json, collectionType);
        //==> ints2 is same as ints
    }


    private static ArrayList<String> GetData() {
        String str = "[\"Test1\",\"Test2\"]";
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> data = new Gson().fromJson(str, listType);
        return data;

    }


}
