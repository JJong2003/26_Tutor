// [디버깅 문제] 요구사항: reverse(arr)는 배열의 원소 순서를 제자리에서(새 배열 없이) 뒤집어야 한다.
//   예) {1, 2, 3, 4, 5} -> {5, 4, 3, 2, 1}
//
// main을 실행하면 일부 테스트가 FAIL로 출력됩니다.
// 어떤 입력은 통과하고 어떤 입력은 실패하는지 비교하여 원인을 찾고, reverse 메서드를 수정하세요.
// 수정 후, 원인을 아래 "원인" 주석에 한 줄로 적어주세요.
//
// 원인:
import java.util.Arrays;

public class Q13_ReverseBug {

    public static void main(String[] args) {
        check(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        check(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
        check(new int[]{1, 2, 1}, new int[]{1, 2, 1});
        check(new int[]{7}, new int[]{7});
        check(new int[]{}, new int[]{});
    }

    public static void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    // 테스트 도우미: 이 메서드는 수정하지 않아도 됩니다.
    private static void check(int[] input, int[] expected) {
        String before = Arrays.toString(input);
        reverse(input);

        String result = Arrays.equals(input, expected) ? "PASS" : "FAIL";
        System.out.println(result + "  " + before + " -> " + Arrays.toString(input)
                + "  (expected " + Arrays.toString(expected) + ")");
    }
}
