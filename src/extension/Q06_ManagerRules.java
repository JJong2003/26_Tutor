import java.util.ArrayList;

// [추가 2 / 직접 구현] StudentManager에 중복 방지와 삭제 기능을 추가하세요.
// 필수 문제를 모두 해결한 경우에만 풉니다.
//
// 규칙:
//   - 같은 이름의 학생은 두 번 추가할 수 없습니다.
//   - 점수는 0 이상 100 이하만 허용합니다.
//   - addStudent는 추가 성공 여부를 반환합니다.
//   - removeStudent는 삭제 성공 여부를 반환합니다.
//
// 예상 출력:
//   Kim 추가: true
//   Kim 중복 추가: false
//   Lee 잘못된 점수 추가: false
//   Ghost 삭제: false
//   Kim 삭제: true
//   남은 학생 수: 0
public class Q06_ManagerRules {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        System.out.println("Kim 추가: " + manager.addStudent(new Student("Kim", 85)));
        System.out.println("Kim 중복 추가: " + manager.addStudent(new Student("Kim", 90)));
        System.out.println("Lee 잘못된 점수 추가: " + manager.addStudent(new Student("Lee", 120)));
        System.out.println("Ghost 삭제: " + manager.removeStudent("Ghost"));
        System.out.println("Kim 삭제: " + manager.removeStudent("Kim"));
        System.out.println("남은 학생 수: " + manager.size());
    }

    static class StudentManager {
        ArrayList<Student> students = new ArrayList<>();

        Student findByName(String name) {
            for (Student student : students) {
                if (student.name.equals(name)) {
                    return student;
                }
            }
            return null;
        }

        boolean addStudent(Student student) {
            // TODO 1단계: 점수가 범위를 벗어나면 false를 반환합니다.
            // TODO 2단계: 같은 이름의 학생이 이미 있으면 false를 반환합니다.
            // TODO 3단계: 위 조건에 걸리지 않으면 목록에 추가하고 true를 반환합니다.

            return false;
        }

        boolean removeStudent(String name) {
            // TODO 4단계: findByName으로 학생을 찾습니다.
            // 찾지 못하면 false를 반환합니다.
            // 찾았으면 students.remove(...)로 삭제하고 true를 반환합니다.

            return false;
        }

        int size() {
            return students.size();
        }
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
