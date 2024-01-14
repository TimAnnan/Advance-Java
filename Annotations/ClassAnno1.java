import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@interface Anno1 {
    String str();
    int val();
}
@Anno1(str="Class Annotation", val=12)
public class ClassAnno1 {
    public static void main(String[] args) {
      try {
        ClassAnno1 class1 = new ClassAnno1();
        Anno1 anno = class1.getClass().getAnnotation(Anno1.class);
        System.out.println("Class Annotations are:\n"+anno.str()+" and "+anno.val()); 
      } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
      }
    }
    
}
