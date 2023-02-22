package chapters.observer.pull;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }



    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("기상 예보: ");
        if (currentPressure > lastPressure) {
            sb.append("날씨가 좋아지고 있습니다.");
        } else if (currentPressure == lastPressure) {
            sb.append("지금과 비슷할 것 같습니다.");
        } else if (currentPressure < lastPressure) {
            sb.append("쌀쌀하며 비가 올 것 같습니다.");
        }
        System.out.println(sb);
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
