---
layout: page
title: "Do nothing: The NOP instruction"
permalink: /lessons/nopinstr/
---

This is the overview for the `NOP`instruction:

| Op Code   || Mnemonic | Meaning |
| Hex  | Dec |          |         |
|------|-----|----------|---------|
| 0x00 | 0 | `NOP`     | Do nothing. |

And here is its implementation:

```java
    public boolean decodeAndExecute(int instruction) {
        switch (instruction) {
            case 0x00:
                // NOP
                break;
            case 0x76:
                // HLT
                return false;
            default:
                throw new RuntimeException("Unknown opcode 0x" + String.format("%02x", instruction));
        }
        return true;
    }
```

Now, the `NOP` opcode just exits the `switch` statement without doing anything, 
just like it should. At the end, `true` is returned to indicate that execution
should continue with the next instruction.

If you have followed this course up to now, you will now have the foundation 
of a microcomputer simulation.

[Let's write our first little program](../firstprog)