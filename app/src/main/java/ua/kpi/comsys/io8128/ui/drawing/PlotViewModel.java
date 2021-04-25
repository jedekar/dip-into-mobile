package ua.kpi.comsys.io8128.ui.drawing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlotViewModel extends ViewModel {
    private MutableLiveData<String> mButtonName;

    public PlotViewModel() {
        mButtonName = new MutableLiveData<>();
        mButtonName.setValue("Діаграма");
    }

    public LiveData<String> getButtonName() {
        return mButtonName;
    }
}
