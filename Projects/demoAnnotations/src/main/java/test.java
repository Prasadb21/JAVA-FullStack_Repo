import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {

    String id();
    String value();

}

@MyAnnotation(value = "Custom annotation " , id = "1")
public class test
{
    public static void main(String[] args) {

/*        This block is a standard way to:

            Access a class at runtime.
            Check if a specific annotation is present.
            Retrieve the annotation and its parameters.
            Use those values in your logic.
*/
        Class<test> testClass = test.class;
        if(testClass.isAnnotationPresent(MyAnnotation.class))
        {
            MyAnnotation myAnnotation = testClass.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation Value : " + myAnnotation.value() + "Id is : " + myAnnotation.id());
        }
        else
        {
            System.out.println("This class has no annotation present called MyAnnotation !!!");
        }


    }
}
