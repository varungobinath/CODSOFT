import java.util.Scanner;

public class StudentGradeCalculator {
    private static void calculateGrade(int[] marks){
        int total = 0;
        for(int m : marks){
            total += m;
        }
        double average = (double) total/marks.length;
        char grade;
        if(average>=90)
            grade = 'A';
        else if(average>=75)
            grade = 'B';
        else if(average>=60)
            grade = 'C';
        else if(average>=45)
            grade = 'D';
        else
            grade = 'F';
        System.out.println("Result: ");
        System.out.println("\tTotal marks : "+total);
        System.out.printf("\tAverage marks: %,.2f\n",average);
        System.out.println("\tGrade       : "+grade);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your total number of Subjects : ");
        int n = in.nextInt();
        int[] marks = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter marks for subjects "+(i+1)+" : ");
            marks[i] = in.nextInt();
        }
        calculateGrade(marks);
        in.close();
    }
}
