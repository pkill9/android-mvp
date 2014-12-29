package inf.msc.yawapp.details;

import javax.inject.Inject;

import inf.msc.yawapp.model.WeatherData;
import inf.msc.yawapp.model.WeatherDataListener;
import inf.msc.yawapp.model.WeatherSearchInteractor;

public class WeatherDetailsPresenterImpl implements WeatherDetailsPresenter {
    @Inject
    WeatherDetailsView view;

    @Inject
    WeatherSearchInteractor weatherSearchInteractor;

    @Override
    public void search(String query) {
        weatherSearchInteractor.search(query, new WeatherDataListener() {
            @Override
            public void onWeatherDataAvailable(WeatherData data) {
                view.showCityName(data.getCityName());
                view.showCurrentTemperature(data.getCurrentTemperature());
            }

            @Override
            public void onWeatherDataError() {
                view.showSearchError("FooBar");
            }
        });
    }
}