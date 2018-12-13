package iq.uLink.square;

class Square {

	private static char hashTag = '#';
	private static char newLine = '\n';
	private static char space = ' ';

	String drawSquare(int edge) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp;
		for (int i = 0; i < edge; i++) {
			temp = line(i, edge);
			sb.append(temp);
			sb.append(newLine);
		}
		return sb.toString();
	}

	String drawMultipleSquares(int[] edges) {
		StringBuilder sb = new StringBuilder();
		if (edges.length > 0) {
			int max = edges[edges.length - 1];
			for (int i = 0; i < max; i++) {
				sb.append(line(i, edges));
				sb.append(newLine);
			}
		}
		return sb.toString();
	}

	private StringBuilder line(int index, int edge) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < edge; j++) {
			if (index < edge) {
				if (index == 0 || index == edge - 1 || j == 0 || j == edge - 1) {
					sb.append(hashTag);
				} else {
					sb.append(space);
				}
			}
		}
		return sb;
	}

	private StringBuilder line(int index, int edges[]) {
		StringBuilder temp = new StringBuilder();
		for (int k = edges.length - 1; k > -1; k--) {
			int edge = edges[k];
			StringBuilder sb = line(index, edge);
			temp.replace(0, sb.toString().length(), sb.toString());
		}
		return temp;
	}
}
