Single Responsibility Principle (SRP):
Each class in the system has a single responsibility. For example:
The LibraryCatalog interface is responsible for managing the library catalog, including adding and removing items.
The LibrarianService class is responsible for handling operations related to librarians, such as adding and removing items from the catalog, and managing user authentication and authorization.
The User interface represents different types of users and defines methods related to user authentication.
The Book, Magazine, and CD classes represent specific types of items in the catalog, each with its own responsibility of storing item-specific information.

Open/Closed Principle (OCP):
The system is open for extension, as new types of items (e.g., DVDs, e-books) can be easily added by creating new subclasses of the Item interface (e.g., DVD, EBook) without modifying existing code. Clients can interact with these new item types through the existing interfaces and classes without any modifications.

Liskov Substitution Principle (LSP):
Subclasses such as Book, Magazine, and CD can be substituted for their base class Item without altering the correctness of the program. This means that any operation defined for the base class Item will behave correctly when applied to its subclasses.


Interface Segregation Principle (ISP):
The interfaces (LibraryCatalog, User) are specific to the needs of the clients that use them. For example:
The LibraryCatalog interface provides methods relevant to managing the library catalog, such as adding, removing, and retrieving items. It doesn't include methods unrelated to its purpose.
The User interface provides methods for user authentication and authorization, which are essential for client interaction. It doesn't include unnecessary methods that aren't relevant to users.

Dependency Inversion Principle (DIP):
High-level modules (e.g., LibrarianService) are not dependent on low-level modules (e.g., concrete item classes such as Book, Magazine, CD). Instead, both high-level and low-level modules depend on abstractions (e.g., interfaces such as Item, LibraryCatalog). This allows for loose coupling between modules and facilitates easier maintenance and extension.


