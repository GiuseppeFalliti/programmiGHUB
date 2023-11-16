import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author Giuseppe Falliti & Riccardo Ponzano.
 * @version 1.0
 */

public class ControlloDate {
    private LocalDate date;
    private final String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])\\/(0[1-9]|[1-9]|1[0-2])\\/(\\d{4})$";
    private final int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31};

    public void addData(String data) {
        if (!data.matches(regex)) {
            System.out.println("Formato data non valido");
            return;
        }

        date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        if (day <= DAYS[month - 1]) {
            System.out.println("Giorno esistente");
        } else {
            System.out.println("Giorno non esistente");
        }

        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            System.out.println("Anno bisestile");
        } else {
            System.out.println("Anno non bisestile");
        }

        System.out.println("Data valida : " + date);

        
    }
}
