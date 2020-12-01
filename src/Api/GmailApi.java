/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Api;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.json.*;
//
///**
// *
// * @author cah
// */
//public class RestaurantApi extends ApiInterface {
//    private static final String baseUrl = "https://api.yelp.com";
//    private static final String callAction = "/v3/businesses/search?";
//    public static int numberOfValues = 3;
//    
//    @Override
//    public String[] getRestuarants(String _term, String _city, int _limit) {
//        int arraySpaceNeeded = _limit * numberOfValues;
//        int counterForEachRestaurant = 0;
//        String[] restaurantsData = new String[arraySpaceNeeded];
//
//        //Build the url
//        String urlString = baseUrl + callAction + "term=" + _term + "&location=" + _city + "&limit=" + _limit;
//        URL url;
//
//        try {
//
//            //Creating the URL and connection
//            url = new URL(urlString);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            //Set the request header for authorization to use the Yelp API
//            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.yelp());
//
//            //Prints out the response code
//            int status = connection.getResponseCode();
//
//            //Response code used for debugging
//            System.out.println("Yelp API Response Code: " + status + " ---> SHOWN FOR DEBUG PURPOSES");
//
//            /* Grabs the response from the API and appends it to the content variable
//               until it's empty                                                    */
//            StringBuilder content;
//            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                String inputLine;
//                content = new StringBuilder();
//
//                //Appends all of the data to the inputLine until there is no more data
//                while ((inputLine = inputStream.readLine()) != null) {
//                    content.append(inputLine);
//                }
//            }
//            // Closing the connection after the response has been saved
//            connection.disconnect();
//
//            // Saves API response into an object
//            JSONObject obj = new JSONObject(content.toString());
//            JSONArray jsonArray = obj.getJSONArray("businesses");
//
//            // Looping through every restaurant and adding it to the array
//            for (int i = 0; i < _limit; i++) {
//                JSONObject businessIndex = jsonArray.getJSONObject(i);
//                JSONObject businessLocation = businessIndex.getJSONObject("location");
//
//                restaurantsData[counterForEachRestaurant] = "Restaurant Name: " + businessIndex.getString("name");
//                restaurantsData[counterForEachRestaurant += 1] = "Address: " + businessLocation.getString("address1");
//                restaurantsData[counterForEachRestaurant += 1] = "Rating: " + businessIndex.getString("rating");
//                restaurantsData[counterForEachRestaurant += 1] = "Price: " + businessIndex.getString("price");
//                restaurantsData[counterForEachRestaurant += 1] = "Phone Number: " + businessIndex.getString("display_phone");
//                counterForEachRestaurant += 1;
//            }
//        } catch (IOException | JSONException ex) {
//            Logger.getLogger(FoodAPI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return restaurantsData;
//    }
//}
