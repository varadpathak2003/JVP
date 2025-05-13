def groupAndSort(files):
    res={}
    for file,owner in files.items():
        res.setdefault(owner,[]).append(file);
    for owner in res:
        res[owner].sort()
    return res

input={"Hii.txt":"Jay","Hello.txt":"Jay","bye.txt":"Sharad"}
output=groupAndSort(input)
print(output)
