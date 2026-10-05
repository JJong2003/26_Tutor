// [디버깅 문제] 요구사항: 80점 이상 90점 미만은 B를 출력해야 한다.
// 현재 코드는 이 요구사항대로 동작하지 않습니다. 조건식을 수정하세요.
public class Q07_ConditionBug {

    public static void main(String[] args) {
        int score = 85;

        // TODO: 조건식을 수정하여 요구사항대로 동작하게 만드세요.
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80 && score < 85) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
}
