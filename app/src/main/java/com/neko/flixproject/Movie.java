package com.neko.flixproject;

import org.json.JSONObject;

public class Movie {
        String posterPath;
        String title;
        String overView;

        public Movie(JSONObject jsonObject){
            posterPath = jsonObject.getString("poster_path");
        }

}
