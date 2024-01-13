//Class And methodannotations
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3 {
    String str();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
    int val();
}

@What(description = "AnnotationTestClass", val = 1)
@MyAnno3(str = "Meta2", val = 99)
public class CompleteAnnotation {
    @What(description = "AnnotationTestMethod", val = 2)
    @MyAnno3(str = "Testing", val = 100)
    public void myMeth() {
        CompleteAnnotation ob = new CompleteAnnotation();

        try {
            Annotation[] annos = ob.getClass().getAnnotations();

            System.out.println("Annotations for Class");
            for (Annotation a : annos) {
                System.out.println(a);
            }

            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("Annotations for Method");
            for (Annotation a : annos) {
                System.out.println(a);
            }
            System.out.println();
        } catch (NoSuchMethodException e) {
            System.out.println("Method doesn't exist" + e);
        }
    }

    public static void main(String[] args) {
        CompleteAnnotation obj = new CompleteAnnotation();
        obj.myMeth();
    }
}