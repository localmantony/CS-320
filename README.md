# SNHU - CS-320: Software Testing, Automation, and Quality Assurance        

## How can I ensure that my code, program, or software is functional and secure?

Using JUnit testing and a structured approach that follows requirements, a java program can be made to meet requirements and avoid defects. 

## How do I interpret user needs and incorporate them into a program?

It's easiest to break down requirements one by one and implement the code in pieces. For instance, if one requirement was for a contact ID to have less than 10 characters. Right away we know that we'll have a contact object with contactID as an attribute, and when implementing its length will need to be compared against the number 10. From there we can construct the following code:

```java
public class Contact {
    private String id;
    
    public Contact(String id) {
        if (id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}

```

Now we have a good basic baseline for what the structure of most the project will look like and we can build out from there and introduce other requirements into that format.

## How do I approach designing software?

I approach designing software piece by piece in an attempt not to overwhelm myself and prevent long debugging sessions. I test often and thoroughly.
