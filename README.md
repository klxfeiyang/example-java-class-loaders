# Java class loader example

To test loading a class into a different class loader we will use the class "Timer". This class increments and prints in the console the value of a static variable
```java
private static Integer count = 0;
```

In Java a static variable is shared between all instances of the class (which were loaded by the same classloader)

##### Running a class several times,  all instances in the same "java classLoader" (default)
- All instances will share the same static variable
```shell
> instance_1: 1
> instance_2: 2
> instance_3: 3
> instance_1: 4
> instance_2: 5
> instance_3: 6
> instance_1: 7
> instance_2: 8
> instance_3: 9
> ...
```

##### Each instance in a new "java classLoader"
- Classes loaded by different classLoader do not share static variables
```shell
> instance_1: 1
> instance_2: 1
> instance_3: 1
> instance_1: 2
> instance_2: 2
> instance_3: 2
> instance_1: 3
> instance_2: 3
> instance_3: 3
> ...
```

## How to run the example

First, build the source by running `mvn package`.

Next, run `java -cp target/classes/ nif.spike.a.RunInTheSameClassLoader` or the
corresponding class name.

