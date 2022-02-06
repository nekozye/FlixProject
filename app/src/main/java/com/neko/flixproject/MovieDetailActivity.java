package com.neko.flixproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.neko.flixproject.models.Movie;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbRating;

    Movie movie_in_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);



        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById( R.id.tvOverview);
        rbRating = findViewById(R.id.rbRating);

        movie_in_question = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("parcel_movie"));

        tvTitle.setText(movie_in_question.getTitle());
        tvOverview.setText(movie_in_question.getOverView());
        rbRating.setRating((float) movie_in_question.getRating());
    }
}