// [필수 1 / 코드 읽기] 실행하기 전에 출력 결과를 예상하세요.
// 코드는 수정하지 말고 아래 질문의 예상 답만 적습니다.
//
// 질문 1. new Student(...)는 모두 몇 번 실행되나요?
// 예상 답:
//
// 질문 2. 실제 Student 객체는 모두 몇 개인가요?
// 예상 답:
//
// 질문 3. 마지막에 a, b, c가 가리키는 객체의 name과 score는 각각 무엇인가요?
// 예상 답:
//
// 질문 4. a == b와 a == c는 각각 true일까요, false일까요?
// 예상 답:
//
// 예상과 다른 점:
public class Q01_ReferenceCheck {

    public static void main(String[] args) {
        Student a = new Student("Kim", 80);
        Student b = a;
        Student c = new Student("Kim", 80);

        b.score += 10;
        c.name = "Lee";

        System.out.println("a = " + a.info());
        System.out.println("b = " + b.info());
        System.out.println("c = " + c.info());
        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        String info() {
            return name + ": " + score;
        }
    }
}
