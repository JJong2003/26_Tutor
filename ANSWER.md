# ANSWER

## Part 1. Code Reading

### Q01_ObjectState

- 정답: `170`
- 해설: `a`와 `b`는 `new`로 만든 서로 다른 객체이고, 각자 자기 `score` 필드를 가진다.
  - `a`: `80 → 90 → 95` (`addScore(10)`, `addScore(5)`)
  - `b`: `70 → 75` (`addScore(5)`)
  - `a.score + b.score = 95 + 75 = 170`

### Q02_ReferenceCopy

- 정답: `280`
- 해설:
  - `int y = x; y = 20;` — `y`는 `x`의 값을 복사한 것이다. `y`를 바꿔도 `x`는 `10` 그대로이다.
  - `Student b = a; b.score = 100;` — `b`는 `a`가 가리키는 주소를 복사한 것이다. 두 변수가 같은 객체를 가리키므로 `a.score`와 `b.score`가 모두 `100`이다.
  - `c`와 `d`는 `new`를 두 번 실행해 만든 서로 다른 객체이다. `d.score = 0`은 `c`에 영향이 없으므로 `c.score`는 `70`, `d.score`는 `0`이다.
  - `10 + 100 + 100 + 70 + 0 = 280`

### Q03_ObjectParam

- 정답: `95`
- 해설:
  - `changeNumber(number)` — 매개변수 `number`는 `main`의 `number`를 복사한 값이다. 안에서 `99`로 바꿔도 `main`의 `number`는 `5`이다.
  - `changeScore(s)` — 매개변수 `s`는 `main`의 `s`가 가리키는 주소를 복사한 것이다. 같은 객체를 가리키므로 `score`를 바꾸면 `main`의 `s.score`도 `90`이 된다.
  - `changeStudent(s)` — 새 객체를 만들어 **매개변수 `s`에만** 대입한다. `main`의 `s`는 여전히 원래 객체를 가리키므로 `s.score`는 `90` 그대로이다. (`score = 1`은 새 객체의 값이다.)
  - `number + s.score = 5 + 90 = 95`

## Part 2. Debugging

### Q04_ThisBug

- 증상: `NullPointerException: Cannot invoke "String.toUpperCase()" because "this.name" is null`
- 오류가 발생한 곳: `printInfo`의 `name.toUpperCase()`
- 실제 원인: 생성자의 `name = name; score = score;`
- 문제 원인: 생성자의 매개변수 이름이 필드 이름과 같아서, 생성자 안의 `name`과 `score`는 매개변수를 가리킨다. 매개변수를 자기 자신에게 대입할 뿐 필드에는 아무것도 저장되지 않는다. 그래서 필드 `name`은 기본값 `null`, `score`는 `0`으로 남는다. `name`이 `null`인 채로 `printInfo`에서 `name.toUpperCase()`를 호출하면서 예외가 발생한다. `score = score`는 예외를 일으키지 않지만 같은 원인으로 `0`이 된다.
- 수정 방법: 필드를 가리키는 `this.`를 붙인다.

  ```java
  Student(String name, int score) {
      this.name = name;
      this.score = score;
  }
  ```

  매개변수 이름을 필드와 다르게 바꾸는 방법(`Student(String n, int s) { name = n; score = s; }`)도 같은 결과를 낸다.
- 수정 후 출력:

  ```text
  KIM: 85 (PASS)
  LEE: 40 (FAIL)
  ```

### Q05_ObjectArray

**partA**

- 증상: 예외 없이 실행되지만 `Park: 72`가 세 번 출력된다.
- 문제 원인: `new Student(...)`를 반복문 밖에서 한 번만 실행했다. 배열의 세 칸에는 객체가 아니라 객체를 가리키는 주소가 들어가는데, 세 칸 모두 같은 객체를 가리키고 있다. 반복마다 그 하나의 객체의 `name`, `score`를 덮어쓰므로 마지막 값(`Park`, `72`)만 남는다.
- 수정 방법: 반복마다 새 객체를 만든다.

  ```java
  for (int i = 0; i < students.length; i++) {
      Student s = new Student("", 0);
      s.name = names[i];
      s.score = scores[i];
      students[i] = s;
  }
  ```

  `students[i] = new Student(names[i], scores[i]);`로 바로 쓰는 방법도 같은 결과를 낸다.

**partB**

