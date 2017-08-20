package uLink.tlv;

class TLV {

	int tlvMethod(int[] arr) {
		if (arr.length == 0) {
			return 0;
		} else if (arr.length == 1) {
			return arr[0];
		}

		int min = arr[0];
		int tempDif = arr[0];
		int dif = tempDif;

		for (int i = 1; i < arr.length; i++) {
			if (min < arr[i]) {
				tempDif = arr[i] - min;
				if (dif < tempDif) {
					dif = tempDif;
				}
			} else {
				min = arr[i];
			}
		}
		return dif;
	}

}
