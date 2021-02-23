package ua.kpi.comsys.io8128.ui.drawing;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import java.util.List;

import ua.kpi.comsys.io8128.R;

public class ChartViewModel extends ViewModel {
    private final MutableLiveData<String> mButtonName;
    private MutableLiveData<List<DonutSlice>> mData;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public ChartViewModel() {
        mData = new MutableLiveData<>();
        mData.setValue(List.of(
                new DonutSlice(0xfff2006c, (int) (360 * 0.25), 0),
                new DonutSlice(0xffffc518, (int) (360 * 0.25 + 360 * 0.4), (int) (360 * 0.25)),
                new DonutSlice(0xff279d1a, 360, (int) (360 * 0.25 + 360 * 0.4))
        ));
        mButtonName = new MutableLiveData<>();
        mButtonName.setValue("Графік");
    }

    public MutableLiveData<List<DonutSlice>> getData() {
        return mData;
    }

    public LiveData<String> getButtonName() {
        return mButtonName;
    }

    public View.OnClickListener getOnClickListener() {
        return Navigation.createNavigateOnClickListener(
                R.id.action_navigation_drawing_chart_to_navigation_drawing_plot, null);
    }
}
