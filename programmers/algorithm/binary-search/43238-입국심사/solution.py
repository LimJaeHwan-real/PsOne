def solution(n, times):
    left = 1
    right = min(times) * n

    while left < right:
        mid = (left + right) // 2
        people = sum(mid // time for time in times)

        if people >= n:
            right = mid
        else:
            left = mid + 1

    return left
