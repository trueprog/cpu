---
layout: page
title: Microcomputer Architecture
permalink: /lessons/microarch/
---

To really understand computer programming, we will implement the simulation of
a simple 8 bit microcomputer in Java.

A classic microcomputer consists of three major components:

* The *Central Processing Unit* or *CPU*
* The *Memory*, most of which is *Random Access Memory* or *RAM*
* The *Input/Output Subsystem* to interact with the world

<div class="mermaid">
graph LR;
    IO["I/O Subsystem"]---CPU;
    CPU---Memory;
</div>

The CPU is where every programm actually gets executed. Everything the programm
does is performed here. The memory is where the program and also all the data
it uses is stored. And finally, the I/O devices can be anything from a keyboard, 
mouse, and monitor to virtual reality gear.

We will model each of these as a Java class:

```java
public class Cpu {
    // ...
}
```

```java
public class Memory {
    // ...
}
```

```java
public class IOSubsytem {
    // ...
}
```

[Next, let's think about what each class needs to do.](../simumem)

