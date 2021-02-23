package ua.kpi.comsys.io8128.ui.drawing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ua.kpi.comsys.io8128.R;
import ua.kpi.comsys.io8128.databinding.FragmentChartBinding;

public class ChartFragment extends Fragment {

    private ChartViewModel chartViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chartViewModel = new ViewModelProvider(this).get(ChartViewModel.class);
        FragmentChartBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_chart, container, false);
        binding.setViewmodel(chartViewModel);
        View root = binding.getRoot();

        final DonutChart chartView = root.findViewById(R.id.drawing_chart);
        chartViewModel.getData().observe(getViewLifecycleOwner(), chartView::setData);
        return root;
    }
}
