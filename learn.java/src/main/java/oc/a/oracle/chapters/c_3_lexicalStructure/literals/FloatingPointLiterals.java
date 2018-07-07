package oc.a.oracle.chapters.c_3_lexicalStructure.literals;

public class FloatingPointLiterals {

	/**
	 * FloatingPointLiteral: DecimalFloatingPointLiteral,
	 * HexadecimalFloatingPointLiteral
	 */
	
	/*
	 * DecimalFloatingPointLiteral:
	 * Digits . [Digits] [ExponentPart] [Floating typeSuffix],
	 * . Digits [ExponentPart] [FloatingTypeSuffix], 
	 * Digits ExponentPart [FloatingTypeSuffix]
	 * Digits [ExponentPart] [FloatingTypeSuffix]
	 */
	
	/*
	 * ExponentPart:
	 *  e/E +/- Digits
	 */
	
	/*
	 *FloatingTypeSuffix
	 *f F d D 
	 */
	
	/*
	 * Digits (0 1 2 3 4 5 6 7 8 9)
	 */
	
	/*
	 * HwxadecimalFloatingPointLiteral:
	 * HexSignificand BinaryExponent [FloatTypeSuffix]
	 * 
	 * HexSignificand:
	 * HexNumeral [.]
	 * 0 x [HexDigits] . HexDigits
	 * 0 X [HexDigits] . HexDigits
	 * 
	 */
	
	/*
	 * BinaryExponent:
	 * BinaryExponentIndicator (test/P) SignedInteger
	 * 
	 */
	
}
