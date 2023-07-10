print('#################################################################')
print('# THANK YOU FOR CHOOSING OUR SERVER TO WRITE YOUR AUTOBIOGRAPHY #')
print('#            PLEASE ANSWER THE FOLLOWING QUESTION               #')
print('#################################################################')

# QUESTIONS

name            = input('\nWhat is your name(First Name MI. Surname)?\nAnswer: ')
age             = input('\nWhat is your age?\nAnswer: ')
date            = input('\nDate of your birth(mm dd, yyyy)?\nAnswer: ')
place           = input('\nPlace of birth?\nAnswer: ')
father          = input('\nName of your father(First Name MI. Surname)?\nAnswer: ')
mother          = input('\nName of your mother(First Name MI. Surname)?\nAnswer: ')
siblings        = input('\nNo. of your siblings?\nAnswer: ')
order           = input('\nYour birth order among your siblings?\nAnswer: ')
hobby           = input('\nWhat is your hobby?\nAnswer: ')
schoolSHS       = input('\nWhere did you gratuated from Shs?\nAnswer: ')
schoolCollege   = input('\nWhere do you go for college?\nAnswer: ')
course          = input('\nWhat is course did you take?\nAnswer: ')
yearLvl         = input('\nWhat is your year level?\nAnswer: ')
dream           = input('\nWhat is your dream?\nAnswer: ')
inspire         = input('\nWho or what are/is your inspiration?\nAnswer: ')

# OUTPUT

print('\n\n')
print('#####################  MY AUTOBIOGRAPHY  #######################\n')
print('My name is '+name+'. I am '+age+' years old and I was born on '+date+', at '+place+'. My parents are '+father+' and '+mother+'. I have '+siblings+' siblings and I am the '+order+'. My hobby is '+hobby+'.\n')
print('I finish my senior high at '+schoolSHS+' and I pursue my career at '+schoolCollege+' and I take '+course+', as a '+yearLvl+'. My dream is '+dream+'. I am very motivated to create the best possible future for myself and for my '+inspire+' that always cheering, believing and loving me.\n')
print('###########################  END  ##############################\n')
