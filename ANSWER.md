# ANSWER

## Part 1. Code Reading

### Q01_BorderLayout

- 실행 화면:

  ```text
  +----------------------------------+
  |                D                 |
  +------+---------------------------+
  |      |                           |
  |  C   |             B             |
  |      |                           |
  +------+---------------------------+
  |                A                 |
  +----------------------------------+
  ```

- 질문 1: `B`
- 질문 2: 빈 자리로 남지 않는다. `B`(CENTER)가 오른쪽 끝까지 늘어나 EAST 자리까지 차지한다.
- 질문 3: `A`, `B`, `D`
- 질문 4: `B`, `C`
- 해설:
  - 버튼의 위치는 `add`한 순서가 아니라 함께 넘긴 위치(`BorderLayout.SOUTH` 등)로 정해진다. `A`를 가장 먼저 넣었지만 아래쪽에 있다.
  - NORTH와 SOUTH는 창의 가로 폭을 꽉 채우고, 높이는 버튼에 필요한 만큼만 쓴다.
  - WEST와 EAST는 NORTH와 SOUTH 사이의 높이를 꽉 채우고, 폭은 버튼에 필요한 만큼만 쓴다.
  - CENTER는 남은 공간을 모두 쓴다. 비어 있는 영역이 있으면 그 자리까지 CENTER가 차지한다.
  - 그래서 가로 폭을 늘리면 가로를 꽉 채우는 `A`, `D`와 남은 공간을 쓰는 `B`가 넓어진다. 세로 높이를 늘리면 가운데 줄의 `C`, `B`가 높아진다.

### Q02_NestedPanel

- 창 그림:

  ```text
  +-----------------------------------+
  |       [New] [Open] [Save]         |
  +-----------+-----------+-----------+
  |           |           |           |
  |    B1     |    B2     |    B3     |
  |           |           |           |
  +-----------+-----------+-----------+
  |           |           |           |
  |    B4     |    B5     |           |  ← 빈 칸
  |           |           |           |
  +-----------+-----------+-----------+
  | Ready                             |
  +-----------------------------------+
  ```

- 포함 관계 그림:

  ```text
  frame (JFrame, BorderLayout)
  ├── NORTH:  top (JPanel, FlowLayout)
  │            ├── JButton "New"
  │            ├── JButton "Open"
  │            └── JButton "Save"
  ├── CENTER: center (JPanel, GridLayout 2줄 3칸)
  │            ├── JButton "B1"
  │            ├── JButton "B2"
  │            ├── JButton "B3"
  │            ├── JButton "B4"
  │            └── JButton "B5"
  └── SOUTH:  status (JLabel "Ready")
  ```

- 질문 1: 2줄 3칸이다. 첫째 줄에 `B1 B2 B3`, 둘째 줄에 `B4 B5`가 놓이고, 둘째 줄 오른쪽 끝이 빈 칸이다.
- 질문 2: 3개 (`top`, `center`, `status`). `New`, `Open`, `Save`와 `B1`~`B5`는 frame이 아니라 각 패널 안에 들어 있다.
- 질문 3: `New`, `Open`, `Save`는 크기가 그대로이고 가로 가운데에 모여 있다. `B1`~`B5`는 함께 넓어진다.
- 해설:
  - `new JPanel()`처럼 배치 관리자를 정하지 않은 패널은 FlowLayout이다. FlowLayout은 컴포넌트를 필요한 크기 그대로 한 줄로 놓고, 그 줄을 가운데 정렬한다. 창이 넓어져도 버튼 크기는 바뀌지 않는다.
  - GridLayout은 컨테이너를 같은 크기의 칸으로 나누고, 넣은 순서대로 왼쪽 위부터 한 줄씩 채운다. 칸은 컨테이너 크기를 따라 늘어나고 줄어든다.
  - 패널도 컴포넌트이므로 다른 컨테이너에 넣을 수 있다. frame에게 `top` 패널은 NORTH 자리를 차지하는 컴포넌트 하나일 뿐이다. 패널 안의 배치는 그 패널의 배치 관리자가 따로 정한다.

### Q03_ClickTrace

- 정답: `"A61"`
- 해설:

  | 시점 | count | label의 글자 |
  | --- | --- | --- |
  | TraceFrame을 만든 직후 | `5` | `start` |
  | A를 누른 뒤 | `6` | `A6` |
  | B를 누른 뒤 | `60` | `A6B60` |
  | A를 누른 뒤 | `61` | `A61` |

  - `addActionListener`는 버튼이 눌렸을 때 실행할 코드를 등록만 한다. 등록하는 줄에서는 `{ }` 안의 코드가 실행되지 않는다. 그래서 생성자가 끝났을 때 `count`는 등록 뒤에 대입한 `5`이고, 글자는 `start`이다.
  - `count`는 필드이므로 버튼을 누를 때마다 새로 만들어지지 않는다. 앞에서 바뀐 값이 그대로 남아 있다.
  - B는 `label.getText()`로 지금의 글자를 읽어 그 뒤에 붙인다.
  - A의 `setText("A" + count)`는 글자 전체를 바꾼다. `setText`는 기존 글자 뒤에 붙이는 것이 아니다. 그래서 마지막으로 A를 누르면 `A6B60`이 사라지고 `A61`만 남는다.

