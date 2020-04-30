package JSON_Build_Json_String_Arraylist_TollEvent_Object;     // Feb 2020

import DTOs.TollEvent;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

/**
 * Code illustrating the "building up" of a JSON string from an ArrayList of
 * User type objects. 
 * Two approaches are used in this sample:
 * 1. The JSON structure is built 'manually' by concatenating/appending the 
 *    required parts in sequence into one String. This can be tedious and error prone.
 *
 *    (Another option is to define a toJson() method in the User class that will
 *    convert its data to JSON format String
 *
 * 2. Use JSON "Builders"
 *    JsonArrayBuilder and JsonObjectBuider can be used.
 *
 */
public class JSON_Build_Json_String_Arraylist_TollEvent_Object
{

    public static void main(String[] args)
    {
        ArrayList<TollEvent> list = new ArrayList<>();
        list.add(new TollEvent("201LH309", 222222, 1562537493));
        list.add(new TollEvent("162CN320", 324878, 1487499962));
        list.add(new TollEvent("191LM203", 195625, 1325479725));

        // Option 1
        //String jsonString = buildJsonByAppendingStrings(list);
        
        // Option 2
        String jsonString = buildJsonUsingJsonObjectBuilder(list);

        System.out.println("Json String as generated from ArrayList<User> :\n\n" + jsonString + "\n");

        System.out.println("Copy & Paste the above JSON String into the JSON Formatter & Validator \n"
                + "website to check that it is valid JSON.");

        // After executing the program above, you can copy the JSON string from 
        // the output window, and paste it into the JSON Formatter & Validator 
        // website in order to confirm that the JSON is valid.
    }

    /**
     * Build a JSON string from the data above note the escape characters -> we
     * enter \" to produce " We must build the JSON array to contain the list of
     * objects
     */
    public static String buildJsonByAppendingStrings(List<TollEvent> list)
    {
        String jsonString = "{" // root object
                + "\"event\":[";   // set up the array (list)
        int i;
        for (i = 0; i < list.size() - 1; i++) {
            jsonString += "{"
                    + "\"id\":" + list.get(i).getId() + ","
                    + "\"registration\":" + "\"" + list.get(i).getRegistration() + "\","
                    + "\"imageid\":" + "\"" + list.get(i).getImageId() + "\","
                    + "\"timestamp\":" + "\"" + list.get(i).getTimestamp() + "\","
                    + "}" + ",";
            // jsonString += list.get(i).toJson() + ",";  // could use toJson() if defined in User class
        }

        jsonString += "{"
               + "\"id\":" + list.get(i).getId() + ","
                    + "\"registration\":" + "\"" + list.get(i).getRegistration() + "\","
                    + "\"imageid\":" + "\"" + list.get(i).getImageId() + "\","
                    + "\"timestamp\":" + "\"" + list.get(i).getTimestamp() + "\","
                    + "}" + ",";
        
        //jsonString += list.get(i).toJson();  // could use toJson() if defined in User class
        jsonString += "]}";  // close the array and close the object 

        return jsonString;
    }

    /**
     * Converts a list of User objects into a JSON String.
     * The approach is as follows:
     * In a loop: build a JSON Object and add it to and ArrayBuilder. 
     * After the loop: invoke .build() on the ArrayBuilder to 
     * create the JsonArray.
     * 
     * @param list  list of User objects
     * @return 
     */
    public static String buildJsonUsingJsonObjectBuilder(List<TollEvent> list)
    {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();

        for (TollEvent event : list) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", event.getId())
                    .add("registration", event.getRegistration())
                    .add("imageid", event.getImageId())                    
                    .add("timestamp", event.getTimestamp())
                    .build()
            );
        }
        
        // build the JsonArray
        JsonArray jsonArray = arrayBuilder.build();

        // wrap the JsonArray in a JsonObject and give the JsonArray a key name
        JsonObject jsonRootObject
                = Json.createObjectBuilder()
                        .add("Toll Event", jsonArray)
                        .build();

        return jsonRootObject.toString();
    }
}
