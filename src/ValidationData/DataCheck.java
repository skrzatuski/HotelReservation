package ValidationData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCheck {
    public boolean checkingData(String data) {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
        sdfrmt.setLenient(false);
        try {
            Date javaDate = sdfrmt.parse(data);
        } catch (ParseException e) {
            System.out.println("Błędna data");
            return true;
        }
        return false;
    }
    public boolean isDataStopGreaterThanDataStart(String a, String b) {
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateStart = s1.parse(a);
            Date dateStop = s1.parse(b);
            if (dateStop.before(dateStart)) {
                System.out.println("Błedna data koncowa");
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
