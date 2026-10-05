// [디버깅 문제] 요구사항: multiply(a, b)는 두 정수의 곱을 반환해야 한다.
// 현재 코드는 곱이 아닌 다른 값을 반환합니다. 메서드 내부를 수정하세요.
public class Q08_MethodBug {

    public static void main(String[] args) {
        int result = multiply(3, 4);

        System.out.println(result);
    }

    // TODO: 두 정수의 곱을 반환하도록 수정하세요.
    public static int multiply(int a, int b) {
        int result = a + b;

        return result;
    }
}
