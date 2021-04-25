package ua.kpi.comsys.io8128.ui.drawing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ua.kpi.comsys.io8128.R;

public class PlotFragment extends Fragment {

    private PlotViewModel plotViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        plotViewModel = new ViewModelProvider(this).get(PlotViewModel.class);
        View root = inflater.inflate(R.layout.fragment_plot, container, false);

        final Button chartButton = root.findViewById(R.id.drawing_chart_button);
        plotViewModel.getButtonName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                chartButton.setText(s);
            }
        });
        chartButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        R.id.action_navigation_drawing_plot_to_navigation_drawing_chart, null));

        return root;
    }
}