def groupAndSortOwners(files):
    result = {}
    for file, owner in files.items():
        result.setdefault(owner, []).append(file)
    
    for owner in result:
        result[owner].sort()
    
    return result

# Example usage:
files = {
    'Input.txt': 'Albert',
    'Code.py': 'Stanley',
    'Output.txt': 'Albert',
    'btech.txt': 'Albert'
}

output = groupAndSortOwners(files)
print(output)
