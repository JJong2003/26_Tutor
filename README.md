# Week 02 — 클래스와 객체

## 2주차 목표

이번 주 목표는 클래스로 객체를 만들어 쓰고,
**변수와 메서드에 값이 어떻게 전달되는지** 그림으로 설명할 수 있게 되는 것입니다.

1주차 Q15에서 메서드 안에서 바꾼 값이 `main`에 남지 않았던 이유를 기억하나요?
이번 주에는 같은 요구사항을 객체로 다시 풀어보고, 무엇이 같고 무엇이 달라지는지 확인합니다.

## 시작하기 전에

1. 저장소를 fork하고 clone합니다. 아직 하지 않았다면 `main` branch의 README "사용 방법"을 먼저 따라 합니다.
2. 이 branch(`week-02-class-object`)를 기준으로 자신의 작업 branch를 만듭니다.

   ```bash
   git fetch upstream
   git switch -c solve/week-02 upstream/week-02-class-object
   ```

3. 아래 "문제 구성"을 참고하여 문제를 풉니다.
4. 문제를 다 풀었거나 시간이 다 되었으면 "제출 방법"에 따라 Pull Request를 생성합니다.

## 프로젝트 구조

```text
README.md
ANSWER.md

src/
├── reading/               Part 1. Code Reading
│   ├── Q01_ObjectState.java
│   ├── Q02_ReferenceCopy.java
│   └── Q03_ObjectParam.java
│
├── debugging/             Part 2. Debugging
│   ├── Q04_ThisBug.java
│   └── Q05_ObjectArray.java
│
└── implementation/        Part 3. Implementation
    ├── Q06_Student.java
    ├── Q07_AddBonus.java
    ├── Q08_TopStudent.java
    └── Q09_BankAccount.java
```

각 파일은 `javac`로 개별 컴파일하거나, IDE(IntelliJ 등)에서 해당 파일을 열어 실행(Run)하면 됩니다.

```bash
javac -g src/reading/Q01_ObjectState.java -d out
java -cp out Q01_ObjectState
```

각 파일의 `Student` 같은 클래스는 `public class` 안에 `static class`로 들어 있습니다.
파일 하나만으로 실행되게 하려는 것이고, `static`은 지금은 신경 쓰지 않아도 됩니다.
클래스를 별도 파일로 나누는 방법은 나중에 배웁니다.

## 그림 그리는 방법

이번 주 문제는 머릿속으로만 풀기 어렵습니다. 종이나 메모장에 아래 규칙으로 그림을 그려보세요.

```text
int n = 3;
Student s = new Student("Kim", 80);
```

```text
 변수(상자)                      객체

 n  [  3  ]

 s  [  ●  ] ─────────────────▶  Student
                                 name  = "Kim"
                                 score = 80
```

- 변수는 이름이 붙은 상자입니다.
- `int` 같은 기본 타입 상자에는 **값**이 들어 있습니다.
- `Student` 같은 객체 타입 상자에는 객체가 어디 있는지를 가리키는 **화살표**가 들어 있습니다.
- `new`를 실행할 때마다 객체가 하나 새로 생깁니다.
- 대입(`=`)과 메서드 호출은 모두 **상자 안의 내용을 복사**하는 일입니다. 무엇이 복사되는지 그림에서 확인하세요.

## 문제 구성

```text
Part 1. Code Reading       (Q01 ~ Q03)
Part 2. Debugging          (Q04 ~ Q05)
Part 3. Implementation     (Q06 ~ Q09)
```

### 필수 문제

```text
Q01, Q02, Q03, Q04, Q06, Q07
```

먼저 이 문제들을 풉니다.

### 추가 문제

```text
Q05, Q08, Q09
```

필수 문제를 빨리 해결했다면 추가로 풀어봅니다. 모든 문제를 반드시 풀어야 하는 것은 아닙니다.
Q05와 Q08은 필수 문제를 이해했는지 확인하는 문제이므로 시도해보길 권합니다.

## Part 1. 코드 읽기 문제 규칙

코드 읽기 문제(Q01~Q03)는 기존 코드를 수정하는 문제가 아닙니다.
코드를 읽고 실행 결과를 예상한 뒤, `myAnswer`에 예상값만 입력합니다.

