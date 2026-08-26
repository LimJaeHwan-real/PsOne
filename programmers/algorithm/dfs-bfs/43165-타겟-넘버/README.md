# 타겟 넘버

- 플랫폼: 프로그래머스
- 난이도: Level 2
- 분류: 알고리즘 / DFS / 재귀 / 백트래킹
- 언어: Java
- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

## 문제 요약

주어진 숫자의 순서를 바꾸지 않고 각 숫자 앞에 `+` 또는 `-`를 붙인다.

모든 숫자를 사용한 결과가 `target`과 같아지는 방법의 수를 구한다.

## 풀이

1. `idx`는 지금까지 처리한 숫자의 개수를 나타낸다.
2. 현재 숫자를 더하는 경우와 빼는 경우로 나누어 DFS를 실행한다.
3. `idx == numbers.length`가 되면 모든 숫자를 사용한 것이다.
4. 이때 `cur == target`이면 `answer`를 증가시킨다.
5. 배열 범위를 벗어난 인덱스에 접근하지 않도록 결과와 관계없이 반드시 `return`한다.

## 실수한 부분

### 1. 종료 조건의 `return`

다음 코드에서는 `cur == target`일 때만 `return`한다.

```java
if (idx == numbers.length) {
    if (target == cur) {
        answer++;
        return;
    }
}

dfs(numbers, target, cur + numbers[idx], idx + 1);
dfs(numbers, target, cur - numbers[idx], idx + 1);
```

`idx == numbers.length`이면서 `cur != target`이면 아래 코드가 계속 실행된다. 이때 `numbers[idx]`가 배열 범위를 벗어나므로 오류가 발생한다.

모든 숫자를 사용했다면 결과가 일치하는지 확인한 후 항상 재귀를 종료해야 한다.

```java
if (idx == numbers.length) {
    if (cur == target) {
        answer++;
    }
    return;
}
```

### 2. 인덱스 관리

다음 코드에는 현재 몇 번째 숫자까지 사용했는지를 나타내는 값이 없다.

```java
public void dfs(int[] numbers, int target, int cur) {
    if (target == cur) {
        answer++;
        return;
    }

    for (int i = 0; i < numbers.length; i++) {
        dfs(numbers, target, cur + numbers[i]);
        dfs(numbers, target, cur - numbers[i]);
    }
}
```

각 재귀 호출에서 반복문이 다시 처음부터 실행되므로 같은 숫자를 여러 번 사용하게 되고, 정상적인 종료 시점도 판단할 수 없다.

`idx`를 재귀 호출의 매개변수로 전달하면 각 단계에서 `numbers[idx]`를 한 번씩 사용하고, 모든 숫자를 사용했는지도 확인할 수 있다.

또한 중간 계산 결과가 `target`과 같더라도 아직 남은 숫자를 모두 사용해야 하므로 즉시 정답으로 세면 안 된다.

## 제출 코드

[Solution.java](./Solution.java)

## 배운 점

- 재귀의 종료 조건에서는 배열 범위를 벗어나는 다음 호출이 실행되지 않도록 반드시 종료해야 한다.
- `idx`는 현재까지 사용한 숫자의 개수이자 재귀의 깊이를 나타낸다.
- 이 문제는 모든 숫자를 사용해야 하므로 `cur == target`인지만 확인하는 것이 아니라 `idx == numbers.length`도 함께 확인해야 한다.
- 이 풀이에는 프로그래머스에서 제출하여 통과한 로직을 기록했다.
