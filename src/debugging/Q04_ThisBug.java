// [디버깅 문제] 이 코드는 실행 중 오류가 발생합니다.
// 요구사항: Student는 이름과 점수를 저장한다. printInfo()는 이름을 대문자로 바꾸고, 60점 이상이면 PASS를 붙여 출력한다.
//
// 기대 출력:
//   KIM: 85 (PASS)
//   LEE: 40 (FAIL)
//
// 오류 메시지가 가리키는 줄이 곧 원인이 있는 줄이라는 보장은 없습니다.
// 문제가 되는 값이 어디서 만들어졌는지 거슬러 올라가 원인을 찾고 수정하세요.
// 수정 후, 오류가 발생한 줄과 실제 원인이 있는 줄이 각각 어디였는지 아래 주석에 적어주세요.
//
// 오류가 발생한 곳:
// 실제 원인:
public class Q04_ThisBug {

    public static void main(String[] args) {
        Student kim = new Student("Kim", 85);
        Student lee = new Student("Lee", 40);

        kim.printInfo();
        lee.printInfo();
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            name = name;
            score = score;
        }

        boolean isPass() {
            return score >= 60;
        }

        void printInfo() {
            String label = isPass() ? "PASS" : "FAIL";

            System.out.println(name.toUpperCase() + ": " + score + " (" + label + ")");
        }
    }
}
