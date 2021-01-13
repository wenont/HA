import java.util.Arrays;
public class GenericArrayHelper {
	public static <K, V> Entry<K, V>[] newEntryArrayOfSize(int size) {
		@SuppressWarnings("unchecked")
		Entry<K, V>[] result = new Entry[size];
		return result;
	}

	public static <T> T[] copyArrayWithIncreasedSize(T[] array,
			int newSize) {
		return Arrays.copyOf(array, newSize);
	}

	public static <T> T[] copyArray(T[] array) {
		return Arrays.copyOf(array, array.length);
	}
}
