package dk.au.mad2021fall.assignment1.au620940;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Serializable;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        if (savedInstanceState != null)
        {
            moviee = savedInstanceState.getParcelable("MOVIE_KEY");
        }

        SeekBar seekbarUserRating = findViewById(R.id.seekBarMyRating);
        seekbarUserRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                userRating = (double) i / 10;
                TextView ratingView = findViewById(R.id.textMyRating);
                ratingView.setText(String.valueOf(userRating));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Intent intent = getIntent();

        TextView title = findViewById(R.id.textEditTitle);
        TextView userRating = findViewById(R.id.textMyRating);
        TextView userNote = findViewById(R.id.textMyNote);

        moviee = (Movie) intent.getSerializableExtra("EXTRA_MOVIE");

        title.setText(moviee.getTitle());
        userRating.setText(String.valueOf(moviee.getUserRating()));
        userNote.setText(moviee.getUserNote());

        ImageView img;
        img = findViewById(R.id.imageViewEditFoto);

        switch (moviee.getGenre()) {
            case "Action": img.setImageResource(R.drawable.ic_action); break;
            case "Comedy": img.setImageResource(R.drawable.ic_comedy); break;
            case "Drama": img.setImageResource(R.drawable.ic_drama); break;
            case "Horror": img.setImageResource(R.drawable.ic_horror); break;
            case "Romance": img.setImageResource(R.drawable.ic_romance); break;
            case "Western": img.setImageResource(R.drawable.ic_western); break;
            default: img.setImageResource(R.drawable.ic_resource_default); break;
        }

        seekbarUserRating.setProgress( (int) (moviee.getUserRating()*10) );

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("MOVIES_KEY", moviee);
    }

    double userRating;
    Movie moviee;

    public void onClickCancel(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onClickOk(View view)
    {
        TextView myNoteView = findViewById(R.id.textMyNote);
        moviee.setUserNote((String.valueOf(myNoteView.getText())));

        SeekBar seekBarUserRating = findViewById(R.id.seekBarMyRating);
        moviee.setUserRating((double) seekBarUserRating.getProgress()/10);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("EXTRA_MOVIE", (Serializable) moviee);
        setResult(RESULT_OK, intent);
        finish();
    }
}