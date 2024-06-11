package systemdesign.solidprinciple;

import java.awt.*;

//The Interface Segregation Principle (ISP) is one of the SOLID principles, and it states that
// a class should not be forced to implement interfaces it does not use
public class DInterfaceSegregationPrinciple {
    public static void main(String[] args) {

    }
}

interface Worker {
    void work();

    void eat();
}

class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating....");
    }
}

class RobotImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating...."); ///but but but Robot cannot eat let's not force and fix this
    }
}

// ==================== ISP ========================

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class WorkerImplFixed implements Workable,Eatable {

    @Override
    public void work() {

    }

    @Override
    public void eat() {

    }
}

class RobotImplFixed implements Workable {

    @Override
    public void work() {

    }
}

