# 다른 회원을 추천한 모든 회원 목록 조회하기

- 플랫폼: PostgreSQL Exercises
- 분류: SQL / JOIN / SELF JOIN / DISTINCT / ORDER BY
- DBMS: PostgreSQL
- 문제 링크: https://pgexercises.com/questions/joins/self.html

## 문제 번역

다른 회원을 추천한 모든 회원의 목록을 출력하세요.

목록에는 중복된 회원이 없어야 하며, 결과는 성(`surname`), 이름(`firstname`) 순서로 정렬해야 합니다.

## 문제 이해

`cd.members` 테이블의 `recommendedby`에는 해당 회원을 추천한 회원의 `memid`가 저장되어 있다.

추천한 회원과 추천받은 회원의 정보가 같은 테이블에 있으므로, `cd.members` 테이블을 자기 자신과 연결하는 셀프 조인이 필요하다.

## 풀이

1. `mems`는 추천받은 회원을 나타낸다.
2. `recs`는 다른 회원을 추천한 회원을 나타낸다.
3. `mems.recommendedby`와 `recs.memid`가 같은 행을 연결한다.
4. 한 회원이 여러 명을 추천했을 수 있으므로 `DISTINCT`로 중복을 제거한다.
5. 성과 이름을 기준으로 오름차순 정렬한다.

## 제출 코드

[solution.sql](./solution.sql)

## 배운 점

- 셀프 조인을 사용하면 하나의 테이블 안에서 서로 관계를 맺고 있는 행을 연결할 수 있다.
- 같은 테이블을 여러 번 사용할 때는 별칭을 지정하여 각 역할을 구분할 수 있다.
- 조인 결과에 같은 추천인이 여러 번 나타날 수 있으므로 `DISTINCT`를 사용해 중복을 제거해야 한다.
