### Section 05 - Spring Dependency Injection - XML Configuration

#### 33 - FAQ: What is the purpose for the no arg constructor?

FAQ: What is the purpose for the no arg constructor?

Question:
I was wondering why you created a no arg constructor? I thought that they are implied by Java and only required when you also have an overloaded constructor. Or is this a Spring specific thing?

---

Answered by: Oleksandr Palamarchuk

When you don’t define any constructor in your class, compiler defines default one for you, however when you declare any constructor (in your example you have already defined a parameterized constructor), compiler doesn’t do it for you.

Since you have defined a constructor in class code, compiler didn’t create default one. While creating object you are invoking default one, which doesn’t exist in class code. Then the code gives an compilation error.

#### Spring : Beans & "Eager" initialization
By default, Spring will automatically create all beans in memory at application startup. This is known as "eager" initialization. The beans will always be created up front.

That is why you see the startup methods being called for other beans.

Also, when the context is closed, it calls the shutdown methods on all beans in memory.

——

However, Spring also allows you to make use of "lazy" initialization. With "lazy" initialization, the bean will only be created when explicitly requested with "applicationContext.getBean(...)"

To configure your bean for "lazy" initialization, you make use of the lazy-init=“true" configuration

For example, to mark class CricketCoach for lazy initialization:
     <bean id="myCoach"

          class=“com.luv2code.springdemo.CricketCoach” lazy-init=“true” … >

            ...

    </bean>

By using the lazy init configuration, class CricketCoach will only be initialized unless it is explicitly referenced by "applicationContext.getBean(...)" or used as a dependency.

If you have time, experiment with "lazy" initialization to see how beans are created.

---

You can get more details on lazy initialization here:
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-lazy-init