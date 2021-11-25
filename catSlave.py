#學號:108213052
#姓名:楊心慈

class catSlave(): # 定義一個 class
    def __init__(self, name): # 第一個參數 self
        self.name = name
        self.cats = []
    def __add__(self, n):
        for i in range(n):
            self.cats.append('沒名')
        return self
    def addCat(self, cname):
        self.cats.append(cname)
    def print(self):
        print(self.name)
        print(*self.cats)
def main():
    老俞 = catSlave('俞旭昇') # 產生一個屬於 catSlave 的物件
    老俞.addCat('鯊魚')
    老俞.addCat('hero')
    老俞.addCat('mia')
    老俞.addCat('黑貓')
    老俞 = 老俞 + 3
    老俞.print()
if __name__ == "__main__":
    main()

# 輸出:
# 俞旭昇
# 鯊魚 hero mia 黑貓 沒名 沒名 沒名

# 最後完成日期:2021年02月26日