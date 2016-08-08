package com.trueprog.andy;

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
	public void testMVI() {
	// Not testing MVI M, x
	mem.load(0,new int[]{0x06,0x42,0x0e,0x43,0x16,0x44,0x1e,0x45,0x26,0x48,0x2e,0x4c,0x3e,0x41,0x76 });
	cpu.run();
	fail("Not yet implemented");
	}

	@Test
	public void testMVIHL() {
		fail("Not yet implemented");
	}

	@Test
	public void testHLT() {
		mem.load(0, new int[] { 0x76 });
		cpu.run();
		assertEquals(1, cpu.getPc());
	}

}
