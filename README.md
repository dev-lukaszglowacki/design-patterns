# Design Patterns in Java

Design patterns are reusable solutions to common problems encountered during software development. They offer proven, standardized approaches to design challenges, leading to more maintainable, flexible, and scalable code in Java. These patterns are broadly categorized into three types: creational, structural, and behavioral.

## How to Run

This project is a Spring Boot application built with Maven. To build and run the project, follow these steps:

1.  **Build the project:**
    ```bash
    ./mvnw clean install
    ```

2.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

    Alternatively, you can run the generated JAR file:
    ```bash
    java -jar target/design-patterns-0.0.1-SNAPSHOT.jar
    ```

The application will start on port 8080 (by default). You can then access the different design pattern examples via the defined endpoints (e.g., `http://localhost:8080/singleton`).

## Creational Patterns

Creational patterns focus on object creation mechanisms, trying to create objects in a manner suitable to the situation.

### Singleton
The Singleton pattern ensures a class has only one instance and provides a global point of access to it. In this project, the `SingletonService` is a Spring `@Service`, and Spring's default bean scope is Singleton.

### Factory
The Factory pattern provides a way to create objects without exposing the creation logic to the client and referring to the newly created object using a common interface. The `ShapeFactory` class demonstrates this by creating different shapes.

### Abstract Factory
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. This is demonstrated in the `abstractfactory` package, where `GUIFactory` creates UI elements for different operating systems.

### Builder
The Builder pattern separates the construction of a complex object from its representation, so that the same construction process can create different representations. The `Computer.ComputerBuilder` class is an example of this pattern.

### Prototype
The Prototype pattern allows for the creation of new objects by copying an existing object, known as the prototype. The `ShapeCache` class uses this pattern to cache and clone shapes.

## Structural Patterns

Structural patterns concern class and object composition. They use inheritance to compose interfaces and define ways to compose objects to obtain new functionalities.

### Adapter
The Adapter pattern allows incompatible interfaces to work together. The `PrinterAdapter` class adapts the `LegacyPrinter` to the `ModernPrinter` interface.

### Decorator
The Decorator pattern attaches additional responsibilities to an object dynamically. The `CoffeeDecorator` classes add milk or sugar to a coffee.

### Bridge
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. The `Shape` and `DrawAPI` interfaces demonstrate this pattern, allowing different shapes to be drawn with different colors.

### Composite
The Composite pattern composes objects into tree structures to represent part-whole hierarchies. The `Employee` class, which can have subordinates, is an example of this.

### Facade
The Facade pattern provides a unified interface to a set of interfaces in a subsystem. `ShapeMaker` provides a simple interface to draw different shapes.

### Flyweight
The Flyweight pattern is used to minimize memory usage or computational expenses by sharing as much as possible with other similar objects. The `flyweight.ShapeFactory` ensures that circle objects with the same color are shared.

### Proxy
The Proxy pattern provides a surrogate or placeholder for another object to control access to it. `ProxyImage` is a proxy for `RealImage` to defer loading of the image until it's needed.

## Behavioral Patterns

Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects.

### Observer
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. The `Subject` and `Observer` classes demonstrate this.

### Strategy
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. The `ShoppingCart` uses different `PaymentStrategy` implementations.

### Command
The Command pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations. The `Broker` takes and places `Order`s.

### Iterator
The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. `NameRepository` provides an iterator to traverse its names.

### State
The State pattern allows an object to alter its behavior when its internal state changes. The `Context` class's behavior changes based on its `State`.

### Memento
The Memento pattern provides the ability to restore an object to its previous state. `Originator`, `CareTaker`, and `Memento` classes are used to implement this.

### Chain of Responsibility
The Chain of Responsibility pattern creates a chain of receiver objects for a request. The `AbstractLogger` classes form a chain to log messages at different levels.

### Visitor
The Visitor pattern represents an operation to be performed on the elements of an object structure. The `ComputerPartVisitor` can visit different `ComputerPart`s.

### Mediator
The Mediator pattern provides a unified interface to a set of interfaces in a subsystem. `ChatRoom` acts as a mediator for `User`s to communicate.

### Template Method
The Template Method pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. The `Game` class defines the sequence of play, and subclasses implement the specific steps.

### Interpreter
The Interpreter pattern provides a way to evaluate language grammar or expression. The `Expression` classes are used to interpret a simple language.