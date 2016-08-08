package com.trueprog.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.trueprog.cpu.Cpu;
import com.trueprog.cpu.Memory;

public class CpuTest {

	private Cpu cpu;
	private Memory mem;

	@Before
	public void setUp() {
		cpu = new Cpu();
		mem = new Memory();
		cpu.attachMemory(mem);
	}

	@Test(expected = RuntimeException.class)
	public void testStepIllegalOpcode() {
		mem.load(0, new int[] { 8 });
		cpu.step();
	}

	@Test
	public void testNOP() {
		mem.load(0, new int[] { 0 });
		assertEquals("before", 0, cpu.getPc());
		cpu.step();
		assertEquals("after", 1, cpu.getPc());
	}

	@Test
	public void testMVIReg() {
	// Not testing MVI M, x; see below
	mem.load(0,new int[]{0x06,0x42,0x0e,0x43,0x16,0x44,0x1e,0x45,0x26,0x48,0x2e,0x4c,0x3e,0x41,0x76 });
	cpu.run();
	assertEquals("A", 0x41, cpu.getA());
	assertEquals("B", 0x42, cpu.getB());
	assertEquals("C", 0x43, cpu.getC());
	assertEquals("D", 0x44, cpu.getD());
	assertEquals("E", 0x45, cpu.getE());
	assertEquals("H", 0x48, cpu.getH());
	assertEquals("L", 0x4c, cpu.getL());	
	}

	@Test
	public void testMVIHL() {
		mem.load(0, new int[]{0x26, 0xff, 0x2e, 0x00, 0x36, 0x4d, 0x76});
		cpu.run();
		assertEquals(0x4d, mem.read(0xff00));
	}

	@Test
	public void testHLT() {
		mem.load(0, new int[] { 0x76 });
		cpu.run();
		assertEquals(1, cpu.getPc());
	}

}
