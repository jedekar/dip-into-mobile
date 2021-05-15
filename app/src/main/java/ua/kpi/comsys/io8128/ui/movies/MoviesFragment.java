package ua.kpi.comsys.io8128.ui.movies;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import ua.kpi.comsys.io8128.R;

public class MoviesFragment extends Fragment {

    private Adapter adapter;
    private RecyclerView recyclerView;

    public MoviesFragment() { }

    private Movie[] parseDataset() {
        Movie[] movies = new Movie[0];
        try (Reader reader = new InputStreamReader(getResources().openRawResource(R.raw.movies_list))) {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            JsonObject search = gson.fromJson(reader, JsonObject.class);
            movies = gson.fromJson(search.getAsJsonArray("Search"), Movie[].class);
        } catch (IOException | Resources.NotFoundException e) {
            e.printStackTrace();
        }

        return movies;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.movies_recycler_view);
        adapter = new MoviesAdapter(parseDataset());
        recyclerView.setAdapter(adapter);

        return root;
    }

}