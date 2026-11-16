# ANSWER

스스로 문제를 시도한 뒤 확인하세요. 코드가 조금 달라도 요구사항과 결과가 같으면 정답이 될 수 있습니다.

## Q01_ReferenceCheck

- `new Student(...)`는 두 번 실행됩니다.
- 실제 `Student` 객체도 두 개입니다.
- `a`와 `b`는 같은 객체를 가리킵니다.
- `c`는 값이 같게 시작했지만 별도로 만든 객체를 가리킵니다.

실행 결과는 다음과 같습니다.

```text
a = Kim: 90
b = Kim: 90
c = Lee: 80
a == b: true
a == c: false
```

`b.score += 10`은 `b`가 가리키는 객체의 점수를 바꿉니다. `a`도 같은 객체를 가리키므로 `a.score`로 읽어도 90입니다. `c.name`을 바꿔도 `a`와 `b`가 가리키는 객체에는 영향이 없습니다.

```text
a ──┐
    ├──> Student("Kim", 90)
b ──┘

c ─────> Student("Lee", 80)
```

## Q02_ListUpdateBug

문제의 줄은 `first`가 목록의 기존 객체 대신 새 객체를 가리키게 합니다.

```java
Student first = students.get(0);
first = new Student("Kim", 100);
```

변수 `first`의 화살표만 새 객체로 이동합니다. `students`의 0번 칸은 여전히 처음 만든 `Student("Kim", 85)`를 가리킵니다.

새 객체를 만들지 않고 기존 객체의 필드를 바꿉니다.

```java
static void updateFirstStudent(ArrayList<Student> students) {
    Student first = students.get(0);
    first.score = 100;
}
```

원인 예시:

> `first`에 새 객체를 대입해도 목록의 0번 칸은 기존 객체를 계속 가리키므로 목록 속 학생의 점수가 바뀌지 않았다.

## Q03_StudentList

```java
public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();

    students.add(new Student("Kim", 85));
    students.add(new Student("Lee", 40));
    students.add(new Student("Park", 92));

    Student second = students.get(1);
    second.score = 70;

    System.out.println("학생 수: " + students.size());

    for (Student student : students) {
        System.out.println(student.info());
    }
}
```

`get(1)`인 이유는 ArrayList의 위치 번호가 0부터 시작하기 때문입니다. `get(1)`이 돌려준 객체는 목록의 1번 칸이 가리키는 객체와 같습니다. 따라서 `second.score`를 바꾸면 목록을 다시 순회할 때도 70이 출력됩니다.

## Q04_StudentManager

```java
static class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    Student findByName(String name) {
        for (Student student : students) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    boolean updateScore(String name, int newScore) {
        Student student = findByName(name);
        if (student == null) {
            return false;
        }

        student.score = newScore;
        return true;
    }

    void printAll() {
        for (Student student : students) {
            student.printInfo();
        }
    }
}
```

실행 결과는 다음과 같습니다.

```text
Lee: 40
Lee: 75
Ghost 수정 성공: false
Kim: 85
Lee: 75
Park: 92
```

`findByName`은 이름 문자열만 반환하지 않고, 목록 안에 들어 있던 `Student` 객체를 반환합니다. `updateScore`가 그 객체의 필드를 바꾸므로 목록을 다시 출력할 때도 바뀐 점수가 나옵니다.

학생을 찾지 못하면 `findByName`은 `null`을 반환합니다. `updateScore`는 `null`인지 먼저 확인하므로 없는 학생의 필드에 접근하지 않습니다.

## Q05_StudentReport

```java
Student findTopStudent() {
    if (students.isEmpty()) {
        return null;
    }

    Student top = students.get(0);
    for (Student student : students) {
        if (student.score > top.score) {
            top = student;
        }
    }
    return top;
}

double calculateAverage() {
    if (students.isEmpty()) {
        return 0.0;
    }

    int sum = 0;
    for (Student student : students) {
        sum += student.score;
    }
    return (double) sum / students.size();
}
```

빈 목록에서 `students.get(0)`을 실행하면 `IndexOutOfBoundsException`이 발생합니다. 따라서 최고 학생의 초기값을 정하기 전에 빈 목록인지 확인합니다.

`sum`과 `students.size()`가 모두 `int`이면 소수점 아래가 사라집니다. `(double) sum`으로 바꾼 뒤 나누면 `72.333...`을 얻을 수 있습니다.

## Q06_ManagerRules

```java
boolean addStudent(Student student) {
    if (student.score < 0 || student.score > 100) {
        return false;
    }

    if (findByName(student.name) != null) {
        return false;
    }

    students.add(student);
    return true;
}

boolean removeStudent(String name) {
    Student student = findByName(name);
    if (student == null) {
        return false;
    }

    students.remove(student);
    return true;
}
```

이미 작성된 `findByName`을 중복 확인과 삭제에서 다시 사용합니다. 같은 이름의 학생이 있으면 `null`이 아닌 `Student` 객체가 반환되므로 추가하지 않습니다.

삭제할 때도 먼저 실제 목록 안의 객체를 찾은 뒤 그 객체를 `remove`에 전달합니다. 성공하면 목록의 크기가 줄어듭니다.
