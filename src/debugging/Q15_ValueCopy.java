// [디버깅 문제] 이 코드는 오류 없이 실행되지만, 결과가 기대와 다릅니다.
// 요구사항: 점수에 보너스 10점을 더한다. 단, 100점을 넘을 수 없다.
//   addBonus(score)      : 점수 하나에 보너스를 적용한다.
//   addBonusAll(scores)  : 배열의 모든 점수에 보너스를 적용한다.
//
// 아래 기대 출력이 나오도록 수정하세요. (main과 메서드 모두 수정해도 되지만 기대 출력은 그대로 만족해야 합니다)
// 수정 후, 왜 처음 코드는 값이 바뀌지 않았는지 아래 주석에 적어주세요.
//
// 기대 출력:
//   score: 100
//   [60, 100, 98]
//
// 원인:
import java.util.Arrays;

public class Q15_ValueCopy {

    public static void main(String[] args) {
        int score = 95;
        addBonus(score);
        System.out.println("score: " + score);

        int[] scores = {50, 95, 88};
        addBonusAll(scores);
        System.out.println(Arrays.toString(scores));
    }

    public static void addBonus(int score) {
        score += 10;

        if (score > 100) {
            score = 100;
        }
    }

    public static void addBonusAll(int[] scores) {
        for (int s : scores) {
            s += 10;

            if (s > 100) {
                s = 100;
            }
        }
    }
}
