from datetime import date
  
def calculateAge(dob):
    today = date.today()
    age = today.year - dob.year -((today.month, today.day) <
         (dob.month, dob.day))
  
    return age
      
print(calculateAge(date(2017, 9, 18)), " years old")
