---
layout: page
title: "Your first program"
permalink: /firstprog/
---

Given that the only two opcodes out simulator understand are "do nothing" and
"stop doing anything," your first program will be a bit boring. But it will
get better soon. Let's first look at how things work in principle.

As usual in Java, we need some class with a `main` method to run things.

```java
public class Simulation {
    
    public static void main(String[] args) {
        Memory mem = new Memory();
        System.out.println("Loading program into memory.");
        mem.load(0, new int[]{0x00, 0x00, 0x76});
        Cpu cpu = new Cpu();
        System.out.println("Attaching memory to the CPU");
        cpu.attachMemory(mem);
        System.out.println("Running the program");
        cpu.run();
        System.out.println("Finished");
    }
}
```

Do you see how the `Memory.load` method is used to load the program into memory?
The program consists of the numbers 0x00, 0x00 and 0x76. Using the mnemonics,
you can read that as:

```nasm
NOP
NOP
HLT
```

Try to run this with `java Simulation`. It will print out the various steps of
the simulation but apart from this, it does &hellip; nothing. No surprise, with
the somewhat boring opcodes we've implemented so far.

At least we know two things:

* The program finished (the technical term is *terminated*), as opposed to running forever.
* The main execution loop works, including incrementing the program counter. We know this because the `HLT` instruction is only the third one, and it has been reached or else the program would run forever.

Yay, this was your first machine language program! Time to throw a party.

[Let's move on to something more interesting.](../simpleprog)