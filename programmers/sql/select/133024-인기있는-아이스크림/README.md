# 인기있는 아이스크림

- 플랫폼: 프로그래머스
- 난이도: Level 1
- 분류: SQL / SELECT / ORDER BY
- DBMS: MySQL
- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/133024

## 문제 요약

`FIRST_HALF` 테이블에서 아이스크림 맛을 조회한다.

정렬 조건은 다음과 같다.

1. 총주문량(`TOTAL_ORDER`)이 많은 순서
2. 총주문량이 같으면 출하 번호(`SHIPMENT_ID`)가 작은 순서

## 풀이

`ORDER BY`에 여러 정렬 기준을 순서대로 작성한다.

- `TOTAL_ORDER DESC`: 총주문량 내림차순
- `SHIPMENT_ID ASC`: 출하 번호 오름차순

## 제출 코드

[solution.sql](./solution.sql)

## 배운 점

`ORDER BY`에는 여러 정렬 기준을 지정할 수 있으며, 앞에 작성한 조건부터 우선 적용된다.
