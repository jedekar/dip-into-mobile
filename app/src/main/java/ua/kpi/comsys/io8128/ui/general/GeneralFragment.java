package ua.kpi.comsys.io8128.ui.general;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ua.kpi.comsys.io8128.R;

public class GeneralFragment extends Fragment {

    private GeneralViewModel generalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        generalViewModel =
                new ViewModelProvider(this).get(GeneralViewModel.class);
        View root = inflater.inflate(R.layout.fragment_general, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        generalViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}