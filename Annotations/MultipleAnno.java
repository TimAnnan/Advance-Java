import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno4 {
    String str();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Sec {
    String desc();
    int value();
}

@Anno4(str="In class Anno4",val=1)
@Sec(desc="In class Sec",value=2)
public class MultipleAnno {
    @Anno4(str="In Method Anno4",val=-1)
@Sec(desc="In Method Sec",value=-2)
    public static void multiple() {
        MultipleAnno c = new MultipleAnno();
        try {
            Annotation[] annos = c.getClass().getAnnotations();

            System.out.println("In Class Annos\n");
            for(Annotation i : annos) {
                System.out.println(i);
            }
            System.out.println();

            Method m = c.getClass().getMethod("multiple");
            annos = m.getAnnotations();
            System.out.println("In Method Annos \n");
            for(Annotation i : annos) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        multiple();
    }
    
}
