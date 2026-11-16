# Week 03 — 클래스와 ArrayList

## 이번 주 목표

이번 주에는 새로운 내용을 많이 늘리지 않고, 지난 시간에 어려웠던 **클래스와 객체**를 `ArrayList`와 연결합니다.

한 명의 학생을 나타내는 `Student`와 여러 학생을 관리하는 `StudentManager`를 만들면서 다음 내용을 확인합니다.

- 클래스와 객체가 어떻게 다른지 설명한다.
- 두 변수가 같은 객체를 가리킬 때 어떤 일이 생기는지 설명한다.
- `ArrayList<Student>`에 객체를 추가하고, 꺼내고, 반복해서 처리한다.
- 목록에서 원하는 객체를 찾아 수정한다.
- 한 클래스가 다른 객체 여러 개를 관리하도록 역할을 나눈다.

모든 결과는 콘솔에서 확인합니다.

## 문제 수와 시간

지난 시간에는 1시간 안에 9문제를 모두 해결하기 어려웠습니다. 이번에는 문제 수를 줄이고 한 문제 안에서 단계별로 확인합니다.

| 구분 | 문제 | 권장 시간 | 내용 |
| --- | --- | ---: | --- |
| 필수 | Q01 | 5~8분 | 같은 객체를 가리키는 변수 추적 |
| 필수 | Q02 | 8~10분 | 새 객체와 목록 속 기존 객체 구분 |
| 필수 | Q03 | 10~12분 | ArrayList 추가·조회·수정·반복 |
| 필수 | Q04 | 20~25분 | StudentManager 구현 |
| 추가 | Q05 | 10~15분 | 최고 점수와 평균 |
| 추가 | Q06 | 15~20분 | 중복·점수 범위·삭제 규칙 |

**1시간의 목표는 Q01~Q04입니다.** Q05와 Q06은 수업 중 반드시 풀어야 하는 문제가 아닙니다. 필수 문제를 빨리 끝낸 학생이나 복습할 학생이 풉니다.

Q04를 완성하지 못했더라도 어디까지 구현했고 무엇이 막혔는지 설명할 수 있으면 수업을 이어갈 수 있습니다.

## 시작하기 전에

1. 저장소를 fork하고 clone합니다. 아직 하지 않았다면 `main` branch의 README를 먼저 확인합니다.
2. 이 주차 branch를 기준으로 자신의 풀이 branch를 만듭니다.

   ```bash
   git fetch upstream
   git switch -c solve/week-03 upstream/week-03-class-arraylist
   ```

3. Q01부터 순서대로 풉니다. 처음부터 Q05나 Q06을 먼저 풀지 않습니다.
4. 막히면 완성 코드를 바로 보지 말고, 현재 변수와 객체를 종이에 그린 뒤 튜터에게 질문합니다.

## 프로젝트 구조

```text
README.md
ANSWER.md

src/
├── required/                    필수 문제
│   ├── Q01_ReferenceCheck.java
│   ├── Q02_ListUpdateBug.java
│   ├── Q03_StudentList.java
│   └── Q04_StudentManager.java
│
└── extension/                   추가 문제
    ├── Q05_StudentReport.java
    └── Q06_ManagerRules.java
```

각 파일은 독립적으로 실행할 수 있습니다. IntelliJ에서 파일을 열어 실행하거나 다음처럼 컴파일합니다.

```bash
javac -g src/required/Q01_ReferenceCheck.java -d out
java -cp out Q01_ReferenceCheck
```

## ArrayList를 쓰기 전에

### 객체를 만드는 코드와 변수를 복사하는 코드는 다릅니다

```java
Student a = new Student("Kim", 80);
Student b = a;
Student c = new Student("Kim", 80);
```

`new Student(...)`를 실행할 때만 새 객체가 생깁니다. `Student b = a`는 객체를 새로 만들지 않고, `b`도 `a`와 같은 객체를 가리키게 합니다.

```text
a ──┐
    ├──> Student("Kim", 80)
b ──┘

c ─────> Student("Kim", 80)
```

따라서 `b.score`를 바꾸면 `a.score`로 읽은 값도 바뀝니다. 반면 `c`는 값이 같아 보여도 따로 만든 객체입니다.

### ArrayList의 칸도 객체를 가리킵니다

```java
ArrayList<Student> students = new ArrayList<>();
Student kim = new Student("Kim", 85);
students.add(kim);
```

