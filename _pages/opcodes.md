---
layout: page
title: Opcodes
permalink: /opcodes/
---

| Op Code   || Mnemonic | Meaning |
| Hex  | Dec |          |         |
|------|-----|----------|---------|
| 0x00 |   0 | `NOP`       | Do nothing. |
| 0x3e |  62 | `MOV A, d8` | Move the given number into the A register |
| 0x76 | 118 | `HALT`      | Stop the CPU. |
| 0xc6 | 198 | `ADD d8`    | Add the given number to the contents of the A register |