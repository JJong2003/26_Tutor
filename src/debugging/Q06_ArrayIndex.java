// [디버깅 문제] 이 코드는 실행 중 오류가 발생합니다.
// 어떤 오류가 발생하는지, 왜 발생하는지 파악한 뒤 직접 수정하세요.
public class Q06_ArrayIndex {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // TODO: 반복문의 종료 조건을 확인하고 오류를 수정하세요.
        for (int i = 0; i <= numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
