package ua.kpi.comsys.io8128.ui.movies;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import ua.kpi.comsys.io8128.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private Movie[] dataset;

    public MoviesAdapter(Movie[] dataset) {
        this.dataset = dataset;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie movie = dataset[position];

        if (movie.poster != null && !movie.poster.equals("")) {
            Context context = holder.getImageView().getContext();
            String imageName = movie.poster.substring(0, movie.poster.indexOf('.'));
            int imageId = context.getResources().getIdentifier(
                    imageName, "raw", context.getPackageName());
            Drawable image = ContextCompat.getDrawable(context, imageId);

            holder.getImageView().setImageDrawable(image);
        } else {
            holder.getImageView().setImageDrawable(null);
        }

        String text = movie.title
                + "\n\n"
                + movie.year
                + "\n\n"
                + movie.type;

        holder.getTextView().setText(text);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
