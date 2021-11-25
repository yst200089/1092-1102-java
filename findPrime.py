#學號:108213052
#姓名:楊心慈

def isPrimes(n):
    # 從 2 開始找
    num = 2
    # 當 num 比 n 小時
    while num < n :
        # 可以被整除
        if n % num == 0:
            return False
        # 繼續往下找
        num = num + 1
    # n 是質數
    return True
def findPrimes(n):
    #建立質數清單
    all = []
    # 對每個 v， 2<=v<=n
    for v in range(2, n+1):
        # 如果 v 是質數
        if isPrimes(v) :
            # 加入清單
            all.append(v)
    # 回傳所有質數清單
    return all
def main():
    # 輸入整數 n
    n = int(input())
    # 找出所有質數 p 的清單， 2<= p <= n
    allPrimes = findPrimes(n)
    # 印出清單內的所有數字
    print(*allPrimes)

if __name__ == '__main__':
    main()

# 最後完成日期:2021年02月22日