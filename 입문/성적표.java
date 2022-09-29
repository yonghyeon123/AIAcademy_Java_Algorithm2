package 입문;

import java.util.Scanner;

/*
 <문제>

시험 점수를 입력받아 90 ~ 100점은 A, 
80 ~ 89점은 B, 70 ~ 79점은 C, 
60 ~ 69점은 D, 나머지 점수는 F를 
출력하는 프로그램을 작성하시오.

 

<입력>

학생이름과 시험점수(국어, 영어, 수학)을 입력한다. 
시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

 

<출력>

시험 성적을 출력한다.

**********************************************
이름 국어 영어 수학 총점 평균 성적
**********************************************
홍길동 90 90 90 270 90 A
**********************************************
*/

public class 성적표 {
    public static void main(String[] args) {
        성적표 solution = new 성적표();
        System.out.println(solution.solution());
    }

    public String solution(){
        String name = "";
        int korean = 0;
        int english = 0;
        int math = 0;
        int total = 0;
        float avg = 0;
        String grade = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하시오 : ");
        name = scanner.next();

        /* 
        System.out.println("국어점수를 입력하시오 : ");
        korean = scanner.nextInt();
        while(!(korean >= 0 && korean <= 100)){
            System.out.println("다시 입력하시오 : ");
            korean = scanner.nextInt();
        }
        System.out.println("영어점수를 입력하시오 : ");
        english = scanner.nextInt();
        while(!(english >= 0 && english <= 100)){
            System.out.println("다시 입력하시오 : ");
            english = scanner.nextInt();
        }
        System.out.println("수학점수를 입력하시오 : ");
            math = scanner.nextInt();
        while(!(math >= 0 && math <= 100)){
            System.out.println("다시 입력하시오 : ");
            math = scanner.nextInt();
        }
        */
        System.out.println("국어점수 입력 : ");
        int input = scanner.nextInt();
        while(input <= 100 && input >= 0) {korean = input; break;}
        System.out.println("영어점수 입력 : ");
        input = scanner.nextInt();
        while(input <= 100 && input >= 0) {english = input; break;}
        System.out.println("수학점수 입력 : ");
        input = scanner.nextInt();
        while(input <= 100 && input >= 0) {math = input; break;}

        total = korean + english + math;
        avg = total / 3;

        if(avg >= 90) { grade = "A"; }
        else if(avg >= 80) { grade = "B"; }
        else if(avg >= 70) { grade = "C"; }
        else if(avg >= 60) { grade = "D"; }
        else if(avg >= 50) { grade = "E"; }
        else { grade = "F";}

        String title = " ### 성적표 ### \n";
        String answer = String.format(
        "**********************************************\n"
        +"이름 국어 영어 수학 총점 평균 성적\n"
        +"**********************************************\n"
        +"%s %d %d %d %d %.1f %s\n"
        +"**********************************************", 
        name, korean, english, math, total, avg, grade);

        scanner.close();
        return title + answer;
    }
}
