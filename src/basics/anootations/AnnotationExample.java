package basics.anootations;

import java.util.Date;

// User-defined annotation
@interface MyAnnotation {
    String value() default "default value";
    int count() default 1;
}

public class AnnotationExample {

    // Marker annotation
    @Override
    public String toString() {
        return super.toString();
    }

    // Single-value annotation
    @SuppressWarnings("unchecked")
    public void suppressedMethod() {
        // Suppressed warnings
        Date date = new Date();
    }

    // Deprecated annotation with a message
    @Deprecated
    public void deprecatedMethod() {
        // Deprecated method implementation
    }

    // New method to replace the deprecatedMethod
    public void newMethod() {
        // New method implementation
    }

    // User-defined annotation usage
    @MyAnnotation(value = "custom value", count = 3)
    public void annotatedMethod() {
        // Annotated method implementation
    }

    public static void main(String[] args) {
        AnnotationExample example = new AnnotationExample();

        // Using the deprecated method
        example.deprecatedMethod(); // Compiler warning about deprecation

        // Using the new method
        example.newMethod();

        // Using the annotated method
        example.annotatedMethod();
    }
}

