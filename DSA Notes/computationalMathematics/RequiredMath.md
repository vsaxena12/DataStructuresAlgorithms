# Computational Mathematics

01. Sum of all numbers in an array: (n(n+1))/2
02. Math.min(x,y);
03. Math.max(x,y);
04. Integer.MAX_VALUE;
05. Integer.MIN_VALUE;
06. Math.pow(x,y);
07. Math.sqrt(x);
08. Math.log(x);
09. Math.log10(x);

10. Math.round(x);
11. Math.ceil(x);
12. Math.floor(x);

13. Math.sin(x); Math.cos(x); Math.tan(x); // Trigonometric functions.
14. Math.asin(x); Math.acos(x); Math.atan(x); // Inverse trigonometric functions.

15. Math.random(); //Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.

16. Math.abs(x); Returns the absolute value of an argument.

17. The modulus operator % gives the remainder of a division operation. For example, 10 % 3 would return 1 because the remainder of 10 / 3 is 1

18. Median = first + (last-first)/2
- AP 
- HP
- Mean
- Median
- Permutation
- Combinations 
- Prime numbers
	• Divisible by 1 and itself
	• Brute force
		○ When a number is a prime number?
			§ Consider a number n
			§ For i=2 to n/2 -> if n % i != 0 then it is a prime number 
			§ O(n/2) -> O(n)
		○ More efficient
			

- Quadratic Equations
- Arithmetic
- Digit Manipulation
- Factorial 
- Fibonacci Series


- LCM = a*b/GCD(a,b) -> O(log(min(a,b))
- HCF/GCD = euclidGCD
    static int euclidGCD(int a, int b){
        while(a!=0 && b!=0){
            if(a>b){
                a=a%b;
            } else{
                b=b%a;
            }
        }
        if(a!=0){
            return a;
        } else{
            return b;
        }
    }



- O(log(min(a,b))
- For two non-negative integers a and b where a≥b, the GCD can be defined as:
    a. If b=0, then GCD(a, b) = a. This is because the greatest divisor of any number and 0 is the number itself.
    b. If b !=0 then GCD(a, b)=GCD(b, a % b), where a % b is the remainder of a divided by b.
    In a more formulaic representation: