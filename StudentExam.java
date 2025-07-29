package Array;

public class StudentExam {
    String Name;
    int Age;

    StudentExam(String Name,int Age){
        this.Name = Name;
        this.Age = Age;
    }
   void display(){
        System.out.println("Name :" + Name + " Age :"+Age);
    }

    public static void main(String[] args) {
        StudentExam[] students = new StudentExam[2];
        students[0]=new StudentExam("Anshu",18);
        students[1]=new StudentExam("Ankush",17);

        for(StudentExam s : students){
            s.display();

        }
    }
}
