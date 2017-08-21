package oracle.chapters.c_3_lexicalStructure.literals;

public class IntegerLiterals {
	/*
	 * Integer literals: DecimalIntegerLIterals, HexIntegerLiterals,
	 * OctalIntegerLiterals, BinaryIntegerLiterals,
	 */

	/*
	 * DecimalIntegerLiterals: DecimalNumeral [IntegerTypeSuffix]
	 */

	/*
	 * Integer suffix: l, L
	 */

	/*
	 * DecimalNumeral: 0, NonZeroDigit [Digit], NonZeroDigit _ Digits
	 */

	/*
	 * HexIntegerLiterals: HexNumeral, IntegerTypeSuffix,
	 */

	/*
	 * HexNumeral: 0x Hexdigits, 0X Hexdigits,
	 * 
	 * Hexdigits: Hexdigit Underscore Hexdigit (0 1 2 3 4 5 6 7 8 9 a b c d e f
	 * A B C D E F)
	 * 
	 */
	int hex = 0x0____a;

	/*
	 * OctalIntegerLiterals: OctalNumeral [IntegerTypeSuffix]
	 * 
	 * OctalNumeral: 0 OctalDigits (0 1 2 3 4 5 6 7), 0 Underscores OctalDigits
	 */
	int a = 0_0____7;

	/*
	 * BinaryIntegerLiterals: 0 b BinaryDigits, 0 B BinaryDigits
	 */
	int b = 0b0;
//	int b2 = 0B_0;
	int b3 = 0B0_1;
}
