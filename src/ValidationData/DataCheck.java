package ValidationData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCheck {
    public boolean CheckingData(String data){
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
        sdfrmt.setLenient(false);
        try{
            Date javaDate = sdfrmt.parse(data);
            
        } catch (ParseException e) {
            System.out.println("Błędna data");
            return true;
        }
        return false;
    }

}
