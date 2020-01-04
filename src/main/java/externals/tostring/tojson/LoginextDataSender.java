package externals.tostring.tojson;

public class LoginextDataSender {

    public static void main(String[] args) {

        LoginextRequest loginextRequestPacket = new LoginextRequest();

        loginextRequestPacket.setTemperature(0.0);
        loginextRequestPacket.setReeferActive(1);
        loginextRequestPacket.setBatteryPerc(100.9);

        loginextRequestPacket.setHarshDriving(23.0);
        loginextRequestPacket.setDoorOpen(1);
        loginextRequestPacket.setLatitude(90.98);
        loginextRequestPacket.setLongitude(87.324);

        LoginextRequest request = new LoginextRequest();
        request.setTrackerId(loginextRequestPacket.getTrackerId());
        request.setLatitude(loginextRequestPacket.getLatitude());
        request.setLongitude(loginextRequestPacket.getLongitude());
        request.setTime(loginextRequestPacket.getTime());
        request.setBatteryPerc(loginextRequestPacket.getBatteryPerc());

        request.setSpeed(loginextRequestPacket.getSpeed());
        request.setMessageType(loginextRequestPacket.getMessageType());
        request.setHarshDriving(loginextRequestPacket.getHarshDriving());

        if (loginextRequestPacket.getTemperature() != 0.0) {
            request.setTemperature(loginextRequestPacket.getTemperature());
        }
        if (loginextRequestPacket.getReeferActive() == 1) {
            request.setReeferActive(loginextRequestPacket.getReeferActive());
        }

        System.out.println(loginextRequestPacket);
        System.out.println(request);
    }
}
