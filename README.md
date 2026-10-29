# 26_Tutor — 컴퓨터프로그래밍2 튜터링

이 저장소는 컴퓨터프로그래밍2 튜터링에서 사용하는 실습 자료 저장소입니다.

튜터링은 강의식으로 진행하지 않습니다. 학생이 직접 문제를 해결하고, 막히는 부분이나 이해되지 않는 부분을 질문하면 튜터가 힌트와 설명을 제공하는 방식으로 진행합니다.

## 저장소 구조

이 저장소는 `main` branch와 주차별 문제 branch로 구성됩니다.

```text
main                   전체 튜터링 안내 (현재 branch)
week-01-java-basic     1주차 실습 문제
week-02-class-object   2주차 실습 문제
```

`main` branch에는 문제가 없습니다. 각 주차의 실습 문제는 해당 주차의 branch에서 제공됩니다.

## 사용 방법

이 저장소를 직접 clone하지 않고 **fork**해서 사용합니다.
이 저장소에는 직접 올릴 수 없으므로, 자신의 fork에 올린 뒤 Pull Request로 제출합니다.

1. GitHub에서 이 저장소(`JJong2003/26_Tutor`)를 fork 합니다. (페이지 오른쪽 위의 Fork 버튼)

2. 자신의 fork를 clone 합니다. `<자기ID>`는 본인의 GitHub ID로 바꿉니다.

   ```bash
   git clone https://github.com/<자기ID>/26_Tutor.git
   cd 26_Tutor
   ```

3. 원본 저장소를 `upstream`으로 등록합니다. 새로운 주차의 문제를 받을 때 사용합니다.

   ```bash
   git remote add upstream https://github.com/JJong2003/26_Tutor.git
   git remote -v
   ```

   `origin`이 자신의 fork, `upstream`이 `JJong2003/26_Tutor`로 보이면 됩니다.

4. 해당 주차의 문제 branch를 기준으로 자신의 작업 branch를 만듭니다. 주차별 branch 이름은 아래 "주차별 안내"에 있습니다.

   ```bash
   git fetch upstream
   git switch -c solve/week-02 upstream/week-02-class-object
   ```

5. branch의 `README.md`에 안내된 방법에 따라 문제를 풀고, 자신의 fork에 push한 뒤 Pull Request를 제출합니다.

IntelliJ에서는 clone한 폴더를 열어 작업하면 됩니다. 위 명령어는 IntelliJ 하단의 Terminal에서 실행할 수 있습니다.

### 이미 원본 저장소를 clone했다면

다시 clone하지 않아도 됩니다. 기존 폴더를 그대로 두고 연결 대상만 자신의 fork로 바꿉니다.

1. 위 "사용 방법" 1번처럼 GitHub에서 fork 합니다.

2. 저장하지 않은 작업이 있으면 먼저 commit 합니다.

   ```bash
   git status
   git add .
   git commit -m "Solve week 1 problems"
   ```

3. 원본 저장소를 `upstream`으로 바꾸고, 자신의 fork를 `origin`으로 등록합니다.

   ```bash
   git remote rename origin upstream
   git remote add origin https://github.com/<자기ID>/26_Tutor.git
   git remote -v
   ```

4. 위 "사용 방법" 4번부터 이어서 진행합니다.

아직 제출하지 않은 이전 주차의 풀이는 `git push origin solve/week-01`로 자신의 fork에 올린 뒤, 같은 방법으로 Pull Request를 만들 수 있습니다. (base: `week-01-java-basic`)

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
GitHub push (자신의 fork)
↓
Pull Request 제출
↓
튜터 코드 리뷰
↓
필요할 경우 수정
```

## 주차별 안내

| 주차 | Branch | 내용 |
| --- | --- | --- |
| 1주차 | `week-01-java-basic` | Java 기본 문법 진단 (코드 읽기 / 디버깅 / 직접 구현) |
| 2주차 | `week-02-class-object` | 클래스와 객체 (값 복사와 주소 복사) |

각 주차 branch로 이동하면 해당 주차의 상세 안내(`README.md`)를 확인할 수 있습니다.
