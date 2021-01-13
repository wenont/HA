import java.util.Set;
import java.util.HashSet;


public abstract class AbstractReadableMap<K, V> implements ReadableMap<K, V>{
    Entry<K, V>[] entries;

    protected AbstractReadableMap(Entry<K, V>[] entries){
        this.entries = GenericArrayHelper.copyArray(entries) ;
    }

    protected AbstractReadableMap(){
        this.entries = GenericArrayHelper.newEntryArrayOfSize(10);
    }

    public V getOrThrow(K schluessel) throws UnknownKeyException {
        for (Entry<K, V> entry : this.entries) {
            if(entry.getKey().equals(schluessel)) {
                return entry.getValue();
            }
        }
        throw new UnknownKeyException();
    }

    public ImmutableMap<K,V> asImmutableMap(){
        return new ImmutableMap<>(entries);
    }

    public Set<K> keysAsSet(){
        HashSet<K> hashset = new HashSet<>();
        for(Entry<K,V> entry : entries) {
            if(entry!=null && entry.getValue()!= null) {
                hashset.add(entry.getKey());
            }
        }
        return hashset;
    }


}
