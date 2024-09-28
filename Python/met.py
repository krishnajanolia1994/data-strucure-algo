def solution(S):
    from collections import Counter

    digit_count = Counter(S)
    
    left_half = []
    middle = ""
    
    for digit in "9876543210":
        count = digit_count[digit]
        
        if count > 0:
            if count % 2 == 1:
                middle = max(middle, digit)
                
            left_half.append(digit * (count // 2))
    
    left_half = ''.join(left_half)
    
    palindrome = left_half + middle + left_half[::-1]
    
    return palindrome.lstrip('0') or '0'