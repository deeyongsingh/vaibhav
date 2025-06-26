package inhaeritance;

class Animal {
    void makeSound(){
        System.out.println("Animal Makes sound");
    }
}
 class Dog extends Animal{
    void makeSound(){
        System.out.println("Dog Barks:");
    }
    public static void main(String[] args) {
    Animal a1 = new Animal();
    a1.makeSound();
    Dog d1 = new Dog();
    d1.makeSound();
    Animal a = new Dog();
    a.makeSound();
    }
}
