import java.util.ArrayList;

// [필수 2 / 디버깅] 오류 없이 실행되지만 Kim의 점수가 100으로 바뀌지 않습니다.
//
// 기대 출력:
//   Kim: 100
//   Lee: 70
//
// 실제 출력:
//   Kim: 85
//   Lee: 70
//
// 규칙:
//   1. 먼저 실행해서 실제 출력을 확인합니다.
//   2. updateFirstStudent 안의 세 변수를 상자와 화살표로 그립니다.
//      - students
//      - first
//      - new Student("Kim", 100)으로 만든 객체
//   3. 새 Student 객체를 만들지 않고 기존 객체의 점수를 바꾸도록 수정합니다.
//   4. 수정한 뒤 원인을 한 줄로 적습니다.
//
// 원인:
public class Q02_ListUpdateBug {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Kim", 85));
        students.add(new Student("Lee", 70));

        updateFirstStudent(students);

        for (Student student : students) {
            System.out.println(student.info());
        }
    }

    static void updateFirstStudent(ArrayList<Student> students) {
        Student first = students.get(0);
        first = new Student("Kim", 100); // 이 줄 때문에 목록의 학생은 바뀌지 않습니다.
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
