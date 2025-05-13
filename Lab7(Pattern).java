def print_pattern(n):
    num=n*n*2-1
    for i in range(n):
        print("  "*i,end="")
        for j in range (2*(n-i)-1):
            print(num,end=" ")
            num-=2
        print()
rows=int(input("No of rows : "))
print_pattern(rows)
