// [코드 읽기 문제] main의 실행 결과를 예상하여 myAnswer에 적어보세요.
// method 내부 로직은 수정하지 마세요. myAnswer 값만 수정하면 됩니다.
// (Student 클래스는 한 파일에서 실행되도록 class 안에 넣어 두었습니다. static은 지금은 신경 쓰지 않아도 됩니다.)
public class Q01_ObjectState {

    public static void main(String[] args) {
        Student a = new Student("Kim", 80);
        Student b = new Student("Lee", 70);

        a.addScore(10);
        b.addScore(5);
        a.addScore(5);

        int result = a.score + b.score;
        int myAnswer = /* TODO */ 0;

        System.out.println(result == myAnswer);
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        void addScore(int amount) {
            score = score + amount;
        }
    }
}
