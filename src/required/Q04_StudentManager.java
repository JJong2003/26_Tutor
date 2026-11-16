import java.util.ArrayList;

// [필수 4 / 직접 구현] 학생 목록을 관리하는 StudentManager를 완성하세요.
//
// 예상 출력:
//   Lee: 40
//   Lee: 75
//   Ghost 수정 성공: false
//   Kim: 85
//   Lee: 75
//   Park: 92
//
// main은 수정하지 않습니다. StudentManager의 TODO만 순서대로 완성합니다.
// 각 단계를 끝낼 때마다 실행해서 어디까지 동작하는지 확인합니다.
public class Q04_StudentManager {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("Kim", 85));
        manager.addStudent(new Student("Lee", 40));
        manager.addStudent(new Student("Park", 92));

        Student lee = manager.findByName("Lee");
        if (lee != null) {
            lee.printInfo();
        }

        manager.updateScore("Lee", 75);
        manager.findByName("Lee").printInfo();

        boolean updated = manager.updateScore("Ghost", 100);
        System.out.println("Ghost 수정 성공: " + updated);

        manager.printAll();
    }

    static class StudentManager {
        ArrayList<Student> students = new ArrayList<>();

        void addStudent(Student student) {
            // TODO 1단계: 전달받은 학생을 students에 추가합니다.
        }

        Student findByName(String name) {
            // TODO 2단계: students를 처음부터 확인합니다.
            // 이름이 같은 학생을 찾으면 그 Student 객체를 반환합니다.
            // 문자열 내용은 ==가 아니라 equals로 비교합니다.

            return null;
        }

        boolean updateScore(String name, int newScore) {
            // TODO 3단계: findByName을 사용해 학생을 찾습니다.
            // 찾았으면 그 객체의 점수를 바꾸고 true를 반환합니다.
            // 찾지 못했으면 false를 반환합니다.

            return false;
        }

        void printAll() {
            // TODO 4단계: 모든 학생의 printInfo()를 호출합니다.
        }
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        void printInfo() {
            System.out.println(name + ": " + score);
        }
    }
}
