package com.neko.flixproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.neko.flixproject.models.Movie;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        Movie movie_in_question = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("parcel_movie"));
    }
}