# Design Patterns Catalog

## 1. Behavioral Design Patterns

Behavioral patterns focus on communication between objects and how responsibilities are distributed. They define how objects interact and share responsibilities efficiently.

### 1.1 Observer Pattern

**Definition:** Observer pattern allows an object (subject) to notify other objects (observers) automatically when its state changes.

**Use Case:** Real-time Weather Monitoring System

**Scenario:** A weather station tracks temperature, humidity, and pressure. Multiple devices (mobile app, web dashboard, IoT displays) need updates whenever weather changes.

**Explanation:** The weather station acts as a Subject, and all devices act as Observers. When data changes, all observers are notified automatically.

**Benefit:** Loose coupling between weather station and devices; devices can subscribe/unsubscribe dynamically.

### 1.2 Strategy Pattern

**Definition:** Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. The algorithm can vary independently from clients.

**Use Case:** Payment Gateway System

**Scenario:** An e-commerce platform allows payments through multiple methods: Credit Card, PayPal, Cryptocurrency.

**Explanation:** Payment algorithms are encapsulated as separate strategies. The system selects the appropriate strategy at runtime based on user choice.

**Benefit:** Adding new payment methods is easy without modifying existing code; behavior can change dynamically.

## 2. Creational Design Patterns

Creational patterns focus on object creation mechanisms, making a system independent of how objects are created. They help create objects in a controlled manner.

### 2.1 Singleton Pattern

**Definition:** Singleton pattern ensures a class has only one instance and provides a global point of access to it.

**Use Case:** Logger in an Enterprise Application

**Scenario:** A centralized logger writes logs from multiple modules to a single file. Multiple instances may cause conflicts.

**Explanation:** Singleton ensures only one instance of the logger exists throughout the application.

**Benefit:** Resource-efficient; ensures consistent logging; global point of access.

### 2.2 Factory Pattern

**Definition:** Factory pattern provides an interface to create objects but allows subclasses to decide which class to instantiate.

**Use Case:** Vehicle Manufacturing System

**Scenario:** A factory produces different types of vehicles: Car, Bike, Truck. User requests a vehicle type without knowing the exact class.

**Explanation:** A VehicleFactory decides which vehicle subclass to instantiate based on input.

**Benefit:** Simplifies object creation; supports scalability by adding new vehicle types without changing client code.

## 3. Structural Design Patterns

Structural patterns focus on how classes and objects are composed to form larger structures. They help organize code efficiently.

### 3.1 Adapter Pattern

**Definition:** Adapter pattern allows incompatible interfaces to work together by converting one interface into another expected by clients.

**Use Case:** Legacy Payment System Integration

**Scenario:** A new e-commerce system must integrate with an old payment API with a different interface.

**Explanation:** An Adapter converts the new system's requests into the format accepted by the legacy API.

**Benefit:** Allows incompatible interfaces to work together without changing existing code.

### 3.2 Decorator Pattern

**Definition:** Decorator pattern allows adding new functionality to an object dynamically without affecting others of the same class.

**Use Case:** Online Food Ordering Platform

**Scenario:** Users can customize burgers by adding toppings like cheese, bacon, or extra sauce.

**Explanation:** Each topping acts as a decorator that adds functionality (price, description) to the base burger.

**Benefit:** Provides flexible extension of object behavior at runtime; avoids subclass explosion.
