# Annotations - Default Bean Names - The Special Case

In general, when using Annotations, for the default bean name, Spring uses the following rule.

If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased).

For example:

```
HappyFortuneService --> happyFortuneService
```

***

However, for the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.

For the case of RESTFortuneService

```
RESTFortuneService --> RESTFortuneService
```

No conversion since the first two characters are upper case.

Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name. 
Also, here's a link to the documentation.

- <a href="https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize(java.lang.String)">https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize(java.lang.String)</a>

***

As always, you can specify a name for your bean.

```
@Component("foo")
public class RESTFortuneService .... {
    
}
```
Then you can access it using the name of "foo". Nothing tricky to worry about

***

# Using @Qualifier with Constructors
**@Qualifier** is a nice feature, but it is tricky when used with Constructors.

The syntax is much different from other examples and not exactly intuitive.  Consider this the "deep end of the pool" when it comes to Spring configuration.

You have to place the @Qualifier annotation inside of the constructor arguments. 

Here's an example from our classroom example. I updated it to make use of constructor injection, with @Autowired and @Qualifier. 

```
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }
    
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        fortuneService = theFortuneService;
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
```

---

For detailed documentation on using @Qualified with Constructors, see this link in the Spring Reference Manual

<a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers">
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers
</a>

---

# FAQ: How to inject properties file using Java annotations

**FAQ: How to inject properties file using Java annotations**

**Answer:**

This solution will show you how inject values from a properties file using annotatons. The values will no longer be hard coded in the Java code.

**1. Create a properties file to hold your properties. It will be a name value pair.  **

New text file:  src/sport.properties

```
foo.email=myeasycoach@luv2code.com
foo.team=Silly Java Coders
```
Note the location of the properties file is very important. It must be stored in **src/sport.properties**

**2. Load the properties file in the XML config file.**

File: applicationContext.xml

Add the following lines:

```
    <context:property-placeholder location="classpath:sport.properties"/>  
```

This should appear just after the <context:component-scan .../> line

**3. Inject the properties values into your Swim Coach: SwimCoach.java**

```
@Value("${foo.email}")
private String email;
    
@Value("${foo.team}")
private String team;
```

