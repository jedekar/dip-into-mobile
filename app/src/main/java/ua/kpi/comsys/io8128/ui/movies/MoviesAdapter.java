package ua.kpi.comsys.io8128.ui.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import ua.kpi.comsys.io8128.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private String[] dataset;

    public MoviesAdapter(String[] dataset) {
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
        holder.getTextView().setText(dataset[position]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
