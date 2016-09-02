public class DotProduct {
	public int dotProduct(Dim [] a, Dim [] b) {
		int sum = 0;
		for(Dim dim : a) {
			Dim dim2 = search(dim, b);
			if(dim2 != null) {
				sum += dim.value * dim2.value;
			}
		}
		return sum;
	}

	public Dim search(Dim dim, Dim[] b) {
		int start = 0, end = b.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(b[mid].order == dim.order) {
				return b[mid];
			} else if(b[mid].order < dim.order) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(b[start].order == dim.order) return b[start];
		if(b[end].order == dim.order) return b[end];
		return null;
	}
	
}

class Dim {
	int order;
	int value;
}