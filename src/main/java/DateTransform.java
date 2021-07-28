import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateTransform {
    public static List<String> changeDateFormat(List<String> dates) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            String year = "", month = "", date = "";
            if (!dates.get(i).contains("/") && !dates.get(i).contains("-")) {
                continue;
            }
            boolean first = true;
            boolean second = true;
            boolean third = true;
            try {
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
                LocalDate date1 = LocalDate.parse(dates.get(i), formatter1);
            } catch (DateTimeParseException e){
                first = false;
            }
            try {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
                LocalDate date2 = LocalDate.parse(dates.get(i), formatter2);
            } catch (DateTimeParseException e) {
                second = false;
            }
            try {
                DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
                LocalDate date3 = LocalDate.parse(dates.get(i), formatter3);
            } catch (DateTimeParseException e) {
                third = false;
            }
            if (first) {
                String[] split = dates.get(i).split("/");
                year = split[0];
                month = split[1];
                date = split[2];
                result.add(year + month + date);
            }
            if (second) {
                String[] split2 = dates.get(i).split("/");
                date = split2[0];
                month = split2[1];
                year = split2[2];
                result.add(year + month + date);
            }
            if (third) {
                String[] split3 = dates.get(i).split("-");
                month = split3[0];
                date = split3[1];
                year = split3[2];
                result.add(year + month + date);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // YYYY/MM/DD or DD/MM/YYYY or MM-DD-YYYY
        List<String> dates = changeDateFormat(Arrays.asList("2010/03/30", "15/12/2016", "11-15-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}