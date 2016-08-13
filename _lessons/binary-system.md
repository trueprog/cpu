---
title: The Binary System
layout: page
permalink: /lessons/binary-system/
---
At the lowest level, a computer works with electrical signals. A key invention in the history of computers was to use only two different signals rather than many. This is called the binary system, from Latin  "bini" which means "twofold".

The binary system allowed computers to be more robust and thus smaller and faster. It is much easier to distinguish two states than many. The light is on or off. That's a binary signal. But if you have a fancy light that can change the brightness, it's hard to tell if it's 50% on or already 60% - or maybe only 45%. You need to look more carefully to distinguish many states, and if you want to be precise, it takes longer.

It's the same with computers: Old calculation machines used the decimal system with states for the familiar digits 0, 1, 2, ..., 8, 9. These machines were easier to use maybe, but they took more space, were slower, and more difficult to built. 

The binary system allowed computers to be faster and cheaper. So how can you do complex tasks with only two states, on and off? To answer this question, let's look at numbers and simple calculations first. Once you have understood this, we can move on to more complex things like text, images, and even games. 

## Writing numbers

In the binary system, you write numbers very similar to the normal way we do it, except you only use two digits, `0` and `1`. Consider how you write numbers in the decimal system that we're used to. We use the familiar digits 0 to 9, but then we add a second digit to the number: 10. Then we go on to 99, where we have to add a third digit: 100. 

The binary system works in the same way. "Zero" and "one" are simply the digits `0` and `1`. For "two," we already need to add another digit: `10`. "Three" in the binary system is `11` and for "four" we have to add yet another digit: `100`. Don't misread that as "one hundred" because it is really a binary number.

To distinguish the two, many programming languages add `0b` in front of the number. So `100` is "one hundred" but `0b100` is "four".

The table below shows you the numbers up to 16 in the binary system. 

| Decimal | Binary | Decimal | Binary |
|---------|--------|---------|--------|
| 0 | 0 | 8 | 1000 |
| 1 | 1 | 9 | 1001 |
| 2 | 10 | 10 | 1010 |
| 3 | 11 | 11 | 1011 |
| 4 | 100 | 12 | 1100 |
| 5 | 101 | 13 | 1101 |
| 6 | 110 | 14 | 1110 |
| 7 | 111 | 15 | 1111 |

# Exercises

1. Convert the following numbers into binary: 17, 31, 1024
2. Convert the following numbers into the decimal system: 0b11011, 0b111110, 0b10000
3. What is the largest number you can write in binary using eight digits?
4. Can you figure out what happens in binary when you multiply a number by two?