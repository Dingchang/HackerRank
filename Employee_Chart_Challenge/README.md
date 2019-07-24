### Employee Chart Challenge
The `Chart` represents all employees in the company with their reports. The program
first takes a number as the total operations to the chart and then do the following
operations as entered.

#### add
```
add,[id],[name],[employerID]
```
Add an employee with given ID, name, and his/her employer ID. If the id already
exists, then do nothing. If the employer ID does not exist, then add this employee
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

The goal of this challenge is to implement the `Chart` class with these five methods: `add`, `print`, `move`, `remove`, and `count`.
