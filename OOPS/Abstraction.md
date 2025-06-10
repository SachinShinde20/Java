# Abstraction in Java: What it is and How it's Supported

## What is Abstraction in Java?

Abstraction in Java is the process of **hiding internal implementation details** and **showing only the essential functionality** to the user.

It allows us to focus on **what an object does**, rather than how it does it.

---

## How Does Java Support Abstraction?

Java supports abstraction using:

- **Abstract Classes**: Define method signatures (some with implementations, some without) and properties, serving as a blueprint.
- **Interfaces**: Define method signatures without any implementations, acting as a pure contract.

This approach lets subclasses implement the details their own way, based on a common contract defined by the abstract class or interface.

---

## 🎯 Example Explanation for Interviewers:

"For example, consider an abstract class `Vehicle` with an abstract method `start()`. We don't define how the vehicle starts – we just declare that **every vehicle must have a `start()` method.**"

```java
public abstract class Vehicle {
    public abstract void start(); // Abstract method - no implementation here
    // Other common methods like accelerate(), stop() could be here too
}
```
