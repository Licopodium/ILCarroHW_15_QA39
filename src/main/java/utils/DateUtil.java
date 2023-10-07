package utils;


import java.text.SimpleDateFormat;
import java.util.Date;

    public class DateUtil {

        public String getDateString() {
            // Create a Date object representing the current date and time
            Date currentDate = new Date();

            // Define a date format pattern
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return dateFormat.format(currentDate);
        }
    }

