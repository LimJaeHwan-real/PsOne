# 연도별 대장균 크기의 편차 구하기

- 플랫폼: 프로그래머스
- 난이도: Level 2
- 분류: SQL / SUM, MAX, MIN / 상관 서브쿼리
- DBMS: MySQL
- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/299310

## 문제 요약

각 대장균의 분화 연도별 최대 군집 크기를 구한 뒤, 해당 연도의 최대 크기에서 각 대장균의 크기를 뺀 값을 `YEAR_DEV`로 출력한다.

결과는 연도 오름차순, 같은 연도에서는 크기 편차 오름차순으로 정렬한다.

## 풀이

1. 바깥쪽 테이블 `e1`에서 각 대장균의 연도, 크기, ID를 조회한다.
2. 안쪽 서브쿼리 `e2`에서 `e1`과 같은 분화 연도의 `SIZE_OF_COLONY` 최댓값을 구한다.
3. 연도별 최댓값에서 `e1.SIZE_OF_COLONY`를 빼서 대장균별 크기 편차를 계산한다.
4. 계산한 연도와 편차를 각각 `YEAR`, `YEAR_DEV` 별칭으로 지정해 정렬에 사용한다.

## 제출 코드

[solution.sql](./solution.sql)

## 배운 점

- `e1`은 바깥쪽 `ECOLI_DATA` 테이블이고, `e2`는 같은 연도의 최댓값을 구하는 안쪽 `ECOLI_DATA` 테이블이다.
- `SELECT`에서 만든 열 별칭은 MySQL에서 `GROUP BY`, `HAVING`, `ORDER BY`에는 사용할 수 있지만, `WHERE` 절에서는 사용할 수 없다.
- `WHERE` 절은 `SELECT`보다 먼저 실행되므로, `SELECT` 단계에서 만들어지는 열 별칭을 아직 알 수 없기 때문이다.

### SQL 실행 순서

1. `FROM`
2. `WHERE`
3. `GROUP BY`
4. `HAVING`
5. `SELECT` - `YEAR`, `YEAR_DEV` 열 별칭 생성
6. `ORDER BY`
7. `LIMIT`

- 따라서 이 문제에서는 `YEAR`, `YEAR_DEV` 별칭을 `ORDER BY`에서 사용해 정렬했다.