목록의 칸에는 `Student` 객체를 가리키는 값이 들어갑니다.

```text
kim ───────────────┐
                   v
students [ 0 ] ──> Student("Kim", 85)
```

`students.get(0)`은 0번 칸이 가리키는 `Student` 객체를 돌려줍니다. 그 객체의 필드를 바꾸면 목록에서도 바뀐 상태가 보입니다.

### import는 왜 필요한가요?

```java
import java.util.ArrayList;
```

`ArrayList`는 Java가 제공하는 `java.util` 패키지 안에 있습니다. `import`는 이 파일에서 그 클래스를 짧은 이름인 `ArrayList`로 사용하겠다는 뜻입니다.

이번 문제에서는 패키지를 직접 만들거나 모듈을 구성하지 않습니다. 먼저 `Student`와 `ArrayList<Student>`의 관계에 집중합니다.

파일 안의 `static class Student`는 예제 하나를 파일 하나로 실행하기 위해 넣은 중첩 클래스입니다. 이번 주에는 `static` 자체를 암기하지 않아도 됩니다.

## 문제 진행 방법

### Q01 — 실행 전에 예상하기

코드를 실행하기 전에 질문에 답하고, 변수와 객체를 화살표로 그립니다. 실행 후 예상과 다른 부분이 있다면 처음 답을 지우지 말고 차이를 적습니다.

### Q02 — 원인을 찾은 뒤 한 줄만 고치기

먼저 실제 출력을 확인합니다. `first`가 새 객체를 가리키게 되었을 때 `students`의 0번 칸이 가리키는 객체도 바뀌는지 그림으로 확인합니다. 증상만 맞추려고 `main`의 출력 코드를 바꾸지 않습니다.

### Q03 — 짧은 단계마다 실행하기

학생 추가, 점수 수정, 학생 수 출력, 전체 출력 순서로 진행합니다. 모든 TODO를 한꺼번에 작성하지 않습니다.

### Q04 — StudentManager의 역할 생각하기

`Student`는 학생 한 명의 상태를 가지고, `StudentManager`는 여러 학생의 목록을 관리합니다. 메서드를 작성하기 전에 아래 질문에 답합니다.

1. `addStudent`가 받아야 하는 값은 무엇인가?
2. `findByName`은 이름을 찾은 뒤 무엇을 반환해야 하는가?
3. 학생을 찾지 못했다는 것을 어떻게 나타낼 수 있는가?
4. `updateScore`가 성공 여부를 반환하면 호출한 쪽에서 무엇을 알 수 있는가?

## 문제 풀이 규칙

- 필수 문제는 Q01부터 순서대로 풉니다.
- 코드를 실행하기 전에 결과를 한 번 예상합니다.
- TODO 한 단계를 끝낼 때마다 컴파일하고 실행합니다.
- 오류가 나면 오류 메시지의 첫 부분과 자신이 방금 바꾼 코드를 함께 확인합니다.
- 막히면 변수, ArrayList의 칸, 객체를 상자와 화살표로 그립니다.
- `ANSWER.md`는 스스로 시도한 뒤 확인합니다.
- 추가 문제를 풀지 않았다는 이유로 미완료로 보지 않습니다.

## 제출 방법

풀이한 문제만 저장해서 제출합니다.

```bash
git add src
git commit -m "Solve week 3 class and ArrayList problems"
git push -u origin solve/week-03
```

GitHub에서 Pull Request를 만들 때 다음처럼 지정합니다.

```text
base repository: JJong2003/26_Tutor
base: week-03-class-arraylist
head repository: 자신의 fork
compare: solve/week-03
```

Pull Request는 튜터에게 풀이를 보여주고 리뷰를 받기 위한 것입니다. 학생이 직접 merge하지 않습니다.

## 3주차 완료 기준

모든 추가 문제의 정답 여부로 평가하지 않습니다. 다음 내용을 할 수 있으면 이번 목표를 달성한 것으로 봅니다.

1. `new`를 실행했을 때와 변수만 복사했을 때의 차이를 그림으로 설명한다.
2. `ArrayList<Student>`에 객체를 추가하고, 꺼내고, 반복해서 출력한다.
3. 목록에서 이름이 같은 기존 객체를 찾아 점수를 수정한다.
4. `Student`와 `StudentManager`가 맡은 역할을 각각 설명한다.
