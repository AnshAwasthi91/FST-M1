age = int(input("Enter the user age"))
if(age<100):
    finalAge = 2022+(100-age);
    msg="You will be of 100 years in {}"
    print(msg.format(finalAge))
else:
    finalAge = 2022+(100-age);
    msg="Congrats ! you have hit the Century in {}"
    print(msg.format(finalAge));