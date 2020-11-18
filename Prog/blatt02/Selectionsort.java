public class Selectionsort{

    public static void main(int[] a) {
        int min = 0; // min用来储存第几个数组
        int tmp;  // tmp 用来储存临时变量
        for (int i = 0; i <= a.length - 1; i++){ // 从0到n-1循环
            tmp = a[i];
            for (int j = i; j < a.length - 1; j++){ 
                if (tmp > a[j+1]){
                    tmp = a[j+1];
                    min = j + 1;
                }
            }
            a[min] = a[i];
            a[i] = tmp;
        }
    }
}