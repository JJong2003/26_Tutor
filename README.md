# Week 01 — Java 기초 진단

## 1주차 목표

이번 주 목표는 Java 기본 문법을 다시 배우는 것이 아니라,
현재 자신의 Java 이해 수준을 확인하는 것입니다.

코드를 읽고,
오류를 찾아 수정하고,
간단한 프로그램을 직접 작성해봅니다.

## 시작하기 전에

1. 이 branch(`week-01-java-basic`)를 기준으로 자신의 작업 branch를 만듭니다.

   ```bash
   git switch week-01-java-basic
   git switch -c solve/week-01
   ```

2. 아래 "문제 구성"을 참고하여 문제를 풉니다.
3. 문제를 다 풀었거나 시간이 다 되었으면 "제출 방법"에 따라 Pull Request를 생성합니다.

## 프로젝트 구조

```text
README.md
ANSWER.md                 (튜터 참고용 — 먼저 보지 마세요)

src/
├── reading/               Part 1. Code Reading
│   ├── Q01_MethodReturn.java
│   ├── Q02_Condition.java
│   ├── Q03_Loop.java
│   ├── Q04_Array.java
│   └── Q05_MethodCall.java
│
├── debugging/             Part 2. Debugging
│   ├── Q06_ArrayIndex.java
│   ├── Q07_ConditionBug.java
│   └── Q08_MethodBug.java
│
└── implementation/        Part 3. Implementation
    ├── Q09_Condition.java
    ├── Q10_Loop.java
    ├── Q11_Array.java
    └── Q12_Method.java
```

각 파일은 `javac`로 개별 컴파일하거나, IDE(IntelliJ 등)에서 해당 파일을 열어 실행(Run)하면 됩니다.

```bash
javac src/reading/Q01_MethodReturn.java -d out
java -cp out Q01_MethodReturn
```

## 문제 구성

```text
Part 1. Code Reading       (Q01 ~ Q05)
Part 2. Debugging          (Q06 ~ Q08)
Part 3. Implementation     (Q09 ~ Q12)
```

### 필수 문제

```text
Q01, Q02, Q03, Q06, Q07, Q09, Q10, Q11
```

학생의 Java 기본 수준을 판단하기 위한 문제들입니다. 먼저 이 문제들을 풉니다.

### 추가 문제

```text
Q04, Q05, Q08, Q12
```

필수 문제를 빨리 해결했다면 추가로 풀어봅니다. 모든 문제를 반드시 풀어야 하는 것은 아닙니다.

## Part 1. 코드 읽기 문제 규칙

코드 읽기 문제(Q01~Q05)는 기존 코드를 수정하는 문제가 아닙니다.
코드를 읽고 실행 결과를 예상한 뒤, `myAnswer`에 예상값만 입력합니다.

```text
[코드 읽기 문제 규칙]

1. 코드를 실행하기 전에 먼저 실행 결과를 예상한다.
2. method 내부 로직은 수정하지 않는다.
3. TODO가 있는 myAnswer 값만 수정한다.
4. 실행 결과가 true라면 정답이다.
5. 단순히 여러 값을 넣어보면서 정답을 찾는 방식은 지양한다.
6. 반드시 코드의 실행 흐름을 직접 따라가 본다.
```

가능하다면 문제를 풀기 전에 종이나 메모장에 변수 값을 직접 추적해보세요.

## Part 2. 디버깅 문제

디버깅 문제(Q06~Q08)는 오류가 포함된 코드입니다. 코드를 실행해서 어떤 문제가 발생하는지, 왜 발생하는지 파악하고 직접 수정하세요.

## Part 3. 직접 구현 문제

직접 구현 문제(Q09~Q12)는 요구사항에 맞는 코드를 처음부터 작성합니다. 각 파일 상단의 주석과 `TODO`를 참고하세요.

## 문제 풀이 규칙

- 먼저 스스로 생각합니다.
- 막히는 경우 튜터에게 질문합니다.
- 코드 읽기 문제에서는 `myAnswer`만 수정합니다. 다른 로직은 임의로 수정하지 않습니다.
- 디버깅 문제에서는 오류 원인을 생각한 뒤 수정합니다.
- 직접 구현 문제에서는 요구사항에 맞게 코드를 작성합니다.
- `ANSWER.md`는 튜터 참고용 해설 자료입니다. 스스로 풀어본 뒤에 확인하세요.

## 제출 방법

문제를 해결한 후:

```bash
git add .
git commit -m "Solve week 1 Java basic problems"
git push origin solve/week-01
```

이후 GitHub에서 Pull Request를 생성합니다.

```text
base: week-01-java-basic
compare: solve/week-01
```

Pull Request를 생성하면 템플릿에 따라 해결한 문제, 어려웠던 부분, 질문을 작성합니다.

## 진행 흐름

```text
문제 확인
↓
학생이 직접 해결
↓
막히는 부분 질문
↓
튜터의 힌트 및 질의응답
↓
Git commit
↓
GitHub push
↓
Pull Request 제출
↓
튜터 코드 리뷰
↓
필요할 경우 수정
```

## 튜터 코드 리뷰 기준

1주차에서는 코드 스타일을 지나치게 엄격하게 평가하지 않습니다. 다음 항목을 중심으로 확인합니다.

- 조건문/반복문/배열 순회/메서드 작성과 호출을 할 수 있는가
- 매개변수와 반환값을 이해하는가
- 변수 값의 변화와 메서드 호출 순서를 추적할 수 있는가
- 요구사항을 이해하고, 지나치게 복잡하지 않게 구현했는가
- 자신의 코드를 스스로 설명할 수 있는가

## 1주차 완료 기준

모든 문제의 정답 여부만으로 평가하지 않습니다. 다음 세 가지를 달성하면 1주차 목표를 달성한 것으로 봅니다.

1. 자신의 Java 기본 문법 수준을 확인했다.
2. 문제 해결 과정에서 발생한 오류나 궁금한 점을 질문하고 수정했다.
3. GitHub에서 작업 branch 생성 → commit → push → Pull Request 제출 과정을 경험했다.
