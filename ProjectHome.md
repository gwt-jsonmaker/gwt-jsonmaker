gwt-jsonmaker is derived from gwt-jsonizer(http://code.google.com/p/gwt-jsonizer). It fixes all the bugs and works with GWT 2.0+ and Google chrome.

## Features: ##

1. Converts Java Beans into json string and vice versa. Java Beans can have objects of other beans as well.

2. Support for **all the collections** classes like ArrayList, HashMap, HashSet, Vectors etc. and Arrays.

3. Support for Date objects i.e. they can be used directly in the beans

4. **Support for annotations**
> a. @Transient: To not include a field during serialization

> b. @Required: To ensure that json contains a field before it can be converted to an object

> c. @Notnull: To ensure that if a field is null, serialization stops with an exception

> d. @PropName: To provide alias for a property during serialization


5. Can serialize/de-serialize native supported types and their collections out of the box i.e. without the need of creation of Jsonizer interfaces. [Details](https://code.google.com/p/gwt-jsonmaker/wiki/Getting_Started?ts=1290820569&updated=Getting_Started#6._There_is_no_need_to_create_additional_Jsonizers_for_native_su)

**Projects using Jsonmaker**

1.[gwt-maven-rewraps](http://code.google.com/p/gwt-maven-rewraps/)

2.[tibcopagebus4gwt](https://code.google.com/p/tibcopagebus4gwt/)

**Getting Started:**

1. add the following line in your `[`project`]`.gwt.xml file
```
    <inherits name="org.jsonmaker.gwt.Gwt_jsonmaker" />
```

2. Make a bean class e.g. Person

3. Make an interface with same name as bean class and 'Jsonizer' appended to it e.g. PersonJsonizer. Make it extend the Jsonizer interface. This interface can be made in the bean as well.

4.To jsonize a bean, create an instance of its Jsonizer using GWT.create() method and call asString method on it

5. To de-jsonize a json string of a bean, use JsonizerParser.parse(jsonizer\_instance, jsonString).

Below is the example code block
The Person bean without jsonizer declaration in its body
```
// a Person bean class.
class Person{
  ...
  public String getName(){...}
  public void setName(String name){...}
  ...
  public int getAge(){...}
  public void setAge(int age){...}
}
```
and jsonizer implemented in separate java file
```
/**
 * If you want to jsonize it, you need to implement an extension of 
 * Jsonizer interface using bean name suffixed with the 'Jsonizer' keyword.
 */
public interface PersonJsonizer extends Jsonizer{}
```
**The jsonizer can alternatively be defined within Person class**
```
// a Person bean class.
class Person{
  ...
  public String getName(){...}
  public void setName(String name){...}
  ...
  public int getAge(){...}
  public void setAge(int age){...}
  public interface PersonJsonizer extends Jsonizer{}
}
```
Let the jsonizing and de-jsonizing begin
```
//Create a Person Object

Person p = new Person();
p.setName("Andres");
p.setAge(28);

//Create a PersonJsonizer instance
PersonJsonzier pj = (PersonJsonizer)GWT.create(PersonJsonizer.class);
//Jsonize
String json = pj.asString(p);

// A JSON String with Person properties
//json = '{'name':'Andres','age':28}';

// Create the Person Jsonizer
PersonJsonizer jsonizer = (PersonJsonizer)GWT.create(PersonJsonizer.class);
try{
  // Translate the JSON String to a Person bean
  Person p = (Person)JsonizerParser.parse(jsonizer, json);
}catch(JsonizerException e){
  Window.alert('JSON Translation Error!');
}
```