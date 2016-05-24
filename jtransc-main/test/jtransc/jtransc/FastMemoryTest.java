package jtransc.jtransc;

import com.jtransc.*;
import com.jtransc.mem.BytesRead;

import java.util.Arrays;

public class FastMemoryTest {
	static public void main(String[] args) {
		testFastMemory();
		testMem();
		testCopyReinterpret();
		testViews();
		testRawMem();
		testBits();
	}

	private static void testFastMemory() {
		FastMemory mem = new FastMemory(1024);
		mem.setInt8(0, (byte) 255);
		mem.setInt8(1, (byte) 255);
		mem.setInt8(2, (byte) 255);
		mem.setInt8(3, (byte) 0);
		System.out.println(mem.getInt32(0));
	}

	private static void testMem() {
		FastMemory mem = new FastMemory(1024);
		mem.setInt8(0, (byte) 255);
		mem.setInt8(1, (byte) 255);
		mem.setInt8(2, (byte) 255);
		mem.setInt8(3, (byte) 0);
		Mem.select(mem);
		System.out.println(Mem.li32(0));
		System.out.println(Mem.li16(1));
		System.out.println(Mem.li8(3));
		System.out.println(Mem.sxi8(255));
		System.out.println(Mem.sxi8(0x80));
		System.out.println(Mem.sxi8(0x7F));
	}

	private static void testCopyReinterpret() {
		byte[] data = JTranscArrays.copyReinterpret(new int[]{0x12345678, 0x33332222});
		System.out.println(Arrays.toString(data));
	}

	private static void testViews() {
		FastMemory mem = new FastMemory(1024);
		FastMemory4Int ints = new FastMemory4Int(mem);
		FastMemory4Float floats = new FastMemory4Float(mem);
		floats.set(0, 1f);
		System.out.println(mem.getLength());
		System.out.println(ints.getLength());
		System.out.println(floats.getLength());
		System.out.println(ints.get(0));
	}

	private static void testRawMem() {
		System.out.println("testRawMem:");
		Mem.select(new FastMemory(1024));
		Mem.si32(0, 0x12345670);
		System.out.println(Mem.li8(0));
		System.out.println(Mem.li8(1));
		System.out.println(Mem.li8(2));
		System.out.println(Mem.li8(3));
		Mem.si8(0, (byte) 255);
		System.out.println(Mem.li8(0) < 0);
	}

	private static void testBits() {
		System.out.println("testBits (all true):");
		System.out.println(BytesRead.s32l(new byte[]{0, 1, 0, 0, 0}, 1) == 1);
		System.out.println(BytesRead.s32l(new byte[]{0, 2, 1, 0, 0}, 1) == 0x100 + 2);
		System.out.println(BytesRead.s32b(new byte[]{(byte) 0x71, (byte) 0x32, (byte) 0xE3, (byte) 0xF4}, 0) == 0x7132E3F4);
		System.out.println(BytesRead.s32l(new byte[]{(byte) 0x71, (byte) 0x32, (byte) 0xE3, (byte) 0xF4}, 0) == 0xF4E33271);
		System.out.println(BytesRead.u16b(new byte[]{(byte) 0xF1, (byte) 0x32}, 0) == 0xF132);
		System.out.println(BytesRead.u16l(new byte[]{(byte) 0xF1, (byte) 0x32}, 0) == 0x32F1);
		System.out.println(BytesRead.s16b(new byte[]{(byte) 0xF1, (byte) 0x32}, 0) == (int)(short)0xF132);
		System.out.println(BytesRead.s16l(new byte[]{(byte) 0xF1, (byte) 0x32}, 0) == (int)(short)0x32F1);
	}
}
