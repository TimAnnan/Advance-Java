
enum Week {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Enum1 {
    public static void main(String[] args) {
       
        for (Week day : Week.values()) {
            System.out.println(day+" "+ day.ordinal());
        }
    }
}
