import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno6 {

}

public class MarkerAnno {
    @Anno6()
    public static void methods() {
        MarkerAnno d = new MarkerAnno();
        try {
            Method m = d.getClass().getMethod("methods");
            if(m.isAnnotationPresent(Anno6.class)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            
        } catch (NoSuchMethodException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        methods();
    }
    
}
