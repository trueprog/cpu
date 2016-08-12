---
layout: page
title: "Implementing MOV and ADD"
permalink: /lessons/movaddinstr/
---
Most likely, your Simulation threw a `RuntimeException` when you tried to run
it. Maybe you already figured out why this happened. If not, try.

Do you realize what we have missed?

In the previous article, we introduced two new opcodes and used them in our
machine language program. However, we never really implemented these opcodes!
The is what the `default` branch in the `switch` statement is for: Whenever an
unknown opcode is encountered, the CPU execution is terminated with an error.

So let's implement the two additional opcodes:

```java
    public boolean decodeAndExecute(int instruction) {
        switch (instruction) {
            case 0x00:
                // NOP
                break;
            case 0x3e:
                // MOV A, d8
                acc = mem.read[pc++];
                break;
            case 0x76:
                // HLT
                return false;
            case 0xc6:
                // ADD d8
                acc += mem.read(pc++);
                break;
            default:
                throw new RuntimeException("Unknown opcode 0x" + String.format("%02x", instruction));
        }
        return true;
    }
```

Try it again and with a little prudence, your `Simulator` should print out the
correct answer.

[Here's a summary of what you learned in this section.](../summary)