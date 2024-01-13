
enum Subjects {
    C,CPP,CLOUD,PYTHON
}

public class Enum2 {
    public static void main(String[] args) {
        Subjects subject = Subjects.CPP;
        switch (subject) {
            case C:
                System.out.println(" C ");
                break;
            case CPP:
                System.out.println(" CPP");
                break;
            case PYTHON:
                System.out.println(" PYTHON");
                break;
            case CLOUD:
                System.out.println(" CLOUD");
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
}
