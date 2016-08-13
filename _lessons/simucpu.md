---
layout: page
title: Simulating the CPU
permalink: /lessons/simucpu/
---

The CPU is the part of a computer that does the main work. Essentially, it
repeats the same cycle again and again from the moment it is powered up until
it either is powered down or it hits a special stop instruction:

1. Get next instruction from memory.
2. Decode and execute that instruction.
3. If it wasn't the special stop instruction, repeat.

To understand how this happens, it is helpful to take a closer look at what
happens inside the CPU. The picture below shows the main components.

![CPU high level architecture](../cpu-arch-lv0.svg)



## Simulating the CPU in Java

What does that mean for our simulation? First, the CPU needs to be attached to
its memory. Second, the CPU needs to remember where it has to read the next 
instruction. For this, we will use a variable called *program counter* or *pc*
for short. Third, it needs a way to decode and execute instructions read from
memory.

In Java, it would look like this:

```java
public class Cpu {
    
    private Memory mem;
    public int pc = 0;
    
    public void attachMemory(Memory mem) {
        this.mem = mem;
    }
    
    public void run() {
        boolean continue = true;
        while (continue) {
            int nextInstruction = mem.read(pc++);
            continue = decodeAndExecute(nextInstruction);
        }
    }
    
    public boolean decodeAndExecute(int instruction) {
        // ...       
    }

}
```

Take some time to understand this code. Obviously, the real magic happens in the
`decodeAndExecute` method that is still empty. However, it's important that you 
see how this code models the loop described above. `decodeAndExecute` will
return `true` for any normal instruction and it will return `false` only for 
the special stop instruction. When it returns `false`, the `run` method will
end.

[Next, let's see how to implement our first instruction.](../haltinstr)