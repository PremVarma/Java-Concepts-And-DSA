package basics.anootations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Custom annotation for logging
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@interface Loggable {
}


interface ExampleService {
    @Loggable
    void performTask();

    void regularMethod();
}

// Logging framework
class LogInvocationHandler implements InvocationHandler {
    private final Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log before method execution
        System.out.println("Method " + method.getName() + " is about to be executed.");

        // Invoke the original method
        Object result = method.invoke(target, args);

        // Log after method execution
        System.out.println("Method " + method.getName() + " has been executed.");

        return result;
    }
}

// Example class using the @Loggable annotation
class ExampleServiceImpl implements ExampleService {
    @Override
    public void performTask() {
        System.out.println("Task is being performed.");
    }

    @Override
    public void regularMethod() {
        System.out.println("This is a regular method.");
    }
}

public class AdvanceAnnotationExample {
    public static void main(String[] args) {
        // Create an instance of the ExampleServiceImpl
        ExampleService exampleService = new ExampleServiceImpl();

        // Create a proxy for the ExampleService using the LogInvocationHandler
        ExampleService proxy = (ExampleService) Proxy.newProxyInstance(
                ExampleService.class.getClassLoader(),
                new Class[]{ExampleService.class},
                new LogInvocationHandler(exampleService)
        );

        // Call the annotated method on the proxy
        proxy.performTask();

        // Call a regular method on the proxy
        proxy.regularMethod();
    }
}
