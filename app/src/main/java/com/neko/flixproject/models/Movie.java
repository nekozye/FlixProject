package com.neko.flixproject.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

        public String posterPath;
        public String backdropPath;
        public String title;
        public String overView;
        public double rating;

        public Movie() {
        }

        public Movie(JSONObject jsonObject) throws JSONException {
            posterPath = jsonObject.getString("poster_path");
            backdropPath = jsonObject.getString("backdrop_path");
            title = jsonObject.getString("original_title");
            overView = jsonObject.getString("overview");
            rating = jsonObject.getDouble("vote_average");
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

        public double getRating() { return rating; }

}
