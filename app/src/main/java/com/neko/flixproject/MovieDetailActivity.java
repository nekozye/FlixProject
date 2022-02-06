package com.neko.flixproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.neko.flixproject.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class MovieDetailActivity extends YouTubeBaseActivity {

    private static final String YOUTUBE_API_KEY = "AIzaSyColxBWj6AjbOakLNi3R0SkrcTzOmVN90A";
    public static final String VIDEOS_URL = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";



    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbRating;

    YouTubePlayerView youTubePlayerView;

    Movie movie_in_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);



        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById( R.id.tvOverview);
        rbRating = findViewById(R.id.rbRating);
        youTubePlayerView = findViewById(R.id.player);



        movie_in_question = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("parcel_movie"));

        tvTitle.setText(movie_in_question.getTitle());
        tvOverview.setText(movie_in_question.getOverView());
        rbRating.setRating((float) movie_in_question.getRating());


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(VIDEOS_URL, movie_in_question.getMovieID()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    JSONArray results = json.jsonObject.getJSONArray("results");

                    if (results.length() == 0)
                        return;

                    String ytkey = results.getJSONObject(0).getString("key");
                    Log.d("DetailActivity","key:"+ytkey);
                    initializeYoutube(ytkey);

                }catch (JSONException e){
                    Log.e("DetailActivity","Failed to Parse JSON");
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });
    }

    private void initializeYoutube(String youtubeKey){
        youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.i("YTPlayer","init successful");
                youTubePlayer.cueVideo(youtubeKey);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.i("YTPlayer","init failed");
            }
        });
    }
}