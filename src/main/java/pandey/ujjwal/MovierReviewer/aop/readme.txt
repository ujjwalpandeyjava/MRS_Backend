https://www.baeldung.com/spring-aop
- AOP (Aspect Oriented Programming): A programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns¹[1]. It does this by adding additional behavior to existing code without modifying the code itself²[2].
- Spring AOP: A framework that helps implement AOP in Spring applications. It supports XML-based and annotation-based configuration, and provides various types of advice to apply at different joinpoints.
- Business Object: A normal class that has a normal business logic³[3]. For example, a class that adds two numbers.
- Aspect: A modularization of a concern that cuts across multiple classes. For example, unified logging can be an aspect.
- Joinpoint: A point during the execution of a program, such as the execution of a method or the handling of an exception⁴[4]. In Spring AOP, a joinpoint always represents a method execution⁵[5].
- Pointcut: A predicate that helps match an advice to be applied by an aspect at a particular joinpoint⁶[6][7]. For example, a pointcut can specify that an advice should run on any method within a certain class that accepts any number of arguments and returns any value type.
- Advice: An action taken by an aspect at a particular joinpoint[7]⁶[6]. Different types of advice include "around", "before", and "after". In Spring, an advice is modelled as an interceptor, maintaining a chain of interceptors around the joinpoint⁸[8].
- References: The web page contains many references to other articles and resources related to AOP and Spring AOP.