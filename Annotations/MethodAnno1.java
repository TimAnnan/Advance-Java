import java.lang.annotation.*;
//import java.lang.reflect.Method;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno2 {
    String str();
    int val();
}

public class MethodAnno1 {
    @Anno2(str="Method Anno",val=13)
    public static void myMeth() {
        try {
            MethodAnno1 meth = new MethodAnno1();
            Method m = meth.getClass().getMethod("myMeth");
            Anno2 anno = m.getAnnotation(Anno2.class);
            System.out.println("Method Annotations are:\n"+anno.str()+" and "+anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        myMeth();
    }
    
}
