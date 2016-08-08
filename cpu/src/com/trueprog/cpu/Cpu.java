package com.trueprog.cpu;

import java.util.HashMap;
import java.util.Map;

public class Cpu {

	
	/**
	 * Used for decoding registers from opcodes.
	 *
	 */
	private enum RegAddrs { B, C, D, E, H, L, M, A };

	private int a;
	private int f;
	private int b;
	private int c;
	private int d;
	private int e;
	private int h;
	private int l;
	private int pc = 0;
	private int sp = 0;

	private Memory mem;
	
	public void attachMemory(Memory mem) {
		this.mem = mem;
	}

	/**
	 * Execute a single execution step.
	 */
	public boolean step() {
		int instruction = mem.read(pc++);
		return decodeAndExecute(instruction);
	}

	/**
	 * This is basically the microcode.
	 * 
	 * @param instruction
	 * @return false if a HLT instruction was encountered
	 */
	private boolean decodeAndExecute(int instruction) {
		switch (instruction) {
		case 0x00:
			// NOP
			break;
		case 0b00000110:
		case 0b00001110:
		case 0b00010110:
		case 0b00011110:
		case 0b00100110:
		case 0b00101110:
		case 0b00110110:
		case 0b00111110:
			// MVI reg, d8 (move immediate)
			int reg = (instruction & 0b00111000) >> 3;
			int data = mem.read(pc++);
			switch (RegAddrs.values()[reg]) {
			case B:	b = data; break;
			case C: c = data; break;
			case D: d = data; break;
			case E: e = data; break;
			case H: h = data; break;
			case L: l = data; break;
			case M: mem.write(256 * h + l, data);
			case A: a = data; break;
			}
			break;
		case 0x76:
			// HLT;
			return false;
		case 0xc6:
			// ADI (or ADD A, d8)
			a += mem.read(pc++);
			break;
		default:
			throw new RuntimeException("Illegal opcode 0x" + String.format("%02x", instruction));
		}
		return true;
	}

	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public int getD() {
		return d;
	}
	
	public int getE() {
		return e;
	}
	
	public int getH() {
		return h;
	}
	
	public int getL() {
		return l;
	}
	
	public int getPc() {
		return pc;
	}

	public int getSp() {
		return sp;
	}
	public void run() {
		boolean proceed = true;
		while (proceed) {
			proceed = step();
		};
	}

}
