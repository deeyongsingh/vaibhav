package inhaeritance;

public class Person {
    void showDetail(){
        System.out.println("Person details:");
    }
}
class Student extends Person{
    void showDetail(){
        System.out.println("Student details:");
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.showDetail();
        Student s1 = new Student();
        s1.showDetail();
        Person p = new Student();
        p.showDetail();
    }
}

