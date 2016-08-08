---
layout: page
title: "Adding two numbers"
permalink: /simpleprog/
---
Let's begin with an extremely simple program. It will do nothing but add two 
numbers. In Java, it would look like this:

```java
public class SimpleExample {
    public static void main(String[] args) {
        System.out.println(3 + 4);
    }
}
```

We want to write it in machine language though.

Now this is a little more complicated that simply writing `3 + 4` because
traditionally, CPUs had no op codes that take *two* operands at the same time.
Instead, each op code only takes one operand &mdash; or none, as in the case
of `NOP` and `HALT`. To work with multiple operands, the CPU has it's own tiny
memory called *registers*. A register can only hold a single data item at a time.
The register we will use is called *accumulator*. It is used for most arithmetic
and logical operations.

Let's add it to the `Cpu` class:

```java
public class Cpu {
    
    private int acc;

    public int getAcc() {
        return acc;
    }

    // ...

    
}
```

We also need two more opcodes:

* One for moving the first number into the accumulator: `MVI`
* One for adding the second number `ADI`

This is 

So the whole program in machine language (using mnemonics) would be:

```nasm
MVI A, 3 ;load the number 3 into the accumulator
ADI 4    ;add the number 4 to the contents of the accumulator
HLT
```

The opcodes for `MVI` and `ADI` are `0x3e` and `0xc6`, respectively. 

Maybe you wonder why there is the letter "I" in the mnemonic. It stands for
*immediate*, i.e. the actual data follows immediately after the opcode. There
are other ways to provide data but for now that's all we need.

So altogether our program looks like this: `0x3e, 0x03, 0xc6, 0x04, 0x76`.

Let's enhance our `Simulation` class to print the contents of the accumulator
at the end of the program, so that we can see the actual result of the 
calculation.

```java
public class Simulation {
    
    public static void main(String[] args) {
        Memory mem = new Memory();
        System.out.println("Loading program into memory.");
        mem.load(0, new int[]{0x3e, 0x03, 0xc6, 0x04, 0x76});
        Cpu cpu = new Cpu();
        System.out.println("Attaching memory to the CPU");
        cpu.attachMemory(mem);
        System.out.println("Running the program");
        cpu.run();
        System.out.println("Finished, accumulator containts " + cpu.getAcc());
    }
}
```

Try this now and see if it prints the correct result.

[If it didn't, see the next article.](../mviadiinstr)