package com.trueprog.cpu;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class Cpu {

	int acc;
	int psw = 0;
	int bc;
	int de;
	int hl;
	int sp = 0;
	int pc = 0;

	Memory mem;

	IntSupplier[] inputs = new IntSupplier[256];
	IntConsumer[] outputs = new IntConsumer[256];

	public Cpu() {
		for (int i = 0; i < 256; i++) {
			initInput(i);
			initOutput(i);
		}
	}
	
	public void attachMemory(Memory mem) {
		this.mem = mem;
	}

	public void initInput(final int port) {
		inputs[port] = new IntSupplier() {
			public int getAsInt() {
				throw new RuntimeException("No input supplied at port " + port);
			}
		};
	}

	public void initOutput(final int port) {
		outputs[port] = new IntConsumer() {
			public void accept(int output) {
				throw new RuntimeException("No output attached to port " + port);
			}
		};
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
			// MVI
			break;
		case 0x76:
			// HLT;
			return false;
		default:
			throw new RuntimeException("Illegal opcode 0x" + String.format("%02x", instruction));
		}
		return true;
	}

	public int getPc() {
		return pc;
	}

	public void run() {
		boolean proceed = true;
		while (proceed) {
			proceed = step();
		};
	}

}
