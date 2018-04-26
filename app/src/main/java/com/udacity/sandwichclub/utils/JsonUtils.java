package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            Log.i(TAG, "JSON Object is... " + jsonRootObject);

            JSONObject jsonDataObject = jsonRootObject.optJSONObject("name");
            Log.i(TAG, "JSON Object is... " + jsonDataObject);

            String name = jsonDataObject.getString("mainName");
            Log.i(TAG, "Sandwich name is... " + name);

            JSONArray akaArray = jsonDataObject.optJSONArray("alsoKnownAs");
            Log.i(TAG, "Sandwich also name is... " + akaArray);



            String placeOfOrigin = jsonRootObject.getString("placeOfOrigin");
            Log.i(TAG, "Place of origin is... " + placeOfOrigin);

            String sandwichDescription = jsonRootObject.getString("description");
            Log.i(TAG, "Description is... " + sandwichDescription);

            String image = jsonRootObject.getString("image");
            Log.i(TAG, "Image String is... " + image);

            JSONArray ingredients = jsonDataObject.optJSONArray("ingredients");
            Log.i(TAG, "Sandwich also name is... " + ingredients);



        } catch (JSONException e){
            Log.e(TAG, "JSONException at " + e);
        }


        //Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients)

        return null;
    }
}
