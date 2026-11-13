# Week 03 — GUI 기초

## 3주차 목표

이번 주 목표는 GUI 화면을 **객체들이 서로 담고 있는 구조**로 읽고, 직접 만들고, 버튼으로 화면을 바꿔보는 것입니다.

창, 패널, 버튼, 레이블은 모두 `new`로 만드는 객체입니다.
2주차에 배열의 칸이 `Student` 객체를 가리켰던 것처럼, 패널은 자기 안에 넣은 버튼 객체들을 가리킵니다.
그래서 2주차의 상자와 화살표 그림이 이번 주에도 그대로 쓰입니다.

이번 주에 확인할 것은 세 가지입니다.

- 컨테이너(창, 패널) 안에 어떤 컴포넌트가 들어 있는지
- 배치 관리자가 컴포넌트를 어디에 어떤 크기로 놓는지
- 버튼을 눌렀을 때 화면을 바꾸려면 **어떤 객체**의 메서드를 호출해야 하는지

## 시작하기 전에

1. 저장소를 fork하고 clone합니다. 아직 하지 않았다면 `main` branch의 README "사용 방법"을 먼저 따라 합니다.
2. 이 branch(`week-03-gui`)를 기준으로 자신의 작업 branch를 만듭니다.

   ```bash
   git fetch upstream
   git switch -c solve/week-03 upstream/week-03-gui
   ```

3. 아래 "GUI 프로그램 기본 틀"과 "그림 그리는 방법"을 먼저 읽습니다.
4. 아래 "문제 구성"을 참고하여 문제를 풉니다.
5. 문제를 다 풀었거나 시간이 다 되었으면 "제출 방법"에 따라 Pull Request를 생성합니다.

## 프로젝트 구조

```text
README.md
ANSWER.md

src/
├── reading/               Part 1. Code Reading
│   ├── Q01_BorderLayout.java
│   ├── Q02_NestedPanel.java
│   └── Q03_ClickTrace.java
│
├── debugging/             Part 2. Debugging
│   ├── Q04_OnlyLastButton.java
│   ├── Q05_KeypadLoop.java
│   └── Q06_LabelNotUpdating.java
│
└── implementation/        Part 3. Implementation
    ├── Q07_Keypad.java
    ├── Q08_ScoreForm.java
    └── Q09_BankAccountGUI.java
```

각 파일은 `javac`로 개별 컴파일하거나, IDE(IntelliJ 등)에서 해당 파일을 열어 실행(Run)하면 됩니다.

```bash
javac -g src/reading/Q01_BorderLayout.java -d out
java -cp out Q01_BorderLayout
```

이번 주 문제를 실행하면 창이 열립니다. 창을 닫으면 프로그램이 끝납니다.
창이 보이지 않으면 다른 창 뒤에 열렸을 수 있으니 작업 표시줄을 확인하세요.

`CounterFrame` 같은 클래스는 2주차처럼 `public class` 안에 `static class`로 들어 있습니다.
파일 하나만으로 실행되게 하려는 것이고, `static`은 지금은 신경 쓰지 않아도 됩니다.

## GUI 프로그램 기본 틀

```java
JFrame frame = new JFrame("Title");                        // 1. 창 객체를 만든다
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // 2. 창을 닫으면 프로그램도 끝나게 한다
frame.add(new JButton("OK"), BorderLayout.CENTER);         // 3. 창에 컴포넌트를 넣는다
frame.setSize(300, 200);                                   // 4. 창 크기를 정한다
frame.setVisible(true);                                    // 5. 창을 화면에 보이게 한다
```

| 빠뜨린 줄 | 일어나는 일 |
| --- | --- |
| 2 | 창을 닫아도 프로그램이 끝나지 않습니다. IntelliJ에서는 빨간 정지 버튼으로 끝냅니다. |
| 4 | 창이 아주 작게 열립니다. |
| 5 | 창이 보이지 않습니다. |

- `frame.add(...)`는 실제로는 창 안의 **content pane**(내용 영역)이라는 패널에 컴포넌트를 넣습니다. 이번 주에는 창에 넣는다고 생각해도 됩니다. Q04의 `frame.getContentPane()`이 그 패널입니다.
- 컨테이너마다 기본 배치 관리자가 정해져 있습니다. 다른 배치 관리자를 쓰려면 `setLayout(...)`으로 바꾸거나, `new JPanel(new GridLayout(2, 3))`처럼 만들 때 정합니다.

| 컨테이너 | 기본 배치 관리자 |
| --- | --- |
| `JFrame` | `BorderLayout` |
| `JPanel` | `FlowLayout` |

### 버튼을 눌렀을 때 실행할 코드 (이벤트 처리)

