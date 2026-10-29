// [디버깅 문제] 이 코드에는 오류가 두 군데 있습니다. (partA, partB 각각 하나씩)
// 실행 결과(에러)를 근거로 원인을 찾아 수정하세요.
//
// partA 요구사항: names, scores 배열로 Student를 3명 만들어 students 배열에 담고 모두 출력한다.
// partA 기대 출력:
//   Kim: 85
//   Lee: 40
//   Park: 72
//
// partB 요구사항: 2명을 등록하고, 등록된 학생의 이름만 출력한다. (자리가 3개인 배열에 2명만 등록한다)
// partB 기대 출력:
//   Kim
//   Lee
//
// 수정 후, 각 원인을 아래 주석에 한 줄씩 적어주세요.
//
// partA 원인:
// partB 원인:
public class Q05_ObjectArray {

    public static void main(String[] args) {
        System.out.println("== partA ==");
        partA();

        System.out.println("== partB ==");
        partB();
    }

    public static void partA() {
        String[] names = {"Kim", "Lee", "Park"};
        int[] scores = {85, 40, 72};

        Student[] students = new Student[3];
        Student s = new Student("", 0);

        for (int i = 0; i < students.length; i++) {
            s.name = names[i];
            s.score = scores[i];
            students[i] = s;
        }

        for (Student student : students) {
            System.out.println(student.name + ": " + student.score);
        }
    }

    public static void partB() {
        Student[] students = new Student[3];
        students[0] = new Student("Kim", 85);
        students[1] = new Student("Lee", 40);

        for (Student student : students) {
            System.out.println(student.name);
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
