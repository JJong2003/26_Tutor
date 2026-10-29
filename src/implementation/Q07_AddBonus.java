// [직접 구현 문제] Student의 점수에 보너스를 더하는 addBonus() 메서드를 완성하세요.
// 요구사항: 점수에 보너스 10점을 더한다. 단, 100점을 넘을 수 없다.
//   addBonus() : Student 한 명의 점수에 보너스를 적용한다.
//
// 예상 출력:
//   score: 100
//   [60, 100, 98]
//
//
// 구현한 뒤, 아래 질문에 답을 적어주세요. (그림을 그려서 설명해도 좋습니다)
//   Q15에서는 값이 바뀌지 않았는데, 이번에는 for-each 안에서 s.addBonus()를 불렀는데도 값이 바뀌는 이유는?
//   답:
import java.util.Arrays;

public class Q07_AddBonus {

    public static void main(String[] args) {
        Student kim = new Student("Kim", 95);
        kim.addBonus();
        System.out.println("score: " + kim.score);

        Student[] students = {
                new Student("A", 50),
                new Student("B", 95),
                new Student("C", 88)
        };

        for (Student s : students) {
            s.addBonus();
        }
        System.out.println(Arrays.toString(scoresOf(students)));
    }

    // 테스트 도우미: 이 메서드는 수정하지 않아도 됩니다.
    private static int[] scoresOf(Student[] students) {
        int[] scores = new int[students.length];
        for (int i = 0; i < students.length; i++) {
            scores[i] = students[i].score;
        }
        return scores;
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        // addBonus 구현하기
        void addBonus() {

        }
    }
}
