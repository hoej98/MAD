package dk.au.mad2021fall.assignment1.au620940;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity implements MovieAdapter.IMovieItemClickedListener {

    public static final int NUM_ITEMS = 100;

    private RecyclerView rcvList;
    private MovieAdapter adapter;
    public int lastIndex = 101;
    public Movie moviee;

    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (savedInstanceState != null)
        {
            movies = savedInstanceState.getParcelableArrayList("MOVIES_KEY");
            lastIndex = savedInstanceState.getInt("LAST_INDEX");
        }

        adapter = new MovieAdapter(this);
        rcvList = findViewById(R.id.rclViewMovie);
        rcvList.setLayoutManager(new LinearLayoutManager(this));
        rcvList.setAdapter(adapter);

        if (movies == null)
        {
        createData();
        }
        adapter.updateMovieList(movies);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("MOVIES_KEY", movies);
        outState.putInt("LAST_INDEX", lastIndex);
    }

    private void createData()
    {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("The Terminator", 1984, 0.0, "Action", "A human soldier is sent from 2029 to 1984 to stop an almost indestructible cyborg killing machine, sent from the same year, which has been programmed to execute a young woman whose unborn son is the key to humanity's future salvation", 8.0, ""));
        movies.add(new Movie("The Shawshank Redemption", 1994, 0.0, "Drama", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency", 9.3, ""));
        movies.add(new Movie("Hackers", 1995, 0.0, "Comedy", "Hackers are blamed for making a virus that will capsize five oil tankers.", 6.2, ""));
        movies.add(new Movie("Cube", 1997, 0.0, "Drama", "Six complete strangers with widely varying personalities are involuntarily placed in an endless maze containing deadly traps.", 7.2, ""));
        movies.add(new Movie("The Ring", 2002, 0.0, "Drama", "\tA journalist must investigate a mysterious videotape which seems to cause the death of anyone one week to the day after they view it", 7.1, ""));
        movies.add(new Movie("Django Unchained", 2012, 0.0, "Western", "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi", 8.4, ""));
        movies.add(new Movie("Casablanca", 1942, 0.0, "Romance", "\tA cynical expatriate American cafe owner struggles to decide whether or not to help his former lover and her fugitive husband escape the Nazis in French Morocco", 8.5, ""));
        movies.add(new Movie("Hercules in New York", 1970, 0.0, "Comedy", "Hercules is sent to Earth where he finds true love and starts a promising career in the bodybuilder business", 3.3, ""));
        movies.add(new Movie("The Matrix", 1999, 0.0, "Action", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence", 8.7, "" ));
        movies.add(new Movie("WarGames", 1938, 0.0, "Action", "A young man finds a back door into a military central computer in which reality is confused with game-playing, possibly starting World War III", 7.1, ""));
    }

    @Override
    public void onMovieClicked(int index) {
        lastIndex = index;
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("EXTRA_MOVIE", (Serializable) movies.get(index));
        startActivityForResult(intent, 123);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Intent intent = getIntent();
            moviee = (Movie) data.getSerializableExtra("EXTRA_MOVIE");
            movies.set(lastIndex, moviee);

            adapter.updateMovieList(movies);
        }

    }

    public void onClickKill(View view){
        System.exit(0);
    }
}