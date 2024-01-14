import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno3 {
    String str();
}

@Anno3(str="@ Class")
public class ClassMethAnno {
    @Anno3(str="@ Method")
    public static void method() {
        try {
                ClassMethAnno meth = new ClassMethAnno();
                Method m = meth.getClass().getMethod("method");
                Anno3 anno = m.getAnnotation(Anno3.class);
                System.out.println(anno.str());    
                
                Anno3 anno1 = meth.getClass().getAnnotation(Anno3.class);
                System.out.println(anno1.str());
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        method();
    }
}
