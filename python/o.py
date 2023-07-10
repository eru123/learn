def getInput():
    hours = float(input("How many hours did you work: "))
    while hours < 240 or hours >320:
        print('Error- Hours must be at least 240 hours per month')
        hours = float(input('re-enter hours worked:'))
    
    rate = float(input('what is your hourly rate? '))
    while rate < 67 or rate > 180:
        print('Error pay rate must be at least ₱67.00 and less than ₱180.00')
        rate = float(input('re enter your hourly rate: '))
        
    return hours, rate

def timeCal(hours):
        
    if hours <=240:
        return[hours, False]
    else:
        hour= hours-240
        return[hour, True]
def rateCal(hours,rate):
    if hours[1]:
        othours = hours[0]
        otpay = othours*(rate*1.5)
        regularpay = 40*rate
        return otpay, regularpay, othours
    else:
        return None
    
def main():
    hours, rate = getInput()
    if rateCal(timeCal(hours), rate)==None:
        print('Payroll Information\n')
        print('Pay rate ₱', format(rate,'7.2f'))
        print('Regular Hours', format(hours,'2.0f'))
        print('Overtime Hours 0')
        print('Regular pay ₱', format(hours*rate,'7.2f'))
        print('Total pay: ₱', format(hours*rate,'7.2f'))
    else:
        otpay, regularpay, othours = rateCal(timeCal(hours), rate)
        print('Payroll Information\n')
        print('Pay rate ₱', format(rate,'7.2f'))
        print('Regular Hours', format(hours, '2.0f'))
        print('Regular Pay ₱', format(hours*rate,'7.2f'))
        print('Overtime pay ₱', format(otpay, '7.2f'))
        print('Total pay: ₱',format((hours*rate) + otpay,'7.2f'))
        
main()