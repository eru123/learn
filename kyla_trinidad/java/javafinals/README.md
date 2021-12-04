`grades.txt`
```txt
Choose Semester
[1]1st Semester
[2]2nd Semester
-----------------

Choose Subject
[1] Subject 1
[2] Subject 2
[3] Subject 3
[4] Subject 4
[5] Subject 5
[6] Back

------------------------

Subject 1:
(Written work (WR1 / = *.2) === will compute for final grade for the sem
Enter Grade For Written Work 1 (10 Itmes): 
cin>> wr1
Enter Grade For Written Work 2 (10 Itmes):
cin>>wr2
Enter Grade For Written Work 3 (10 Itmes):
cin>>wr3
Enter Grade For Written Work 4 (10 Itmes):
cin>>wr4

wrfin=(wr1+wr2+wr3+wr4);
wrfin=(wrfin/40 * 100) *.2

(Performance Task = *.3) === will compute for final grade for the sem
Enter Grade For Performance Task1(50 items):
cin>>pt1
Enter Grade For Performance Task2(50 items):
cin>>pt2
ptfin=(pt1+pt2)
ptfin=(ptfin/100 * 100) *.3

(Exams = *.5)  === will compute for final grade for the sem
Enter Grade For Mid Term:
cin>> Midt
Midt=(Midt/100 * 100) *.25

Enter Grade For Finals:
cin>> Finls
Finls=(Finls/100 * 100) *.25


Computing for Grade for the semester...
--------------------------

[for computation of grade[
ptfin + Midt + Finls == Total grade
```