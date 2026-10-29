// [직접 구현 문제] 점수가 가장 높은 학생을 찾아 출력하세요.
// 예상 출력:
//   Park: 92
//
// 힌트는 없습니다. 코드를 쓰기 전에, 필요한 단계를 한국어로 먼저 적어보세요.
//   1.
//   2.
//   3.
//
// 구현 전에는 findTop이 null을 반환하므로 NullPointerException이 발생합니다.
//
// 추가 문제(선택): 점수가 가장 낮은 학생도 찾아서 출력해보세요.
public class Q08_TopStudent {

    public static void main(String[] args) {
        Student[] students = {
                new Student("Kim", 85),
                new Student("Lee", 40),
                new Student("Park", 92),
                new Student("Choi", 77)
        };

        Student top = findTop(students);

        System.out.println(top.name + ": " + top.score);
    }

    public static Student findTop(Student[] students) {
        // TODO: students 배열에서 점수가 가장 높은 Student를 찾아 반환하세요.

        return null;
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
