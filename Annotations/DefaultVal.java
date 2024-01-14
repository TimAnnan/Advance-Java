import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno5 {
    String str() default "apzz";
    int val() default 12;
}

@Anno5()
public class DefaultVal {
    @Anno5(str="not default str",val=0)
    public static void method() {
        DefaultVal d = new DefaultVal();
        try {
            Method m = d.getClass().getMethod("method");
            Anno5 anno = m.getAnnotation(Anno5.class);
            System.out.println("In method\n"+anno.str()+" & "+anno.val());

            Anno5 anno1 = d.getClass().getAnnotation(Anno5.class);
            System.out.println("In Class\n"+anno1.str()+" & "+anno1.val());
        } catch (NoSuchMethodException e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        method();
    }
    
}
