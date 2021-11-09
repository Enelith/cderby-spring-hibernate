# Bean Lifecycle Method Annotations - Overview

You can add custom code during **bean initialization** and **bean destruction**.

1. Define your methods for init and destroy
2. Add annotations : @PostConstruct and @PreDestroy

@PostConstruct : Code will execute after constructor **and** after injection or dependencies.

@PreDestroy : Code will execute **before** bean is destroyed.

---

# Special Note about @PostConstruct and @PreDestroy Method Signatures

I want to provide additional details regarding the method signatures of @PostContruct and @PreDestroy methods.

##### Access modifier
The method can have any access modifier (public, protected, private)

##### Return type
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

##### Method name
The method can have any method name.

##### Arguments
The method can not accept any arguments. The method should be **no-arg**.

---

# HEADS UP - FOR JAVA 9, 10 and 11  USERS - @PostConstruct and @PreDestroy

If you are using Java 9 or higher, then you will encounter an error when using @PostConstruct and @PreDestroy in your code. 

These are the steps to resolve it. Come back to the lecture if you hit the error. 

##### Error

Eclipse is unable to import @PostConstruct or @PreDestroy

This happens because of Java 9 and higher. 

When using Java 9 and higher, javax.annotation has been removed from its default classpath. That's why we Eclipse can't find it.

---

##### Solution

1. Download the javax.annotation-api-1.3.2.jar from : 
<a href="https://search.maven.org/remotecontent?filepath=javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar">
https://search.maven.org/remotecontent?filepath=javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar
</a>

2. Copy the JAR file to the **lib** folder of your project

---

Use the following steps to add it to your Java Build Path.

3. Right-click your project, select **Properties**

4. On left-hand side, click **Java Build Path**

5. In top-center of dialog, click **Libraries**

6. Click **Classpath** and then Click **Add JARs ...**

7. Navigate to the JAR file **<your-project>/lib/javax.annotation-api-1.3.2.jar**

8. Click **OK** then click **Apply and Close**

Eclipse will perform a rebuild of your project and it will resolve the related build errors.

---

# Special Note about Destroy Lifecycle and Prototype Scope
Here is a subtle point you need to be aware of with "prototype" scoped beans.

For "prototype" scoped beans, Spring does not call the @PreDestroy method. 

I didn't know this either until I dug through the Spring reference manual researching a student's question.

Here is the answer from the Spring reference manual. Section 1.5.2

<a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes-prototype">
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes-prototype
</a>        

> In contrast to the other scopes, Spring does not manage the complete lifecycle of a
prototype bean: the container instantiates, configures, and otherwise assembles a
prototype object, and hands it to the client, with no further record of that prototype
instance.

> Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding. 

> To get the Spring container to release resources held by prototype-scoped beans, try using a custom bean post-processor, which holds a reference to beans that need to be cleaned up.

This also applies to XML configuration.

---

##### QUESTION: How can I create code to call the destroy method on prototype scope beans

##### ANSWER:

You can destroy prototype beans but custom coding is required. This examples shows how to destroy prototype scoped beans.

1. Create a custom bean processor. This bean processor will keep track of prototype scoped beans. During shutdown it will call the destroy() method on the prototype scoped beans.

2. The prototype scoped beans MUST implement the DisposableBean interface. This interface defines a "destroy()" method. This method should be used instead of the @PreDestroy annotation.

3. In this app, BeanProcessorDemoApp.java is the main program. TennisCoach.java is the prototype scoped bean. TennisCoach implements the DisposableBean interface and provides the destroy() method. The custom bean processing is handled in the MyCustomBeanProcessor class.