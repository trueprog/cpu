package com.trueprog.cpu;

public class Memory {

	private final int[] mem = new int[65536];
	
	public int read(int addr) {
		return mem[addr];
	}
	
	public void write(int addr, int data) {
		mem[addr] = data;
	}
	
	public void load(int addr, int[] data) {
		System.arraycopy(data, 0, mem, addr, data.length);
	}
	
}
