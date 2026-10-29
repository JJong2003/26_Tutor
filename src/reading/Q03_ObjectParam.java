// [코드 읽기 문제] main의 실행 결과를 예상하여 myAnswer에 적어보세요.
// method 내부 로직은 수정하지 마세요. myAnswer 값만 수정하면 됩니다.
//
// 메서드를 호출할 때 매개변수에 무엇이 전달되는지 생각하며 풀어보세요.
// 풀기 전에 메서드가 호출될 때마다 변수와 객체를 그림으로 그려보세요.
public class Q03_ObjectParam {

    public static void main(String[] args) {
        int number = 5;
        Student s = new Student("Kim", 80);

        changeNumber(number);
        changeScore(s);
        changeStudent(s);

        int result = number + s.score;
        int myAnswer = /* TODO */ 0;

        System.out.println(result == myAnswer);
    }

    public static void changeNumber(int number) {
        number = 99;
    }

    public static void changeScore(Student s) {
        s.score = s.score + 10;
    }

    public static void changeStudent(Student s) {
        s = new Student("Lee", 0);
        s.score = 1;
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
