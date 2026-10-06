# ANSWER (튜터 참고용)

이 문서는 튜터가 코드 리뷰 시 참고하는 정답/해설 자료입니다. 학생에게 먼저 공유하지 않습니다.

## Part 1. Code Reading

### Q01_MethodReturn

- 정답: `10`
- 해설: `a = 3`, `b = 7` 이므로 `a + b = 10`을 반환한다.
- 확인 개념: 변수, 연산, 메서드 반환값, `return`

### Q02_Condition

- 정답: `2`
- 해설: `number = 7`이므로 `number > 10`은 거짓, `number > 5`는 참이 되어 `2`를 반환한다.
- 확인 개념: 조건문의 실행 순서, 비교 연산, 매개변수, 반환값

### Q03_Loop

- 정답: `15`
- 해설: `1 + 2 + 3 + 4 + 5 = 15`
- 확인 개념: `for`, 반복 범위, 누적 변수

### Q04_Array

- 정답: `16`
- 해설: `5 > 5`는 거짓, `7 + 9 = 16` (3과 5는 5보다 크지 않아 제외)
- 확인 개념: 배열, enhanced for, 조건문, 누적 연산

### Q05_MethodCall

- 정답: `16`
- 해설: `method2(3) = 6`, `method2(5) = 10`, `6 + 10 = 16`
- 확인 개념: 메서드 호출, 매개변수, 반환값, 실행 순서

## Part 2. Debugging

### Q06_ArrayIndex

- 문제 원인: `numbers.length`는 5이지만 반복문이 `i <= numbers.length`로 되어 있어 `i`가 5일 때 `numbers[5]`에 접근하게 되고, 유효한 index는 0~4이므로 `ArrayIndexOutOfBoundsException`이 발생한다.
- 수정 방법: 조건을 `i < numbers.length`로 변경한다.

### Q07_ConditionBug

- 문제 원인: `else if (score >= 80 && score < 85)`로 되어 있어 85~89점이 조건에 포함되지 않고 `else` 블록(C)으로 빠진다.
- 수정 방법: `else if (score >= 80 && score < 90)`으로 변경한다. (앞의 `if (score >= 90)`에서 90점 이상은 이미 걸러지므로 `score < 90` 조건만 있어도 되지만, 명시적으로 범위를 적어도 무방하다.)

### Q08_MethodBug

- 문제 원인: `multiply` 메서드 내부에서 `a + b`(덧셈)를 계산하고 있어 곱셈 요구사항과 맞지 않는다.
- 수정 방법: `int result = a * b;`로 변경한다.

### Q13_ReverseBug

- 증상: `{1, 2, 3, 4, 5}`, `{1, 2, 3, 4}`는 FAIL(배열이 그대로 출력됨)이고, `{1, 2, 1}`, `{7}`, `{}`는 PASS이다. 통과한 입력은 모두 앞뒤가 같은(회문) 배열이다.
- 문제 원인: 반복문이 `i < n`까지 돌아서 모든 쌍을 두 번 교환한다. 앞쪽 절반에서 뒤집은 것을 뒤쪽 절반에서 다시 원래대로 되돌린다. 회문 배열은 교환해도 같은 배열이라 통과한다.
- 수정 방법: 조건을 `i < n / 2`로 변경한다. (홀수 길이의 가운데 원소는 자기 자신과 교환할 필요가 없다.) `left`, `right` 두 index를 사용하는 방식도 정답으로 인정한다.
- 확인 개념: 반복문 추적, 배열 index, 실패한 입력과 통과한 입력의 차이로 원인 추론하기
- 리뷰 포인트:
  - "왜 `{1, 2, 1}`은 통과했는가"를 설명할 수 있는가.
  - `i <= n / 2`로 고친 경우: 짝수 길이에서 가운데 쌍을 한 번 더 교환해 `{1, 2, 3, 4}`가 FAIL이고, 빈 배열에서는 `ArrayIndexOutOfBoundsException`이 발생한다. 정답이 아니다.
  - 새 배열을 만들어 채우는 방식은 `reverse`가 `void`라서 원본 배열이 바뀌지 않는다. 요구사항("제자리에서")과 다르다.

### Q14_NullTrace

