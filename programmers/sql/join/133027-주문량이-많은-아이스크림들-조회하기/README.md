# 주문량이 많은 아이스크림들 조회하기

- 플랫폼: 프로그래머스
- 난이도: Level 4
- 분류: SQL / JOIN / GROUP BY / ORDER BY / LIMIT
- DBMS: MySQL
- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/133027

## 문제 요약

`FIRST_HALF` 테이블의 상반기 주문량과 `JULY` 테이블의 7월 주문량을 맛별로 합산한다.

합산한 주문량이 많은 순서대로 상위 3개의 아이스크림 맛을 조회한다.

## 풀이

1. `FIRST_HALF`와 `JULY`를 `FLAVOR`가 같은 행끼리 연결한다.
2. 연결된 행을 `FLAVOR`별로 그룹화한다.
3. 상반기와 7월 주문량의 합계를 기준으로 내림차순 정렬한다.
4. `LIMIT 3`으로 상위 3개 맛만 조회한다.

## 제출 코드

[solution.sql](./solution.sql)

## 배운 점

- `INNER JOIN`을 사용하면 서로 다른 테이블에서 연결 조건이 일치하는 행을 합칠 수 있다.
- `GROUP BY`와 `SUM`을 사용하면 같은 맛의 주문량을 묶어 계산할 수 있다.
- 이 풀이에는 프로그래머스에서 제출하여 통과한 코드를 그대로 기록했다.
