package com.example.exercise2_2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClickerViewModel extends ViewModel {

    MutableLiveData<Integer> count;

    public LiveData<Integer> getCount() {
        if(count == null){
            count = new MutableLiveData<Integer>();
            count.setValue(0);
        }
        return count;
    }

    public void countUpByValue(int value){
        count.setValue(count.getValue() + value);
    }
}
