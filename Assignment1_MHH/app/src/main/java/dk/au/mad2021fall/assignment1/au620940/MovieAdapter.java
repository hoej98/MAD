package dk.au.mad2021fall.assignment1.au620940;

//ALL CODE FOR RECYCLEVIEW HAS BEEN HEAVILY INSPIRED BY CODE FROM LECTURE 3
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Console;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public interface IMovieItemClickedListener{
        void onMovieClicked(int index);
    }

    private IMovieItemClickedListener listener;

    private ArrayList<Movie> movies;

    public MovieAdapter(IMovieItemClickedListener listener){this.listener = listener;}

    public void updateMovieList(ArrayList<Movie> lists)
    {
        movies = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieViewHolder vh = new MovieViewHolder(view, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position)
    {
        holder.txtTitle.setText(movies.get(position).getTitle());
        holder.txtYear.setText(String.valueOf(movies.get(position).getYear()));
        holder.txtRating.setText(String.valueOf(movies.get(position).getUserRating()));

        switch (movies.get(position).getGenre()) {
            case "Action": holder.imgIcon.setImageResource(R.drawable.ic_action); break;
            case "Comedy": holder.imgIcon.setImageResource(R.drawable.ic_comedy); break;
            case "Drama": holder.imgIcon.setImageResource(R.drawable.ic_drama); break;
            case "Horror": holder.imgIcon.setImageResource(R.drawable.ic_horror); break;
            case "Romance": holder.imgIcon.setImageResource(R.drawable.ic_romance); break;
            case "Western": holder.imgIcon.setImageResource(R.drawable.ic_western); break;
            default: holder.imgIcon.setImageResource(R.drawable.ic_resource_default); break;
        }
    }

    @Override
    public int getItemCount() {return movies.size();}


    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtYear;
        TextView txtRating;

        IMovieItemClickedListener listener;

        public MovieViewHolder(@NonNull View itemView, IMovieItemClickedListener movieItemClickedListener)
        {
            super (itemView);

            imgIcon = itemView.findViewById(R.id.imageGenre);
            txtTitle = itemView.findViewById(R.id.textTitle);
            txtYear = itemView.findViewById(R.id.textYear);
            txtRating = itemView.findViewById(R.id.textRating);
            listener = movieItemClickedListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {listener.onMovieClicked(getAdapterPosition());}
    }
}
