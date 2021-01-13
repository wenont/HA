import java.util.Set;
import java.util.HashSet;

public interface ReadableMap<K, V> {
    V getOrThrow(K key) throws UnknownKeyException;
    ImmutableMap<K, V> asImmutableMap();
    Set<K> keysAsSet();
}
