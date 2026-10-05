// [코드 읽기 문제] method1()의 실행 결과를 예상하여 myAnswer에 적어보세요.
// method 내부 로직은 수정하지 마세요. myAnswer 값만 수정하면 됩니다.
public class Q01_MethodReturn {

    public static void main(String[] args) {
        int result = method1();
        int myAnswer = /* TODO */ 0;

        System.out.println(result == myAnswer);
    }

    public static int method1() {
        int a = 3;
        int b = 7;

        return a + b;
    }
}
