package cn.crs.reserve.entity;

public class Car {
    private Integer carId;

    private String carNo;

    private String carDiverName;

    private String carDiverPhone;

    private Integer carType;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public String getCarDiverName() {
        return carDiverName;
    }

    public void setCarDiverName(String carDiverName) {
        this.carDiverName = carDiverName == null ? null : carDiverName.trim();
    }

    public String getCarDiverPhone() {
        return carDiverPhone;
    }

    public void setCarDiverPhone(String carDiverPhone) {
        this.carDiverPhone = carDiverPhone == null ? null : carDiverPhone.trim();
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }
}