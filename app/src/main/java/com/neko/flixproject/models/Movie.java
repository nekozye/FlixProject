package com.neko.flixproject.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {


        String posterPath;
        String backdropPath;
        String title;
        String overView;

        public Movie(JSONObject jsonObject) throws JSONException {
            posterPath = jsonObject.getString("poster_path");
            backdropPath = jsonObject.getString("backdrop_path");
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
                return String.format("https://image.tmdb.org/t/p/w342/%s",this.posterPath);
        }

        public String getBackdropPath() {
                return String.format("https://image.tmdb.org/t/p/w342/%s",this.backdropPath);
        }

        public String getTitle() {
                return title;
        }

        public String getOverView() {
                return overView;
        }

        //TODO: watch video flixter episode 2
}