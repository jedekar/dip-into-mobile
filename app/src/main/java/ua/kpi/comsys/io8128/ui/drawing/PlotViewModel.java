package ua.kpi.comsys.io8128.ui.drawing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class PlotViewModel extends ViewModel {
    private MutableLiveData<LineGraphSeries<DataPoint>> mData;
    private MutableLiveData<String> mButtonName;

    public PlotViewModel() {
        mData = new MutableLiveData<>();
        mData.setValue(
                new LineGraphSeries<DataPoint>(new DataPoint[] {
                        new DataPoint(0, 1),
                        new DataPoint(1, 5),
                        new DataPoint(2, 3),
                        new DataPoint(3, 2),
                        new DataPoint(4, 6),
                }));
        mButtonName = new MutableLiveData<>();
        mButtonName.setValue("Діаграма");
    }

    public LiveData<LineGraphSeries<DataPoint>> getData() {
        return mData;
    }

    public LiveData<String> getButtonName() {
        return mButtonName;
    }
}