- 증상: `95`, `82`, `77`은 정상 출력되고 `100`에서 `NullPointerException`이 발생한다. 예외가 발생한 줄은 `printResult`의 `grade.equals("F")`이다.
- 문제 원인: 예외가 발생한 곳(`printResult`)이 아니라 `grade` 값이 만들어진 `getGrade`에 원인이 있다. 첫 조건이 `score >= 90 && score < 100`이라 100점이 어떤 조건에도 걸리지 않고 마지막 `return null;`로 빠진다.
- 수정 방법: 첫 조건을 `score <= 100`으로 변경한다. `score >= 90`으로 변경해도 정답이다. (앞 조건에서 걸러지지 않은 값만 `else if`로 내려오기 때문이다.)
- 확인 개념: 스택트레이스 읽기, `null`이 만들어진 곳 거슬러 올라가기, 경계값, 호출한 메서드와 호출된 메서드의 책임 구분
- 리뷰 포인트:
  - `printResult`에 `grade != null` 검사만 추가하면 예외는 사라지지만 `100: null (PASS)`가 출력된다. 증상만 가린 것이므로 정답이 아니다. "100점은 어떤 등급이어야 하는가"를 되묻는다.
  - 파일 상단의 "오류가 발생한 곳"과 "실제 원인"을 구분해서 적었는가. 두 곳이 같다고 적었다면 `null`이 어디서 만들어졌는지 추적하지 못한 것이다.

### Q15_ValueCopy

- 증상: 예외나 컴파일 오류 없이 실행되지만 `score: 95`, `[50, 95, 88]`이 출력된다. (기대 출력: `score: 100`, `[60, 100, 98]`)
- 문제 원인: 두 곳 모두 값이 복사되어 원본에 반영되지 않는다.
  1. `addBonus(int score)`의 `score`는 호출한 쪽 변수의 복사본이다. 메서드 안에서 바꿔도 `main`의 `score`는 바뀌지 않는다.
  2. `addBonusAll`의 for-each 변수 `s`는 배열 원소의 복사본이다. `s`를 바꿔도 배열은 바뀌지 않는다.
- 수정 방법:
  1. `addBonus`가 `int`를 반환하게 하고, `main`에서 `score = addBonus(score);`로 받는다.
  2. 인덱스 반복문으로 바꾸고 `scores[i] = addBonus(scores[i]);`처럼 배열 원소에 직접 대입한다.
- 확인 개념: 매개변수 전달(값 복사), 반환값 사용, for-each와 인덱스 반복문의 차이, 배열 원소 대입
- 리뷰 포인트:
  - `addBonus` 내부 로직은 맞다. 내부만 계속 고치고 있다면 "메서드가 끝난 뒤 `score`는 어디에 남는가"를 묻는다.
  - 반환 타입만 `int`로 바꾸고 `main`에서 반환값을 받지 않으면 여전히 `score: 95`가 출력된다. 반환값을 받아야 한다.
  - "배열은 메서드에서 바꾸면 반영된다"는 설명과 "for-each 변수는 복사본이다"는 설명을 구분해서 말할 수 있는가. 배열 자체는 바뀌지만, for-each 변수 `s`에 대입하는 것은 배열을 바꾸지 않는다.
  - IDE가 "값이 사용되지 않는다"는 취지의 경고를 표시할 수 있다. 이 경고를 단서로 활용했다면 좋은 신호이다.

## Part 3. Implementation (예시 해설)

### Q09_Condition

```java
if (number > 0) {
    System.out.println("Positive");
} else if (number < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

### Q10_Loop

```java
for (int i = 1; i <= n; i++) {
    if (i % 2 == 0) {
        System.out.println(i);
    }
}
```

### Q11_Array

```java
public static int findMax(int[] numbers) {
    int max = numbers[0];
    for (int number : numbers) {
        if (number > max) {
            max = number;
        }
    }
    return max;
}
```

### Q12_Method

```java
public static boolean isEven(int number) {
    return number % 2 == 0;
}

public static int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}
```

## 리뷰 시 참고

디버깅 문제는 수정한 코드뿐 아니라 원인 설명도 함께 확인한다. 증상("배열이 안 바뀐다")이 아니라 원인("모든 쌍을 두 번 교환한다")으로 설명했는지 본다. Q13~Q15는 파일 상단의 "원인:" 주석을, Q06~Q08은 Pull Request의 "디버깅 문제의 원인"을 확인한다.

학생이 위 예시와 다른 방식(예: 삼항 연산자, `Math.max` 등)으로 작성해도 요구사항을 만족하면 정답으로 인정한다. [튜터 코드 리뷰 기준](README.md#튜터-코드-리뷰-기준)에 따라 학생이 자신의 코드를 설명할 수 있는지를 함께 확인한다.
