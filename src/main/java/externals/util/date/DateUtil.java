package externals.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String loginextDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date deviceTimeStamp = dateFormat.parse("191112184707");
        getLoginextDateFormat(deviceTimeStamp, loginextDateFormat);



    }

    private static String getLoginextDateFormat(Date deviceTimeStamp, String dateFormat) throws Exception {
        SimpleDateFormat loginextDateFormatter = new SimpleDateFormat(dateFormat);
        return loginextDateFormatter.format(deviceTimeStamp);
    }

}
