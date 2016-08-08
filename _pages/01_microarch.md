---
layout: page
title: Microcomputer Architecture
permalink: /microarch/
---

To really understand computer programming, first you need to understand how
computers work. Now, a modern computer is a complex machine. To make things 
easier, we'll have a look at the first microcomputers. They were first sold
in the 1970s, almost 50 years ago. However, on the
architecture level, these were already similar to the computer you're using
right now.

In a nutshell, a simple microcomputer consists of three distinct components:

* The *Central Processing Unit* or *CPU*
* The *Memory*, most of which is *Random Access Memory* or *RAM*
* Some interfaces to interact with the world, called *Inputs and Outputs* or *I/O*

<div class="mermaid">
graph LR;
    IO["I/O"]---CPU;
    CPU---Memory;
</div>

The CPU is where every programm actually gets executed. Everything the programm
does is performed here. The memory is where the program and also all the data
it uses is stored. And finally, the I/O devices can be anything from a keyboard, 
mouse, and monitor to virtual reality gear.

Let's begin with an extremely simple program. It will do nothing but add two 
numbers. In Java, it would look like this:

```java
public class SimpleExample {
    public static void main(String[] args) {
        System.out.println(3 + 4);
    }
}
```

Don't worry about Java's classes and methods for the moment. Instead, focus on
the core line `System.out.println(3 + 4);` and see what it contains:

* The numbers `3` and `4`.
* The arithmetic operation `+` is performed on them.
* The result is printed on an output channel called `System.out`.

However, before the program can be executed, it has to be translated into
something else, something the microcomputer actually understands: To
*machine code*. In Java, this process is very complex but since out program
is so simple, the translation is easy.

* The numbers don't have to be translated into anything else. In fact, a microcomputer understands nothing but numbers.
* All operations in machine code have a number too. E.g. `+` could have the number `39` -- or anything else. The operation "send something to an output channel" could be number `47`.
* The output channel `System.out` also gets a number, e.g. `1`.

A program in machine code is just a list of number. In our example, the program
could be `39, 3, 4, 47, 1`. Can you see how this works?

Now maybe you see why this is called "code."

To make our made-up machine code a little more realistic, we introduce one 
additional element: The *accumulator*. This where the CPU stores the operands
and results of operations. It is similar to a computer's memory except it is
part of the CPU itself and much faster to access. However, it can only save a
single data item.