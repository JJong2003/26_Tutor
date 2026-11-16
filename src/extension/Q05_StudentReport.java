import java.util.ArrayList;

// [추가 1 / 직접 구현] 학생 목록의 최고 점수와 평균을 구하세요.
// 필수 문제를 모두 해결한 경우에만 풉니다.
//
// 예상 출력:
//   최고 점수: Park: 92
//   평균: 72.3
//   빈 목록의 최고 학생: null
//   빈 목록의 평균: 0.0
public class Q05_StudentReport {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("Kim", 85));
        manager.addStudent(new Student("Lee", 40));
        manager.addStudent(new Student("Park", 92));

        Student top = manager.findTopStudent();
        System.out.println("최고 점수: " + top.info());
        System.out.printf("평균: %.1f%n", manager.calculateAverage());

        StudentManager emptyManager = new StudentManager();
        System.out.println("빈 목록의 최고 학생: " + emptyManager.findTopStudent());
        System.out.println("빈 목록의 평균: " + emptyManager.calculateAverage());
    }

    static class StudentManager {
        ArrayList<Student> students = new ArrayList<>();

        void addStudent(Student student) {
            students.add(student);
        }

        Student findTopStudent() {
            // TODO 1단계: 목록이 비어 있으면 null을 반환합니다.
            // TODO 2단계: 가장 높은 점수의 Student 객체를 찾아 반환합니다.

            return null;
        }

        double calculateAverage() {
            // TODO 3단계: 목록이 비어 있으면 0.0을 반환합니다.
            // TODO 4단계: 모든 점수의 합을 학생 수로 나누어 평균을 반환합니다.
            // 정수 나눗셈이 되지 않도록 확인합니다.

            return 0.0;
        }
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
