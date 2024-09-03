# OO Design Principles

## SOLID

## S: Single Responsibility Principle: Each class should be responsible for a single part or functionality of the system

### Book invoice application

Let’s try to understand SRP with the help of an example. We have a book invoice application that has two classes: `Book` and `Invoice`. The `Book class` contains the data members related to the book. Whereas, the `Invoice class` contains the following three functionalities:

- Calculating the price of the book
- Printing the invoice
- Saving the invoice into the database

#### Violations

If we notice, the `Invoice class` violates the SRP in multiple ways:

The `Invoice class` is about invoices, but we have added `print` and `storage` functionality inside it. This breaks the SRP rule, which states, "A class should have only one reason to change."

If we want to change the logic of the printing or storage functionality in the future, we would need to change the class.

Instead of modifying the Invoice class for these uses, we can create two new classes for printing and persistence logic: `InvoicePrinter` and `InvoiceStorage`, and move the methods accordingly.

## O: Open/ Closed Principle: software components should be open for extension but closed for modification

## L: Liskov substituion Principle: objects of a superclass should be replaceable with objects of its subclasses without breaking the system

## I: Interface Segregation Principle: makes fine-grained interfaces that are client specific

## D: Dependency Principle: ensures that the high-level modules are not dependent on low-level modules. In other words, one should depend upon abstraction and not concretion

Use Case:

- Reduce Tight Coupling
- Reduce code complexity
- Reduce duplicationa dn producde more extensible and maintainable code
- Code is modular, feature specific and testable
