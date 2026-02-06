# Design Notes

## Why ArrayList Instead of Array?

ArrayList was used instead of arrays because:
- Arrays have a **fixed size** once created
- ArrayList can **grow dynamically** as data increases
- ArrayList provides useful methods like `add()`, `remove()`, and `get()`
- It simplifies storing and managing objects such as Student, Course, and Enrollment

This makes ArrayList more suitable for a menu-driven application
where the number of records is not known in advance.

---

## Where Static Members Were Used and Why?

Static members were used in the `IdGenerator` utility class.

Example:
- `studentIdCounter`
- `courseIdCounter`
- `enrollmentIdCounter`

Reasons:
- IDs should be **shared across the entire application**
- Static variables ensure a **single counter value**
- Static methods allow ID generation **without creating objects**

This guarantees unique IDs for all entities.

---

## Where Inheritance Was Used and What Was Gained?

Inheritance was implemented using a base class:

- `Person` → base class
- `Student` and `Trainer` → child classes

Benefits:
- Common fields like `id`, `firstName`, `lastName`, and `email`
  are written **only once** in `Person`
- Code duplication is reduced
- Enables **polymorphism**, such as overriding `getDisplayName()`
- Makes the design more scalable for future roles.

Inheritance improves readability, maintainability,
and follows proper OOP principles.
