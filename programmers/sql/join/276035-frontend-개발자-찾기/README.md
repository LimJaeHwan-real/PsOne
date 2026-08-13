# FrontEnd 개발자 찾기

- 플랫폼: 프로그래머스
- 난이도: Level 4
- 분류: SQL / JOIN / 비트 연산 / DISTINCT / 서브쿼리
- DBMS: MySQL
- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/276035

## 문제 요약

`SKILLCODES`의 `CODE`는 2의 제곱수라서 2진수로 보면 각 스킬이 서로 다른 bit 하나를 차지한다.

`DEVELOPERS`의 `SKILL_CODE`는 그 bit들을 합친 값이다.

Front End 스킬을 하나라도 가진 개발자의 ID, 이메일, 이름, 성을 ID 오름차순으로 조회한다.

## 풀이

두 가지 방법으로 풀었다.

### 1) JOIN + DISTINCT

1. `DEVELOPERS`와 `SKILLCODES`를 `SKILL_CODE & CODE`가 참인 행끼리 연결한다.
2. `CATEGORY = 'Front End'` 조건으로 거른다.
3. 같은 개발자가 여러 번 나오므로 `DISTINCT`로 중복을 제거한다.

### 2) 서브쿼리 + SUM

1. 서브쿼리에서 Front End 스킬 `CODE`를 전부 `SUM`으로 더해 하나의 마스크를 만든다.
2. `SKILL_CODE & 마스크 > 0`이면 Front End 스킬을 하나라도 가진 것이다.

## 제출 코드

[solution.sql](./solution.sql)

## 배운 점

- JOIN 방식에 `DISTINCT`가 필요한 이유:
  Front End 스킬을 3개 가진 개발자(`SKILL_CODE = 10256`)는 `SKILLCODES`의 행마다 비교되면서
  `10256 & 16 = 16`, `10256 & 2048 = 2048`, `10256 & 8192 = 8192`로 전부 참이 되어 3번 조회된다.
- 서브쿼리 방식에 중복이 없는 이유:
  `SUM`으로 Front End 스킬을 하나의 값으로 합쳐두면 개발자 한 행당 참/거짓 판정이 한 번만 일어난다.
- 이 풀이에는 프로그래머스에서 제출하여 통과한 코드를 그대로 기록했다.
