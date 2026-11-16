import java.util.ArrayList;

// [필수 3 / 직접 구현] ArrayList로 학생 목록을 만들고 수정하세요.
//
// 예상 출력:
//   학생 수: 3
//   Kim: 85
//   Lee: 70
//   Park: 92
//
// 한 단계를 끝낼 때마다 실행해서 결과를 확인합니다.
public class Q03_StudentList {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // TODO 1단계: 아래 학생 세 명을 목록에 추가합니다.
        //   Kim, 85
        //   Lee, 40
        //   Park, 92

        // TODO 2단계: get을 사용해 두 번째 학생을 꺼내 점수를 70으로 바꿉니다.
        // 새 Student 객체를 만들지 않습니다.

        // TODO 3단계: size를 사용해 "학생 수: 3"을 출력합니다.

        // TODO 4단계: for-each문으로 모든 학생의 info()를 출력합니다.
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        String info() {
            return name + ": " + score;
        }
    }
}
