---
layout: page
title: Simulating memory
permalink: /simumem/
---

The memory is the simplest.
It stores the program and any data the program works on. The CPU needs a way to
read the program and the data from the memory and write results to it.

```java
public class Memory {
    
    private int[] mem = new int[2^16];
    
    public int read(int address) {
        return mem[address];
    }
    
    public void write(int address, int data) {
        mem[address] = data;
    }
    
}
```

As you can see, the memory can only store numbers. That's generally the case
with everything a computer does: Everything needs to be encoded into numbers
because that is the only kind of thing it can work with. We will see how to
encode text and more complex structures, but for now we will just work with
numbers directly.

In the example, the memory is initialized as an array with 2<sup>16</sup>&nbsp;=&nbsp;65536 cells.
That is exactly 64&nbsp;kB<sup>[*](#footnote1)</sup>. Why this number? Traditionally, 8 bit microcomputers
actually had 16 bit of *address space*. Think of the memory as a long street
with houses numbered from 0 to some upper limit. With 16 bit, you can have 2<sup>16</sup>
houses.

To read one of the memory cells, we call the `read` method with the house number
as the parameter. It means: Give me the number that "lives" in that house number,
or *address*.

To write into one of the memory cells, we call the `write` method with the
address we want to write into and the number we want to move inside. Note that
only one number can "live" in each memory cell. When we write a second one to
that same address, the previous one is overwritten and forgotten.

Let's add one more method to the memory class for convenience. Assume we're loading
a program from a harddisk or an image from an SD card. In this case, we need an easy way to
load a whole sequence numbers into memory. Let's call this method `load`. 

```java
    public void load(int address, int[] data) {
        System.arraycopy(data, 0, mem, address, data.length);
    }
```

This loads the data given as a parameter into memory, starting at the specified
address.

The technical term for this kind of bulk loading from a storage device is
*Direct Memory Access* or *DMA*, but let's not worry about that too much now.

[Let's look at the CPU class next.](../simucpu)

***

<a name="footnote1"><sup>*</sup></a> Actually that's only true if the cells are 1 byte in
size. We're simulating an 8 bit microcomputer here, where this would be true.