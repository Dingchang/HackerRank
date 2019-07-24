### Employee Chart Challenge
The `Chart` represents all employees in the company with their reports. The program
first takes a number as the total operations to the chart and then do the following
operations as entered.

#### add

```
add,[id],[name],[employerID]
```
Add an employee with given ID, name, and his/her employer ID. If the id already
exists, do nothing. If the employer ID does not exist, then add this employee
with no employer (-1 in this case).

Sample input:
```
6
add,1,Sharilyn Gruber,-1
add,2,Denice Mattice,-1
add,3,Lawana Futrell,-1
add,4,Lissette Gorney,-1
add,5,Lan Puls,-1
print
```

Sample output:
```
Sharilyn Gruber [1]
Denice Mattice [2]
Lawana Futrell [3]
Lissette Gorney [4]
Lan Puls [5]
```

### print

Print the chart. Each employee should be formatted as `name [id]`. All reports
of an employee should be nested with two spaces under his/her name.

Sample input:
```
6
add,1,Sharilyn Gruber,-1
add,2,Denice Mattice,1
add,3,Lawana Futrell,-1
add,4,Lissette Gorney,1
add,5,Lan Puls,3
print
```

Sample output:
```
Sharilyn Gruber [1]
  Denice Mattice [2]
  Lissette Gorney [4]
Lawana Futrell [3]
  Lan Puls [5]
```

### move
```
move,[id],[newEmployerID]
```
Move the employee with given ID under the employee with `newEmployerID`. If the
given ID or new employer's ID does not exist, do nothing.

Sample input:
```
7
add,1,Sharilyn Gruber,-1
add,2,Denice Mattice,-1
add,3,Lawana Futrell,-1
add,4,Lissette Gorney,-1
add,5,Lan Puls,-1
move,4,2
print
```

Sample output:
```
Sharilyn Gruber [1]
Denice Mattice [2]
  Lissette Gorney [4]
Lawana Futrell [3]
Lan Puls [5]
```

### remove
```
remove,[id]
```
Remove the employee with given ID. If the given ID does not exist, do nothing.
After remove, all reports of this employee now report to his/her employer.

Sample input:
```
7
add,1,Sharilyn Gruber,-1
add,2,Denice Mattice,-1
add,3,Lawana Futrell,-1
add,4,Lissette Gorney,-1
add,5,Lan Puls,-1
remove,3
print
```

Sample output:
```
Sharilyn Gruber [1]
Denice Mattice [2]
Lissette Gorney [4]
Lan Puls [5]
```

### count
```
count,[id]
```
Count the reports of the employee with given ID.

Sample input:
```
6
add,1,Sharilyn Gruber,-1
add,2,Denice Mattice,1
add,3,Lawana Futrell,-1
add,4,Lissette Gorney,2
add,5,Lan Puls,3
count,1
```

Sample output:
```
2
```

The goal of this challenge is to implement the `Chart` class with these five methods.
