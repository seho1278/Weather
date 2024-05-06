package zerobase.weather.error;

public class InvalidDate extends RuntimeException{
    private static final String MESSEGE = "너무 혹은 너무 미래의 날짜입니다.";
    public InvalidDate() {
        super(MESSEGE);
    }
}