```java
JButton button = new JButton("+1");
button.addActionListener(e -> {
    // 버튼을 누를 때마다 실행되는 코드
});
```

- `addActionListener`는 "이 버튼이 눌리면 `{ }` 안의 코드를 실행해 달라"고 **등록**하는 것입니다. 등록하는 줄에서는 `{ }` 안의 코드가 실행되지 않습니다.
- 위 코드는 람다식(`e -> { ... }`)으로 썼습니다. 교재의 다른 방법(익명 클래스, 리스너 클래스를 따로 만들기 등)으로 써도 됩니다.
- 버튼을 누를 때마다 바뀌고 계속 남아 있어야 하는 값(예: 누른 횟수)은 **필드**에 둡니다. 람다식 안에서 지역 변수의 값을 바꾸려고 하면 다음 컴파일 오류가 납니다.

  ```text
  local variables referenced from a lambda expression must be final or effectively final
  ```

- 이벤트 문제의 창은 교재처럼 `JFrame`을 상속한 클래스(`XxxFrame extends JFrame`)로 만들었습니다. 생성자 안의 `add(...)`, `setTitle(...)`은 `this.add(...)`처럼 이 창 객체 자신의 메서드를 호출하는 것입니다.
- 버튼을 눌렀는데 아무 반응이 없으면 콘솔에 예외가 출력되었는지 확인하세요. GUI 프로그램은 버튼을 처리하다가 예외가 나도 창이 꺼지지 않습니다.

## 그림 그리는 방법

이번 주에는 두 가지 그림을 그립니다. 아래 코드로 예를 들어보겠습니다.

```java
JFrame frame = new JFrame("Example");

JPanel bottom = new JPanel();
bottom.add(new JButton("OK"));
bottom.add(new JButton("Cancel"));

frame.add(new JLabel("Hello"), BorderLayout.CENTER);
frame.add(bottom, BorderLayout.SOUTH);
```

**창 그림**: 실제 화면처럼 그립니다. 버튼은 `[OK]`처럼, 레이블은 글자만 적습니다. 대략적인 위치와 크기가 드러나면 됩니다.

```text
+--------------------------------+
|                                |
| Hello                          |
|                                |
+--------------------------------+
|          [OK] [Cancel]         |
+--------------------------------+
```

**포함 관계 그림**: 어느 컨테이너 안에 어떤 컴포넌트가 들어 있는지 그립니다. 컨테이너마다 배치 관리자도 적습니다.

```text
frame (JFrame, BorderLayout)
├── CENTER: JLabel "Hello"
└── SOUTH:  bottom (JPanel, FlowLayout)
             ├── JButton "OK"
             └── JButton "Cancel"
```

- 컨테이너는 자기 안에 넣은 컴포넌트 객체를 가리키는 화살표들을 들고 있다고 생각하면 됩니다. 2주차에 배열의 칸이 `Student` 객체를 가리키던 것과 같습니다.
- `new`를 실행할 때마다 컴포넌트 객체가 하나 새로 생깁니다. 화면에 보이는 버튼 하나는 객체 하나입니다.
- 디버깅 문제에서는 2주차처럼 변수와 객체를 상자와 화살표로 그리는 그림도 함께 쓰입니다.

## 문제 구성

```text
Part 1. Code Reading       (Q01 ~ Q03)
Part 2. Debugging          (Q04 ~ Q06)
Part 3. Implementation     (Q07 ~ Q09)
```

### 필수 문제

```text
Q01, Q02, Q04, Q06, Q07, Q08
```

먼저 이 문제들을 풉니다.

### 추가 문제

```text
Q03, Q05, Q09
```

필수 문제를 빨리 해결했다면 추가로 풀어봅니다. 모든 문제를 반드시 풀어야 하는 것은 아닙니다.
Q03과 Q05는 필수 문제를 이해했는지 확인하는 문제이므로 시도해보길 권합니다.

## Part 1. 코드 읽기 문제 규칙

Q01, Q02는 창 모양을 예상하는 문제이고, Q03은 2주차처럼 `myAnswer`에 예상값을 적는 문제입니다.

```text
[코드 읽기 문제 규칙]

1. 코드를 실행하기 전에 먼저 결과를 예상한다.
   Q01은 창 그림을, Q02는 창 그림과 포함 관계 그림을 그리고, 파일의 질문에 예상 답을 적는다.
   Q03은 myAnswer에 예상값을 적는다.
2. 코드는 수정하지 않는다. 예상 답과 myAnswer만 적는다.
3. 실행해서 예상과 비교한다. 창의 크기도 바꿔본다.
4. 예상과 다르면 예상 답을 고치지 말고, "예상과 다른 점"에 무엇이 달랐는지 적는다.
5. 단순히 여러 값을 넣어보면서 정답을 찾는 방식은 지양한다.
6. Q01, Q02의 예상 그림과 실행 화면 캡처를 Pull Request에 첨부한다.
```

