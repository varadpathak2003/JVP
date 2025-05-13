import java.time.*;
import java.time.temporal.*;
public class Main{
    public static void main(String args[]){
        LocalDate ld=LocalDate.of(2024,5,16);
        LocalDateTime ldt=LocalDateTime.of(2024,5,5,5,30);
        System.out.println("Days Between :  " +calculateDays(ld,ldt));
    }
    public static int calculateDays(LocalDate ld,LocalDateTime ldt){
        int days=(int)Math.abs(ChronoUnit.DAYS.between(ld,ldt.toLocalDate()));
        return days;
    }
}
