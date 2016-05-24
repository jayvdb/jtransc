package com.jtransc.mem;

/**
 * @TODO: Optimize this!
 */
public class BytesReadAlign {
	// 8-bit

	static public int u8l(byte[] data, int index) {
		return BytesRead.u8l(data, index * 1);
	}

	static public int u8b(byte[] data, int index) {
		return BytesRead.u8b(data, index * 1);
	}

	static public int s8l(byte[] data, int index) {
		return BytesRead.s8l(data, index * 1);
	}

	static public int s8b(byte[] data, int index) {
		return BytesRead.s8b(data, index * 1);
	}

	// 16-bit

	static public int u16l(byte[] data, int index) {
		return BytesRead.u16l(data, index * 2);
	}

	static public int u16b(byte[] data, int index) {
		return BytesRead.u16b(data, index * 2);
	}

	static public int s16l(byte[] data, int index) {
		return BytesRead.s16l(data, index * 2);
	}

	static public int s16b(byte[] data, int index) {
		return BytesRead.s16b(data, index * 2);
	}

	// 32-bit

	static public long u32l(byte[] data, int index) {
		return BytesRead.u32l(data, index * 4);
	}

	static public long u32b(byte[] data, int index) {
		return BytesRead.u32b(data, index * 4);
	}

	static public int s32l(byte[] data, int index) {
		return BytesRead.s32l(data, index * 4);
	}

	static public int s32b(byte[] data, int index) {
		return BytesRead.s32b(data, index * 4);
	}

	// 64-bit

	static public long s64l(byte[] data, int index) {
		return BytesRead.s64l(data, index * 8);
	}

	static public long s64b(byte[] data, int index) {
		return BytesRead.s64b(data, index * 8);
	}

	// float

	static public float f32l(byte[] data, int index) {
		return BytesRead.f32l(data, index * 4);
	}

	static public float f32b(byte[] data, int index) {
		return BytesRead.f32b(data, index * 4);
	}

	// double

	static public double f64l(byte[] data, int index) {
		return BytesRead.f64l(data, index * 8);
	}

	static public double f64b(byte[] data, int index) {
		return BytesRead.f64b(data, index * 8);
	}
}
