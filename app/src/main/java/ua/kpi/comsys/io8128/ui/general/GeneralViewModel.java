package ua.kpi.comsys.io8128.ui.general;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeneralViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GeneralViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ходос Олександр\nГрупа ІО-81\nЗК ІО-8128");
    }

    public LiveData<String> getText() {
        return mText;
    }
}