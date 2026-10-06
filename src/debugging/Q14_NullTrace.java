// [디버깅 문제] 이 코드는 실행 중 오류가 발생합니다.
// 요구사항: 점수(0~100)에 따라 등급을 출력한다.
//   90~100: A / 80~89: B / 70~79: C / 70 미만: F  (F만 FAIL, 나머지는 PASS)
//
// 오류 메시지가 가리키는 줄이 곧 원인이 있는 줄이라는 보장은 없습니다.
// 문제가 되는 값이 어디서 만들어졌는지 거슬러 올라가 원인을 찾고 수정하세요.
// 수정 후, 오류가 발생한 줄과 실제 원인이 있는 줄이 각각 어디였는지 아래 주석에 적어주세요.
//
// 오류가 발생한 곳:
// 실제 원인:
public class Q14_NullTrace {

    public static void main(String[] args) {
        int[] scores = {95, 82, 77, 100, 40};

        for (int score : scores) {
            String grade = getGrade(score);
            printResult(score, grade);
        }
    }

    public static String getGrade(int score) {
        if (score >= 90 && score < 100) {
            return "A";
        } else if (score >= 80 && score < 90) {
            return "B";
        } else if (score >= 70 && score < 80) {
            return "C";
        } else if (score < 70) {
            return "F";
        }

        return null;
    }

    public static void printResult(int score, String grade) {
        String label = grade.equals("F") ? "FAIL" : "PASS";

        System.out.println(score + ": " + grade + " (" + label + ")");
    }
}