## Part 2. Debugging

### Q04_OnlyLastButton

- 증상: 오류 없이 실행되지만 `Blue` 버튼 하나가 창 전체를 차지한다. 콘솔에는 `components in frame: 3`이 출력된다. 버튼 3개가 모두 frame 안에 들어 있는데 2개가 보이지 않는다.

  ```text
  +-----------------------------+
  |                             |
  |            Blue             |
  |                             |
  +-----------------------------+
  ```

- 문제 원인: JFrame의 기본 배치 관리자는 BorderLayout이고, 위치를 지정하지 않고 `add`하면 CENTER에 들어간다. BorderLayout은 한 영역에 컴포넌트를 하나만 놓으므로, 나중에 넣은 버튼이 앞의 버튼 자리를 대신한다. 마지막에 넣은 `Blue`만 CENTER에 놓인다. `Red`와 `Green`은 frame 안에 들어 있지만 자리를 받지 못해 크기가 0이고 화면에 보이지 않는다.
- 수정 방법: frame의 배치 관리자를 FlowLayout으로 바꾼다.

  ```java
  JFrame frame = new JFrame("Q04");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLayout(new FlowLayout());
  ```

  버튼 3개를 `JPanel`(기본 FlowLayout)에 넣고 그 패널을 frame에 넣는 방법도 같은 화면을 만든다.
  버튼을 `BorderLayout.WEST`, `CENTER`, `EAST`에 하나씩 넣으면 3개가 보이기는 하지만, 가운데 버튼만 크게 늘어나 기대 화면과 다르다.
- 수정 후 화면:

  ```text
  +-----------------------------+
  |    [Red] [Green] [Blue]     |
  +-----------------------------+
  ```

### Q05_KeypadLoop

- 증상: 오류 없이 실행되지만 `9`가 적힌 버튼 하나만 창 위쪽 1/3을 가로로 꽉 채운다. 콘솔에는 `buttons in keypad: 1`이 출력된다. `add`를 9번 했는데 버튼은 1개이다.

  ```text
  +-------------------+
  |         9         |
  +-------------------+
  |                   |
  |                   |
  |                   |
  +-------------------+
  ```

- 문제 원인: `new JButton()`을 반복문 밖에서 한 번만 실행했다. 버튼 객체는 하나뿐이고, `button` 변수는 반복 내내 그 객체를 가리킨다. 반복할 때마다 그 버튼 하나의 글자를 바꾸고 같은 객체를 다시 `add`하므로 마지막 글자 `9`만 남는다. 컴포넌트 하나는 화면의 한 자리에만 놓일 수 있어서, 이미 들어 있는 버튼을 다시 `add`해도 패널 안의 버튼 수는 늘지 않는다. 2주차 Q05 partA와 원인이 같다.
  - 버튼이 위쪽 1/3을 가로로 채우는 이유: `GridLayout(3, 3)`은 줄 수 3을 지키고, 칸 수는 들어 있는 컴포넌트 수에 맞춰 다시 계산한다. 컴포넌트가 1개이면 3줄 1칸이 되어 첫째 줄 전체를 차지한다.
- 수정 방법: 반복할 때마다 새 버튼을 만든다.

  ```java
  JPanel keypad = new JPanel(new GridLayout(3, 3));

  for (int i = 1; i <= 9; i++) {
      JButton button = new JButton(String.valueOf(i));
      keypad.add(button);
  }
  ```

- 수정 후: 콘솔에 `buttons in keypad: 9`가 출력되고, 화면은 다음과 같다.

  ```text
  +-------------------+
  |  [1]  [2]  [3]    |
  |  [4]  [5]  [6]    |
  |  [7]  [8]  [9]    |
  +-------------------+
  ```

### Q06_LabelNotUpdating