화면 캡처는 Windows에서는 `Win + Shift + S`, Mac에서는 `Cmd + Shift + 4`로 할 수 있습니다.

## Part 2. 디버깅 문제

이번 주 디버깅 문제(Q04~Q06)는 오류 메시지 없이 실행됩니다. 대신 화면이 요구사항과 다릅니다.
파일 상단의 기대 화면과 실제 화면, 콘솔 출력을 비교해서 원인을 찾으세요. 오류가 있는 위치는 알려주지 않습니다.

```text
[디버깅 문제 규칙]

1. 먼저 실행해서 실제 화면과 콘솔 출력을 확인한다.
2. 기대 화면과 무엇이 다른지 적어보고, 그 차이를 근거로 원인을 추측한다.
3. 단순히 값을 이것저것 바꿔보는 방식은 지양한다.
4. 증상만 가리지 말고 원인을 수정한다.
5. 수정 후 다시 실행해서 화면이 요구사항과 맞는지 확인한다.
6. 원인을 한 줄로 설명한다.
   파일 상단의 "원인:" 주석에 적고,
   Pull Request의 "디버깅 문제의 원인"에도 적는다.
```

## Part 3. 직접 구현 문제

직접 구현 문제(Q07~Q09)는 요구사항에 맞는 코드를 작성합니다. 각 파일 상단의 주석과 `TODO`를 참고하세요.

```text
[직접 구현 문제 규칙]

1. 코드를 쓰기 전에 필요한 단계를 한국어로 먼저 적는다.
   (Q07, Q08은 단계가 주어져 있다. Q09는 파일 상단의 빈칸에 직접 적는다.)
2. 한 단계를 코드로 옮길 때마다 실행해서 화면을 확인한다.
3. 적어둔 단계는 지우지 말고 그대로 둔다.
4. 완성 화면과 크기, 간격까지 똑같지 않아도 된다.
   위치와 배치 방식(창 크기를 바꿀 때 어떻게 변하는지)이 요구사항과 맞으면 된다.
5. Q07과 Q08의 4단계는 선택이다.
```

## 문제 풀이 규칙

- 먼저 스스로 생각합니다.
- 막히는 경우 튜터에게 질문합니다.
- 코드 읽기 문제에서는 예상 답과 `myAnswer`만 적습니다. 다른 코드는 임의로 수정하지 않습니다.
- 디버깅 문제에서는 오류 원인을 생각한 뒤 수정합니다.
- 직접 구현 문제에서는 요구사항에 맞게 코드를 작성합니다.
- `ANSWER.md`에는 정답과 해설이 있습니다. 스스로 풀어본 뒤에 확인하세요.

## 제출 방법

문제를 해결한 후:

```bash
git add .
git commit -m "Solve week 3 GUI problems"
git push -u origin solve/week-03
```

`origin`은 자신의 fork입니다. 이후 GitHub에서 Pull Request를 생성합니다.
`JJong2003/26_Tutor` 저장소의 Pull requests → New pull request → compare across forks를 선택하고 아래처럼 지정합니다.

```text
base repository: JJong2003/26_Tutor
base: week-03-gui
head repository: 자신의 fork
compare: solve/week-03
```

base가 `main`으로 되어 있으면 반드시 `week-03-gui`로 바꿔주세요.
Pull Request는 코드를 합치기 위한 것이 아니라 리뷰를 받기 위한 것입니다. 합치지(merge) 않습니다.

Pull Request를 생성하면 템플릿에 따라 해결한 문제, 디버깅 문제의 원인, 그림, 어려웠던 부분, 질문을 작성합니다.
"그림"에는 Q01, Q02의 예상 그림 사진과 실행 화면 캡처를 함께 첨부합니다. 사진과 캡처는 Pull Request 설명창에 끌어다 놓으면 첨부됩니다.

## 진행 흐름

```text
GUI 프로그램 기본 틀 확인
↓
창 그림, 포함 관계 그림 그리기
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

## 3주차 완료 기준

모든 문제의 정답 여부만으로 평가하지 않습니다. 다음 세 가지를 달성하면 3주차 목표를 달성한 것으로 봅니다.

1. 코드를 보고 실행하기 전에 창 모양과 포함 관계를 그림으로 예상했고, 실제 화면과 비교했다.
2. 패널과 배치 관리자를 조합해서 요구한 화면을 직접 만들었다.
3. 버튼을 눌렀을 때 화면에 붙어 있는 컴포넌트 객체의 값을 바꾸는 코드를 작성했다.
