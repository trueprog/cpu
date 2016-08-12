---
layout: page
title: "The first instruction: HLT"
permalink: /lessons/haltinstr/
---

Time to implement the first instruction. Remember that everything needs to be 
encoded as numbers. I have mentioned the "special stop instruction" before. 
In machine language, each instruction has a memorizable name so you don't
always have to remember its number. The special stop instruction is called `HLT`.

In our simulation, we will give it the number 118. In machine language, it is
common practice to use the *hexadecimal* (or *hex*) system, because all 8 bit
numbers can be written using only 2 characters. For instance, 118 in decimal is
76 in hex. to distinguish decimal numbers from hex numbers, they are written
like this: 0x76. In fact, you can write them exactly like this in Java.

The number associated with an instruction is called its *Op Code* and the name is
called its *Mnemonic*. Here's a handy overview for our first instruction:

| Op Code   || Mnemonic | Meaning |
| Hex  | Dec |          |         |
|------|-----|----------|---------|
| 0x76 | 118 | `HLT`     | Stop the CPU. |

Look at the following implementation and make sure you understand what it does.

```java
    public boolean decodeAndExecute(int instruction) {
        switch (instruction) {
            case 0x76:
                // HLT
                return false;
            default:
                throw new RuntimeException("Unknown opcode 0x" + String.format("%02x", instruction));
        }
        return true; // Your Java compiler will probably complain because this line can't ever be reached.
    }
```

If a `HLT` op code is encountered, the method return `false`, causing the `run`
loop to stop. In every other case, a `RuntimeException` is thrown, basically
because no other op codes are known to our simulator yet.

Your Java compiler will complain about the line containing `return true;` because
this line can actually never be reached. Let's fix that quickly by adding one
other opcode. The new instruction will be to do nothing at all. It's mnemonic is
`NOP` literally for "no operation." It may seem funny, but all CPUs I am aware
of have such a `NOP` instruction.

[It's easily implemented. Can you imagine how?](../nopinstr)