- 증상: +1을 누르면 콘솔에는 `count = 1`, `count = 2`, `count = 3`이 출력되지만 화면의 숫자는 `0`에서 바뀌지 않는다. `count`는 제대로 늘어나고 있고, 화면만 바뀌지 않는다.
- 문제 원인: 생성자 안의 `JLabel label = new JLabel("0");`은 필드 `label`과 이름이 같은 지역 변수를 새로 선언한다. 그래서 `JLabel` 객체가 두 개 생긴다. `add(label)`로 화면에 붙은 것은 지역 변수가 가리키는 레이블이고, `increase()`가 글자를 바꾸는 것은 필드가 가리키는 레이블이다. 필드의 레이블은 어디에도 `add`되지 않았으므로 글자를 바꿔도 화면에 나타나지 않는다. 2주차 Q04의 `name = name`처럼 지역 변수가 같은 이름의 필드를 가린 것이다.

  ```text
   변수(상자)                     객체

   this.label  [ ● ] ──────▶  JLabel "3"   ← increase()가 바꾸는 레이블 (화면에 없음)
   label       [ ● ] ──────▶  JLabel "0"   ← add(label)로 화면에 붙은 레이블
  ```

  생성자 안에서는 지역 변수를 선언한 줄 아래부터 `label`이 지역 변수를 가리킨다. `increase()`에는 그런 지역 변수가 없으므로 `label`이 필드를 가리킨다.
- 수정 방법: 생성자의 지역 변수 선언 줄을 지운다. 그러면 `add(label)`의 `label`이 필드를 가리킨다. 화면에 붙은 레이블과 `increase()`가 바꾸는 레이블이 같은 객체가 된다.

  ```java
  JButton plus = new JButton("+1");
  plus.addActionListener(e -> increase());

  add(plus);
  add(label);
  ```

  `JLabel`을 빼고 `label = new JLabel("0");`으로 고쳐도 같은 결과가 나온다. 이때는 필드가 새로 만든 레이블을 가리키고, 처음 필드에서 만든 레이블은 쓰이지 않는다.
- 수정 후 화면 (+1을 세 번 누른 뒤):

  ```text
  +-------------------+
  |     [+1]  3       |
  +-------------------+
  ```

## Part 3. Implementation

### Q07_Keypad

```java
// 1단계
JTextField display = new JTextField();
frame.add(display, BorderLayout.NORTH);

// 2단계
JPanel keypad = new JPanel(new GridLayout(4, 3));
for (String key : keys) {
    JButton button = new JButton(key);
    keypad.add(button);
}
frame.add(keypad, BorderLayout.CENTER);

// 3단계
JPanel bottom = new JPanel();
JButton call = new JButton("Call");
JButton clear = new JButton("Clear");
bottom.add(call);
bottom.add(clear);
frame.add(bottom, BorderLayout.SOUTH);
```

- 해설:
  - 창 전체는 위, 가운데, 아래 세 부분이므로 frame의 기본 배치 관리자인 BorderLayout을 그대로 쓴다.
  - 가운데 버튼들은 같은 크기로 창을 따라 늘어나야 하므로 `GridLayout(4, 3)` 패널에 넣는다.
  - 아래쪽 버튼들은 크기가 그대로이고 가운데에 모여야 하므로 FlowLayout 패널(`new JPanel()`)에 넣는다. 패널 없이 frame의 SOUTH에 버튼을 바로 넣으면 SOUTH 한 자리에는 하나만 놓이고, 그 버튼이 가로 폭을 꽉 채운다.
  - 반복할 때마다 `new JButton(key)`로 새 버튼을 만든다. 반복문 밖에서 하나만 만들면 Q05와 같은 문제가 생긴다.
  - `for (int i = 0; i < keys.length; i++)`와 `new JButton(keys[i])`로 써도 같다.

**4단계 (선택)**

```java
for (String key : keys) {
    JButton button = new JButton(key);
    button.addActionListener(e -> display.setText(display.getText() + key));
    keypad.add(button);
}

// 3단계의 clear 버튼을 만든 뒤
clear.addActionListener(e -> display.setText(""));
```

- 해설:
  - 버튼마다 리스너를 따로 등록한다. 각 리스너는 자기 버튼을 만들 때의 `key`를 기억한다.
  - `display.getText()`로 지금 글자를 읽고, 뒤에 `key`를 붙여 `setText`로 바꾼다.
  - 인덱스 반복문의 람다식 안에서 `keys[i]`를 쓰면 컴파일 오류(`local variables referenced from a lambda expression must be final or effectively final`)가 난다. `i`는 반복할 때마다 바뀌는 변수이기 때문이다. 반복문 안에서 `String key = keys[i];`처럼 새 변수에 담아서 쓰면 된다.

### Q08_ScoreForm

```java
ScoreFrame() {
    setTitle("Q08");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // 1단계
    setLayout(new GridLayout(3, 2));
    add(new JLabel("Name"));
    add(nameField);
    add(new JLabel("Score"));
    add(scoreField);
    add(checkButton);
    add(resultLabel);

    // 2단계
    checkButton.addActionListener(e -> check());

    setSize(300, 130);
    setVisible(true);
}

void check() {
    // 3단계
    String name = nameField.getText();
    int score = Integer.parseInt(scoreField.getText());
    Student student = new Student(name, score);
    resultLabel.setText(student.info());
}
```

