package basics.anootations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyService {
    @LogExecutionTime
    void performTask1();

    @LogExecutionTime
    void performTask2();

    void regularMethod();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class MyServiceImpl implements MyService {
    public void performTask1() {
        System.out.println("Task 1 performed.");
    }

    public void performTask2() {
        System.out.println("Task 2 performed.");
    }

    public void regularMethod() {
        System.out.println("This is a regular method.");
    }
}

class LogExecutionTimeHandler implements InvocationHandler {
    private final Object target;

    LogExecutionTimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.currentTimeMillis();

            // Invoke the original method
            Object result = method.invoke(target, args);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(
                    method.getName() + " executed in " + executionTime + "ms"
            );

            return result;
        } else {
            // For methods without the @LogExecutionTime annotation, proceed as usual
            return method.invoke(target, args);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation {
    String value() default "Default Value";

    int number() default 42;
}

public class CustomAnnotation {
    //    Example - 2
    @MyCustomAnnotation(value = "Custom Value", number = 99)
    public void annotatedMethod() {
        // Method implementation
    }

    @MyCustomAnnotation
    public void defaultValuedMethod() {
        // Method implementation
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyService myService = new MyServiceImpl();

        MyService proxiedService = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[]{MyService.class},
                new LogExecutionTimeHandler(myService)
        );

        proxiedService.performTask1();
        proxiedService.performTask2();
        proxiedService.regularMethod();


// ====================EXample -2 =======================
        CustomAnnotation example = new CustomAnnotation();

        // Accessing annotations on methods
        MyCustomAnnotation annotation1 = example.getClass()
                .getDeclaredMethod("annotatedMethod")
                .getAnnotation(MyCustomAnnotation.class);

        MyCustomAnnotation annotation2 = example.getClass()
                .getDeclaredMethod("defaultValuedMethod")
                .getAnnotation(MyCustomAnnotation.class);

        // Accessing values from annotations
        System.out.println("Annotation 1 - Value: " + annotation1.value() + ", Number: " + annotation1.number());
        System.out.println("Annotation 2 - Value: " + annotation2.value() + ", Number: " + annotation2.number());
    }
}
