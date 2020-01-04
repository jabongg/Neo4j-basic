package externals.tostring.tojson;

public class LoginextRequest {



    private String trackerId;
    private Double latitude;
    private Double longitude;
    private String time;
    private Double batteryPerc;
    private Double speed;
    private String messageType;
    private Double temperature;
    private Integer reeferActive;
    private Integer doorOpen;
    private Double harshDriving;

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getBatteryPerc() {
        return batteryPerc;
    }

    public void setBatteryPerc(Double batteryPerc) {
        this.batteryPerc = batteryPerc;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getReeferActive() {
        return reeferActive;
    }

    public void setReeferActive(Integer reeferActive) {
        this.reeferActive = reeferActive;
    }

    public Integer getDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(Integer doorOpen) {
        this.doorOpen = doorOpen;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Double getHarshDriving() {
        return harshDriving;
    }

    public void setHarshDriving(Double harshDriving) {
        this.harshDriving = harshDriving;
    }

    @Override
    public String toString() {
        return "LoginextRequest{" +
                "trackerId='" + trackerId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + time +
                ", batteryPerc=" + batteryPerc +
                ", speed=" + speed +
                ", temperature=" + temperature +
                ", reeferActive=" + reeferActive +
                ", doorStatus=" + doorOpen +
                ", messageType='" + messageType + '\'' +
                ", harshDriving=" + harshDriving +
                '}';
    }

}

