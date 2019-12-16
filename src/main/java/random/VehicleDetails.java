package random;

public class VehicleDetails {

    private String timeStamp;

    private String vehicleName;

    private String address;

    private String city;

    private String latitude;

    private String odometerReadingMeters;

    private String temperature;

    private String vehicleId;

    private String state;

    private String speed;

    private String longitude;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getOdometerReadingMeters() {
        return odometerReadingMeters;
    }

    public void setOdometerReadingMeters(String odometerReadingMeters) {
        this.odometerReadingMeters = odometerReadingMeters;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ClassPojo [timeStamp = " + timeStamp + ", vehicleName = " + vehicleName + ", address = " + address + ", city = " + city + ", latitude = " + latitude + ", odometerReadingMeters = " + odometerReadingMeters + ", temperature = " + temperature + ", vehicleId = " + vehicleId + ", state = " + state + ", speed = " + speed + ", longitude = " + longitude + "]";
    }
}