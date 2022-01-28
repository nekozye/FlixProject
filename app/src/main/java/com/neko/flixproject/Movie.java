package com.neko.flixproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {


        String posterPath;
        String title;
        String overView;

        public Movie(JSONObject jsonObject) throws JSONException {
            posterPath = jsonObject.getString("poster_path");
            title = jsonObject.getString("original_title");
            overView = jsonObject.getString("overview");
        }

        public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
                List<Movie> movies = new ArrayList<>();

                for(int i = 0; i < movieJsonArray.length(); i++){
                        movies.add(new Movie(movieJsonArray.getJSONObject(i)));
                }

                return movies;
        }

        public String getPosterPath() {
                return posterPath;
        }

        public String getTitle() {
                return title;
        }

        public String getOverView() {
                return overView;
        }

        //TODO: watch video flixter episode 2
}