- 증상: `Kim`, `Lee`가 출력된 뒤 `NullPointerException: Cannot read field "name" because "student" is null`이 발생한다.
- 문제 원인: `new Student[3]`은 `Student`를 담을 **자리 3개**를 만들 뿐 `Student` 객체를 만들지는 않는다. 등록하지 않은 세 번째 칸은 기본값 `null`이다. 반복문이 그 칸까지 `student.name`에 접근하므로 예외가 발생한다.
- 수정 방법: 비어 있는 칸(`null`)을 건너뛴다.

  ```java
  for (Student student : students) {
      if (student != null) {
          System.out.println(student.name);
      }
  }
  ```

  등록한 학생 수(2)만큼만 반복하는 방법도 같은 결과를 낸다. 세 번째 칸에 객체를 만들어 넣으면 출력이 3줄이 되어 기대 출력과 달라진다.
- 수정 후 출력:

  ```text
  == partA ==
  Kim: 85
  Lee: 40
  Park: 72
  == partB ==
  Kim
  Lee
  ```

## Part 3. Implementation

### Q06_Student

```java
static class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    boolean isPass() {
        return score >= 60;
    }

    void printInfo() {
        String label = isPass() ? "PASS" : "FAIL";
        System.out.println(name + ": " + score + " (" + label + ")");
    }
}
```

- 해설:
  - 필드(`name`, `score`)는 메서드 밖, 클래스 안에 선언한다.
  - 생성자는 클래스 이름과 같고 반환 타입이 없다. 매개변수 이름이 필드 이름과 같으므로 `this.name = name;`처럼 `this.`로 필드를 가리킨다. (Q04 참고)
  - `isPass()`는 `score >= 60`의 결과를 그대로 반환한다. 경계값 `60`은 PASS이다.
  - `printInfo()`는 같은 클래스의 `isPass()`를 호출해 PASS/FAIL을 정한다.
- 출력:

  ```text
  Kim: 85 (PASS)
  Lee: 40 (FAIL)
  ```

### Q07_AddBonus

```java
void addBonus() {
    score += 10;
    if (score > 100) {
        score = 100;
    }
}
```

`score = Math.min(score + 10, 100);`도 같은 결과를 낸다.

- 해설: `addBonus()`는 호출된 객체 자신의 `score` 필드를 바꾼다. 그래서 `main`에서 `kim.addBonus()`를 호출하면 `kim.score`가 바뀐 채로 남는다.
- 출력:

  ```text
  score: 100
  [60, 100, 98]
  ```
- 파일의 질문: Q15에서는 값이 바뀌지 않았는데, 이번에는 for-each 안에서 `s.addBonus()`를 불렀는데도 값이 바뀌는 이유는?
  - 답: for-each의 `s`는 배열 원소를 복사한 변수이다. Q15의 `int s`에는 점수 값 자체가 들어 있어서 `s`를 바꿔도 배열 원소는 그대로였다. 이번 `s`에는 객체를 가리키는 주소가 들어 있다. 복사된 `s`와 배열 원소가 같은 객체를 가리키므로, `s.addBonus()`로 그 객체의 `score`를 바꾸면 배열을 통해서도 바뀐 값이 보인다.

### Q08_TopStudent

```java
public static Student findTop(Student[] students) {
    Student top = students[0];
    for (Student s : students) {
        if (s.score > top.score) {
            top = s;
        }
    }
    return top;
}
```

- 해설:
  - 1주차 Q11의 `findMax`와 같은 방식이다. 지금까지 본 것 중 가장 높은 것을 `top`에 들고 있다가, 더 높은 점수가 나오면 `top`을 바꾼다.
  - 점수(`int`)가 아니라 `Student` 객체(주소)를 들고 있어야 마지막에 이름을 알 수 있다.
  - `top`을 `students[0]`으로 시작하므로 첫 원소가 비교 기준이 된다.
  - 반환하는 것은 새로 만든 객체가 아니라 배열 안에 있던 그 객체를 가리키는 주소이다.
- 출력:

  ```text
  Park: 92
  ```
- 추가 문제(점수가 가장 낮은 학생): 비교 연산자만 `s.score < low.score`로 바꾸면 된다.

### Q09_BankAccount

```java
void deposit(int amount) {
    if (amount > 0) {
        balance += amount;
    }
}

boolean withdraw(int amount) {
    if (amount <= 0 || amount > balance) {
        return false;
    }
    balance -= amount;
    return true;
}
```

- 해설:
  - `deposit`은 `amount`가 `0`보다 클 때만 잔액에 더한다. 그렇지 않으면 아무것도 하지 않는다.
  - `withdraw`는 출금이 불가능한 경우(`amount`가 `0` 이하이거나 잔액보다 큼)를 먼저 걸러 `false`를 반환한다. 이때 잔액은 바꾸지 않는다. 걸러지지 않은 경우에만 잔액에서 빼고 `true`를 반환한다.
  - 잔액을 먼저 빼고 나중에 검사하면 실패했을 때도 잔액이 줄어든다.
- 출력:

  ```text
  1500
  false
  true
  1200
  1200
  ```
