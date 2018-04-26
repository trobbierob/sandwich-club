package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {

        try {

            //Parse Root Object
            JSONObject jsonRootObject = new JSONObject(json);
            Log.i(TAG, "JSON RootObject is... " + jsonRootObject);

            //Parse Data Object
            JSONObject jsonDataObject = jsonRootObject.optJSONObject("name");
            Log.i(TAG, "JSON DataObject is... " + jsonDataObject);

            //Parse Name of Sandwich
            String mainName = jsonDataObject.getString("mainName");
            Log.i(TAG, "Sandwich name is... " + mainName);

            //Parse alsoKnowAs names of Sandwich
            JSONArray akaArray = jsonDataObject.optJSONArray("alsoKnownAs");
            Log.i(TAG, "Sandwich also goes by... " + akaArray);
            List<String> alsoKnownAs = new ArrayList<String>();
            for(int i = 0; i < akaArray.length(); i++) {
                alsoKnownAs.add(akaArray.get(i).toString());
            }
            Log.i(TAG, "Also name list is... " + alsoKnownAs);

            //Parse Place of Origin of Sandwich
            String placeOfOrigin = jsonRootObject.getString("placeOfOrigin");
            Log.i(TAG, "Place of origin is... " + placeOfOrigin);

            //Parse Description of Sandwich
            String description = jsonRootObject.getString("description");
            Log.i(TAG, "Description is... " + description);

            //Parse Image String
            String image = jsonRootObject.getString("image");
            Log.i(TAG, "Image String is... " + image);

            //Parse Ingredients of Sandwich
            JSONArray ingredients = jsonRootObject.optJSONArray("ingredients");
            Log.i(TAG, "Sandwich ingredients array... " + ingredients);
            List<String> ingredientsList = new ArrayList<String>();
            for(int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.get(i).toString());
            }
            Log.i(TAG, "Ingredients list... " + ingredientsList);

            //Return Sandwich
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e){
            Log.e(TAG, "JSONException at " + e);
        }

        return null;
    }
}
