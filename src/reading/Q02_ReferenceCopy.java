// [코드 읽기 문제] main의 실행 결과를 예상하여 myAnswer에 적어보세요.
// method 내부 로직은 수정하지 마세요. myAnswer 값만 수정하면 됩니다.
//
// 풀기 전에 변수와 객체를 그림(상자와 화살표)으로 그려보세요. README의 "그림 그리는 방법"을 참고하세요.
public class Q02_ReferenceCopy {

    public static void main(String[] args) {
        int x = 10;
        int y = x;
        y = 20;

        Student a = new Student("Kim", 80);
        Student b = a;
        b.score = 100;

        Student c = new Student("Lee", 70);
        Student d = new Student("Lee", 70);
        d.score = 0;

        int result = x + a.score + b.score + c.score + d.score;
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
    }
}
