package cn.crs.reserve.entity;

public class CarTimesDtlKey {
    private Integer carId;

    private String timesId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getTimesId() {
        return timesId;
    }

    public void setTimesId(String timesId) {
        this.timesId = timesId == null ? null : timesId.trim();
    }
}