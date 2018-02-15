package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject sandwichDetail = new JSONObject(json);
            JSONObject name = sandwichDetail.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJSONArray = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = makeArrayListFromJSONArray(alsoKnownAsJSONArray);

            String placeOfOrigin = sandwichDetail.getString("placeOfOrigin");
            String description = sandwichDetail.getString("description");
            String image = sandwichDetail.getString("image");

            JSONArray ingredientsJSONArray = sandwichDetail.getJSONArray("ingredients");
            ArrayList<String> ingredients = makeArrayListFromJSONArray(ingredientsJSONArray);

            sandwich = new Sandwich(mainName,
                                    alsoKnownAs,
                                    placeOfOrigin,
                                    description,
                                    image,
                                    ingredients);

            return sandwich;
        } catch (JSONException e) {
            return sandwich;
        }
    }


    /**
     *  This method takes a JSONArray object, loops through it and returns an ArrayList<String>.
     *
     * @param jsonArray
     * @return ArrayList<String>
     * @throws JSONException
     */
    private static ArrayList<String> makeArrayListFromJSONArray (JSONArray jsonArray) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = jsonArray.length();
        for (int i = 0; i < size; i++) {
            String itemInsideJSONArray = jsonArray.getString(i);
            arrayList.add(itemInsideJSONArray);
        }
        return arrayList;
    }
}
