package ua.kpi.comsys.io8128.ui.movies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.kpi.comsys.io8128.R;

public class MoviesFragment extends Fragment {

    private Adapter adapter;
    private RecyclerView recyclerView;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);
        adapter = new MoviesAdapter(new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"});
        recyclerView = (RecyclerView) root.findViewById(R.id.movies_recycler_view);
        recyclerView.setAdapter(adapter);

        return root;
    }

}