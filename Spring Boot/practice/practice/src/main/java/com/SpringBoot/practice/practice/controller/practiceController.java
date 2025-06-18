package com.SpringBoot.practice.practice.controller;


import org.springframework.web.bind.annotation.*;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

@RestController
@RequestMapping("/Number")
public class practiceController {

    @GetMapping("/showNumbers")
    public String showNumbers()
    {
        return "These are the numbers you entered";
    }

    @PostMapping("/isPrime/{inputNumber}")
    public String enteredNumber(@PathVariable int inputNumber)
    {
        System.out.println("Post endpoint called with number: " + inputNumber);
        return isPrimeNumberFunction(inputNumber);

    }


    private String isPrimeNumberFunction(int inputNumber) {

        // Corner case
        if (inputNumber <= 1)
            return "Number Entered By You is not PRIME NUMBER !!!";

        // Check from 2 to n-1
        for (int i = 2; i < inputNumber; i++)
            if (inputNumber % i == 0)
                return "Number Entered By You is not PRIME NUMBER !!!";;

        return "Entered Number is PRIME NUMBER !!!";

    }

    @PostMapping("/password/{enterPassword}")
    public String createPassword(@PathVariable String enterPassword)
    {
        System.out.println("Accessed the password website ");

        return isPasswordValid(enterPassword);
    }

    private String isPasswordValid(String enterPassword)
    {
        System.out.println("Entering isPasswordValid Function !!!");
        int isUpperCaseCount = 0, lowerCaseCount = 0, specialCharCount;

        if(enterPassword.length() >= 10)
        {
            // Traverse the string
            System.out.println("Value before for loop : " + isUpperCaseCount);
            for (int i = 0; i < enterPassword.length(); i++) {

                char ch = enterPassword.charAt(i);

                if (Character.isUpperCase(ch)) {
                    isUpperCaseCount++;
                }
                if(Character.isLowerCase(ch))
                {
                    lowerCaseCount++;
                }

            }

            System.out.println("count of uppercase letters : " + isUpperCaseCount);
            System.out.println("count of lower case letters : " + lowerCaseCount);


            if(isUpperCaseCount >= 1)
            {
                return "Entered Password is : " + enterPassword + " (Is now saved in DataBase)";
            }
            else
            {
                return "Entered Password must have at least 1 UpperCase letter" ;
            }

//            if(lowerCaseCount >= 1)
//            {
//                return "Entered Password is : " + enterPassword + " (Is now saved in DataBase)";
//            }
//            else
//            {
//                return "Entered Password must have at least 1 LowerCase letter" ;
//            }

//            return "Entered Password is : " + enterPassword + " (Is now saved in DataBase)";

        }
        else
        {
            return "Password must at least contain 10 characters";
        }


    }

}
