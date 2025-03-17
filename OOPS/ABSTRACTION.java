package OOPS;

abstract class person{
    String Name;
    int age;
    float height;
    person(String Name, int age, float height){ // constructor
        this.Name = Name;
        this.age = age;
        this.height = height;
    }
}
class student extends person {
    int marks;
    float avg;

    student(String name,int age,float height, int marks, float avg){
        super(name,age,height); // to call parameterized constructor of parent from child
        this.marks = marks;
        this.avg = avg;
    }
    void display(){
        System.out.println("name: "+Name);
        System.out.println("age: "+age);
        System.out.println("height: "+height);
        System.out.println("marks: "+marks);
        System.out.println("avg: "+avg);
    }
}



public class ABSTRACTION {
    public static void main(String[] args) {
       student s = new student("dip",22,5.8f,98,99);
       s.display();

    }
}
