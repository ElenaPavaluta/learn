package oc.a.chapters._6_exceptions.usingATryStatement.throwingASecondException;

import java.io.FileReader;
import java.io.IOException;

public class SecondException {

	private static FileReader read() throws IOException {
		throw new IOException();
		// return null; //unreachable code
	}

	public static void main(String[] args) {
		FileReader reader = null;

		try {
			reader = read();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
