# TDD Primer: Kotlin

A project which is used to help teach those new to Test-Driven Development
(TDD) about the nuance of the development process.

## What's important about using Test-Driven Development?

- You can guarantee your code works as intended.
  
  - You get to visually see the change from failure to pass.
    
  - You then know something is wrong if that test starts failing again.
    
  - When things become complex, do you want confidence, or certainty?
  

- The code becomes more readable.

  - You only code for what you *truly* need, instead of what you *think* you
    need.
    
  - The tests become executable documentation.  Built by devs, for devs.
  
  - A priority on what is different can be achieved as part of removing
    duplication.
  

- The code becomes consumer-driven.
  
  - By the very nature of tests, you become a consumer of the production code.
    
  - Outside-In TDD becomes a logical conclusion when creating use cases before
    implementation detail.
    
  - If you don't want to use your code, who would?


## The most generic overview you could have

### The TDD Triangle

- Red: Create a test that fails.

- Green: Make the failing test pass by writing production code.  Commit
  whatever sin you need to.

- Refactor: Change the internal structure of code.  You can change either
  test code or production code, but not at the same time.  As in, change one
  side, then run the tests.


### A good way to write your tests

- Red:

  - Start with assertions - what is the purpose of your test?
  
  - Use objects or function calls with these assertions.
  
  - Solve test compilation issues by defining the objects you'll use.
  
  - Your test should compile, but fail at this point.
  

- Green:

  - If this is your first test, it can be good to hardcode the assertion.
  
  - Do the easiest or simplest thing you can to get the tests to pass.
  
  - As skill grows, you may not need to move as slowly when implementing code.
  

- Refactor

  - Readability is the most important factor.
  
  - Remove duplication.  The comedic 'rule of three' is a good sanity check.
  
  - Refactoring is for your test code, as well as production code(!!)


### Test Doubles 

- Dummy Objects:
  
  - Added for the sake of filling in parameters.
    
  - Not actually used within the context of the test.


- Stub Objects:
  
  - Implementations that return canned data.
    
  - There is no behaviour within the implementation, such as conditions.
    
  - Can return hard coded answers, or can use constructor injection to define
    the return values.


- Fake Objects:
  
  - Essentially alternative implementations that also have logic.
    
  - A Good example would be objects that use Maps / Dictionaries to represent
    databases, instead of creating a connection.


- Mock Objects:
  
  - Objects that can define usage expectations, such as the parameters passed
    to a given method / function.
    
  - Thrown exceptions appear when these are not met.
    
  - Many mocking libraries also include the opportunity to stub data using
    Mock objects.


- Spy Objects:
  
  - Test Doubles that have been decorated.
    
  - Can recall how they are used.
    
  - As an example, It may record how many API calls made during a user journey.
    
  - Many mocking libraries can also achieve this with their 'mock' objects,
    creating a level of ambiguity.
    

### Behaviour VS Output Verification

- Output Verification:

  - Verifies what is returned by object you wish to test.
    
  - It does not matter how the object came up with the return value.
    
  - More for organically creating functionality.
    

- Behaviour Verification:

  - Locks down on the collaborations within the function / method call.
    
  - For when our test is about *what* parameters a function uses.
    
  - More for proactively designing / organising code.


## Additional Resources

- [Jason Gorman's TDD Primer](http://codemanship.co.uk/tdd_jasongorman_codemanship.pdf)

- [Test Driven Development by Example: Kent Beck](https://www.google.co.uk/books/edition/Test_driven_Development/CUlsAQAAQBAJ)

- [Growing Object-Oriented Software, Guided by Tests: Steve Freeman, Nat Price](http://www.growing-object-oriented-software.com/)

- [Outside-In TDD style](https://outsidein.dev/outside-in-tdd.html)

- [Wishful Thinking](https://wiki.c2.com/?WishfulThinking)

- [Testing Doubles, as described by Martin Fowler](https://martinfowler.com/bliki/TestDouble.html)

- [Katas designed with TDD in mind](https://kata-log.rocks/)
