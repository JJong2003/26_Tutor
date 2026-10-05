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

학생이 위 예시와 다른 방식(예: 삼항 연산자, `Math.max` 등)으로 작성해도 요구사항을 만족하면 정답으로 인정한다. [튜터 코드 리뷰 기준](README.md#튜터-코드-리뷰-기준)에 따라 학생이 자신의 코드를 설명할 수 있는지를 함께 확인한다.
