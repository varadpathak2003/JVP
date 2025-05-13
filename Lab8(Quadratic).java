import math
def quadratic_solver(a,b,c):
    d=b**2-4*a*c
    if (d<0):
        print("Roots are not real")
    elif (d>0) :
        root1=(-b-math.sqrt(d))/(2*a)
        root2=(-b+math.sqrt(d))/(2*a)
        print("Root 1 : ",root1,"Root 2 : ",root2);
    else:
        print("Root : ",-b/(2*a));
quadratic_solver(1,3,6)
