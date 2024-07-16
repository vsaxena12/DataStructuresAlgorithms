# Permutations and Combinations

## Definitions

**Permutations**: Permutations refer to the different ways in which a set of items can be arranged in a specific order. Order matters in permutations.

**Combinations**: Combinations refer to the different ways in which a set of items can be selected, regardless of the order. Order does not matter in combinations.

## Formulas

1. Permutations (without repetition)**:
    - Formula: 
         
          P(n, r) = n!/(n-r)!
          Where n is the total number of items, and r is the number of items being chosen.
   
    - Example: The number of ways to arrange 3 out of 5 items (A, B, C, D, E) is 5!/(5-3)! = 60.


2. Permutations (with repetition):
    - Formula:
   
          P(n, r) = n^r
          Where n is the total number of items, and r is the number of items being chosen.
    - Example: The number of ways to arrange 3 items out of 3 (A, B, C) with repetition is 3^3 = 27.


3. Combinations (without repetition):
    - Formula:
            
          C(n, r) = n!/r!(n-r)!
          Where n is the total number of items, and r is the number of items being chosen.
    - Example: The number of ways to choose 3 out of 5 items (A, B, C, D, E) is 5!/3!(5-3)! = 10.


4. Combinations (with repetition):
    - Formula: 
   
          C(n+r-1, r) = (n+r-1)!/r!(n-1)!
          Where n is the total number of items, and r is the number of items being chosen.
    - Example: The number of ways to choose 3 items out of 3 (A, B, C) with repetition (3+3-1)!/3!(3-1)! = 10.

## Examples

1. Permutations of A, B, C:
    - Without repetition: ABC, ACB, BAC, BCA, CAB, CBA
    - With repetition: AAA, AAB, AAC, ABA, ABB, ABC, ACA, ACB, ACC, BAA, BAB, BAC, BBA, BBB, BBC, BCA, BCB, BCC, CAA, CAB, CAC, CBA, CBB, CBC, CCA, CCB, CCC

2. Combinations of A, B, C:
    - Without repetition: AB, AC, BC
    - With repetition: AA, AB, AC, BB, BC, CC

## Special Cases

1. Selecting All Items (r = n):
    - Permutations: \( P(n, n) = n! \)
    - Combinations: \( C(n, n) = 1 \)

2. Selecting None (r = 0):
    - Permutations: \( P(n, 0) = 1 \)
    - Combinations: \( C(n, 0) = 1 \)

## Practical Applications

1. Permutations:
    - Arranging books on a shelf
    - Creating passwords

2. Combinations:
    - Selecting a committee from a group
    - Choosing lottery numbers

## Conclusion

Permutations and combinations are fundamental concepts in combinatorics, with wide-ranging applications in mathematics, computer science, and everyday problem-solving. Understanding the difference between them and knowing how to calculate each can help solve various counting and arrangement problems efficiently.