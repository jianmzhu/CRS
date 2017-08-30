package cn.crs.reserve.entity;

import java.util.Date;

public class CarTimesDtlKey {
    private Integer carId;

    private String timesId;

    private Date bookDate;

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

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }
}