```text
[코드 읽기 문제 규칙]

1. 코드를 실행하기 전에 먼저 실행 결과를 예상한다.
2. method 내부 로직은 수정하지 않는다.
3. TODO가 있는 myAnswer 값만 수정한다.
4. 실행 결과가 true라면 정답이다.
5. 단순히 여러 값을 넣어보면서 정답을 찾는 방식은 지양한다.
6. 반드시 변수와 객체를 그림으로 그리며 실행 흐름을 따라가 본다.
7. Q02, Q03의 그림은 Pull Request에 첨부한다.
```

## Part 2. 디버깅 문제

디버깅 문제(Q04~Q05)는 오류가 포함된 코드입니다. 코드를 실행해서 어떤 문제가 발생하는지, 왜 발생하는지 파악하고 직접 수정하세요.
오류가 있는 위치는 알려주지 않습니다. 실행 결과(오류 메시지, 기대 출력과의 차이)를 근거로 원인을 찾아야 합니다.

```text
[디버깅 문제 규칙]

1. 먼저 코드를 실행해서 어떤 결과나 오류가 나오는지 확인한다.
2. 오류 메시지나 실패한 입력을 근거로 원인을 추측한다.
3. 단순히 값을 이것저것 바꿔보는 방식은 지양한다.
4. 증상만 가리지 말고 원인을 수정한다. (오류가 난 줄만 피하도록 고치지 않는다.)
5. 수정 후 다시 실행해서 모든 결과가 요구사항과 맞는지 확인한다.
6. 원인을 한 줄로 설명한다.
   파일 상단의 "원인:" 주석에 적고,
   Pull Request의 "디버깅 문제의 원인"에도 적는다.
```

## Part 3. 직접 구현 문제

직접 구현 문제(Q06~Q09)는 요구사항에 맞는 코드를 처음부터 작성합니다. 각 파일 상단의 주석과 `TODO`를 참고하세요.

```text
[직접 구현 문제 규칙]

1. 코드를 쓰기 전에 필요한 단계를 한국어로 먼저 적는다.
   (Q06은 단계가 주어져 있다. Q08~Q09는 파일 상단의 빈칸에 직접 적는다.)
2. 한 단계를 코드로 옮길 때마다 실행해서 확인한다.
3. 적어둔 단계는 지우지 말고 그대로 둔다.
4. Q07의 질문에는 그림과 함께 답을 적는다.
```

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
git commit -m "Solve week 2 class and object problems"
git push -u origin solve/week-02
```

`origin`은 자신의 fork입니다. 이후 GitHub에서 Pull Request를 생성합니다.
`JJong2003/26_Tutor` 저장소의 Pull requests → New pull request → compare across forks를 선택하고 아래처럼 지정합니다.

```text
base repository: JJong2003/26_Tutor
base: week-02-class-object
head repository: 자신의 fork
compare: solve/week-02
```

base가 `main`으로 되어 있으면 반드시 `week-02-class-object`로 바꿔주세요.
Pull Request는 코드를 합치기 위한 것이 아니라 리뷰를 받기 위한 것입니다. 합치지(merge) 않습니다.

Pull Request를 생성하면 템플릿에 따라 해결한 문제, 디버깅 문제의 원인, 그림, 어려웠던 부분, 질문을 작성합니다.
그림은 종이에 그린 사진을 Pull Request 설명창에 끌어다 놓으면 첨부됩니다.

## 진행 흐름

```text
1주차 Q15 다시 확인
↓
변수와 객체 그림 그리기
↓
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

## 2주차 완료 기준

모든 문제의 정답 여부만으로 평가하지 않습니다. 다음 세 가지를 달성하면 2주차 목표를 달성한 것으로 봅니다.

1. `int` 변수와 객체 변수에서 `=`와 메서드 호출이 무엇을 복사하는지 그림으로 설명했다.
2. 필드, 생성자, 메서드를 가진 클래스를 직접 작성했다.
3. 코드를 쓰기 전에 단계를 적고 구현하는 과정을 경험했다.
