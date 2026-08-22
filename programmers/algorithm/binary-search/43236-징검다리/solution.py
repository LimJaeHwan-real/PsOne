def solution(distance, rocks, n):
    answer = 0
    l, r = 1, distance
    rocks.append(distance)
    rocks.sort()

    while l <= r:
        m = (l + r) // 2  # 최소 간격 후보
        cur = 0
        removed_cnt = 0

        for rock in rocks:
            dist = rock - cur

            if dist < m:
                removed_cnt += 1  # 뺀 돌의 수

                if removed_cnt > n:
                    break
            else:
                cur = rock

        if removed_cnt > n:
            r = m - 1
        else:
            answer = m
            l = m + 1

    return answer
