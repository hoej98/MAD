package dk.au.mad2021fall.assignment1.au620940;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (savedInstanceState != null)
        {
            moviee = savedInstanceState.getParcelable("MOVIE_KEY");
        }

        Intent intent = getIntent();

        TextView title = findViewById(R.id.textDetailsTitle);
        TextView year = findViewById(R.id.textDetailsYear);
        TextView genre = findViewById(R.id.textDetailsGenre);
        TextView description = findViewById(R.id.textDetailsDescription);
        TextView imdb = findViewById(R.id.textDetailsImdbRating);
        TextView userRating = findViewById(R.id.textDetailsUserRating);
        TextView userNote = findViewById(R.id.textDetailsUserNote);

        moviee = (Movie) intent.getSerializableExtra("EXTRA_MOVIE");

        title.setText(moviee.getTitle());
        year.setText(String.valueOf(moviee.getYear()));
        genre.setText(moviee.getGenre());
        description.setText(moviee.getDescription());
        imdb.setText(String.valueOf(moviee.getImdbRating()));
        userRating.setText(String.valueOf(moviee.getUserRating()));
        userNote.setText(moviee.getUserNote());

        ImageView img;
        img = findViewById(R.id.imageDetailsGenre);

        switch (moviee.getGenre()) {
            case "Action": img.setImageResource(R.drawable.ic_action); break;
            case "Comedy": img.setImageResource(R.drawable.ic_comedy); break;
            case "Drama": img.setImageResource(R.drawable.ic_drama); break;
            case "Horror": img.setImageResource(R.drawable.ic_horror); break;
            case "Romance": img.setImageResource(R.drawable.ic_romance); break;
            case "Western": img.setImageResource(R.drawable.ic_western); break;
            default: img.setImageResource(R.drawable.ic_resource_default); break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("MOVIE_KEY", moviee);
    }

    Movie moviee;

    public void onClickBack(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onClickRate(View view)
    {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("EXTRA_MOVIE", (Serializable) moviee);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            setResult(RESULT_OK, data);
            finish();
        }
    }
}