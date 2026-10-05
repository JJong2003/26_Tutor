# 26_Tutor — 컴퓨터프로그래밍2 튜터링

이 저장소는 컴퓨터프로그래밍2 튜터링에서 사용하는 실습 자료 저장소입니다.

튜터링은 강의식으로 진행하지 않습니다. 학생이 직접 문제를 해결하고, 막히는 부분이나 이해되지 않는 부분을 질문하면 튜터가 힌트와 설명을 제공하는 방식으로 진행합니다.

## 저장소 구조

이 저장소는 `main` branch와 주차별 문제 branch로 구성됩니다.

```text
main                   전체 튜터링 안내 (현재 branch)
week-01-java-basic     1주차 실습 문제
```

`main` branch에는 문제가 없습니다. 각 주차의 실습 문제는 해당 주차의 branch에서 제공됩니다.

## 사용 방법

1. 저장소를 clone 합니다.

   ```bash
   git clone https://github.com/JJong2003/26_Tutor.git
   cd 26_Tutor
   ```

2. 해당 주차의 문제 branch로 이동합니다.

   ```bash
   git switch week-01-java-basic
   ```

3. branch의 `README.md`에 안내된 방법에 따라 문제를 풀고, 자신의 작업 branch를 만들어 Pull Request를 제출합니다.

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

## 주차별 안내

| 주차 | Branch | 내용 |
| --- | --- | --- |
| 1주차 | `week-01-java-basic` | Java 기본 문법 진단 (코드 읽기 / 디버깅 / 직접 구현) |

각 주차 branch로 이동하면 해당 주차의 상세 안내(`README.md`)를 확인할 수 있습니다.
