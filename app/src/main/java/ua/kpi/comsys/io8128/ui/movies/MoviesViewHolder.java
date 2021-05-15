package ua.kpi.comsys.io8128.ui.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ua.kpi.comsys.io8128.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageView;
    private final TextView textView;

    public MoviesViewHolder(View view) {
        super(view);
        imageView = (ImageView) view.findViewById(R.id.movie_image);
        textView = (TextView) view.findViewById(R.id.movie_text);
    }

    public ImageView getImageView() {
        return imageView;
    }
    public TextView getTextView() {
        return textView;
    }
}