- 해설:
  - `GridLayout(3, 2)`는 넣은 순서대로 왼쪽 위부터 한 줄에 2개씩 채운다. 그래서 `Name` 레이블, 이름 입력칸, `Score` 레이블, 점수 입력칸, 버튼, 결과 레이블 순서로 넣는다.
  - `getText()`는 입력칸의 글자를 `String`으로 돌려준다. 점수 `"85"`는 글자이므로 `Integer.parseInt`로 `int` 값 `85`로 바꿔야 `Student` 생성자에 넣을 수 있다.
  - 결과를 보이려면 화면에 붙어 있는 `resultLabel`의 `setText`를 호출한다. `new JLabel(...)`로 레이블을 새로 만들면 화면에 붙어 있지 않으므로 보이지 않는다. (Q06 참고)
  - `Student`는 화면에 대해 아무것도 모른다. 창은 입력을 읽어 `Student` 객체를 만들고, 그 객체가 돌려준 글자를 표시할 뿐이다.
- 결과:

  | Name | Score | Check를 누른 뒤 resultLabel |
  | --- | --- | --- |
  | `Kim` | `85` | `Kim: 85 (PASS)` |
  | `Lee` | `40` | `Lee: 40 (FAIL)` |

**4단계 (선택)**

- 3단계까지만 작성하고 점수 칸에 `abc`를 넣어 Check를 누르면, 콘솔에 아래 예외가 출력되고 resultLabel은 바뀌지 않는다. 창은 꺼지지 않는다.

  ```text
  Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: "abc"
  ```

- `Integer.parseInt`가 던지는 `NumberFormatException`을 `try-catch`로 잡는다.

  ```java
  void check() {
      String name = nameField.getText();
      try {
          int score = Integer.parseInt(scoreField.getText());
          Student student = new Student(name, score);
          resultLabel.setText(student.info());
      } catch (NumberFormatException ex) {
          resultLabel.setText("Score must be a number");
      }
  }
  ```

  점수를 숫자로 바꾸지 못하면 `try` 안의 나머지 줄은 실행되지 않고 바로 `catch`로 넘어간다.

### Q09_BankAccountGUI

- 단계 예시 (Withdraw):
  1. 입력칸의 글자를 읽어 `int` 금액으로 바꾼다.
  2. `account.withdraw(금액)`을 호출한다.
  3. 결과가 `true`이면 잔액 표시를 `account.balance`로 바꾸고, 메시지를 비운다.
  4. 결과가 `false`이면 메시지에 `Withdraw failed`를 표시한다.

```java
// 생성자의 TODO 자리
depositButton.addActionListener(e -> depositClicked());
withdrawButton.addActionListener(e -> withdrawClicked());
```

```java
void depositClicked() {
    int amount = Integer.parseInt(amountField.getText());
    account.deposit(amount);
    balanceLabel.setText("Balance: " + account.balance);
    messageLabel.setText("");
}

void withdrawClicked() {
    int amount = Integer.parseInt(amountField.getText());
    if (account.withdraw(amount)) {
        balanceLabel.setText("Balance: " + account.balance);
        messageLabel.setText("");
    } else {
        messageLabel.setText("Withdraw failed");
    }
}
```

- 해설:
  - 잔액은 `account` 객체 한 곳에만 있다. 창은 버튼이 눌리면 그 객체의 메서드를 호출하고, 바뀐 `account.balance`를 읽어 레이블에 다시 표시한다.
  - `account.balance`가 바뀌어도 레이블의 글자는 저절로 바뀌지 않는다. 화면에 붙어 있는 `balanceLabel`의 `setText`를 호출해야 화면이 바뀐다.
  - 레이블의 숫자에 금액을 직접 더하고 빼서 표시하면, `BankAccount`가 거절한 출금(잔액보다 큰 금액, 0 이하의 금액)까지 화면의 숫자에 반영되어 객체의 잔액과 화면의 숫자가 달라질 수 있다.
  - 성공과 실패는 `withdraw`가 돌려주는 `boolean`으로 나눈다. 성공했을 때 메시지를 비우지 않으면, 앞에서 실패했을 때의 `Withdraw failed`가 계속 남아 있다.
- 결과:

  | 입력 | 버튼 | 잔액 표시 | 메시지 |
  | --- | --- | --- | --- |
  | `500` | Deposit | `Balance: 1500` | (없음) |
  | `2000` | Withdraw | `Balance: 1500` | `Withdraw failed` |
  | `300` | Withdraw | `Balance: 1200` | (없음) |
