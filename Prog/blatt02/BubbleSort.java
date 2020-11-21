public class BubbleSort {
	public static void sort(int[] a) {
        int tmp; 
        for (int i = a.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){ 
                if (a[j] > a[j+1]){
                    tmp = a[j+1];
					a[j+1] = a[j];
					a[j] = tmp;
                }
            }
        }
	}
}

