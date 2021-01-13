public class MutableMap<K, V> extends AbstractReadableMap<K, V> implements WritableMap<K, V>{

    public void put(K key, V value) {
        for(int i=0; i<this.entries.length; i++) {
            if(this.entries[i] == null || this.entries[i].getKey().equals(key) ) {
                Entry help = new Entry(key, value);
                this.entries[i] = help;
                this.entries[i] = new Entry<K, V>(key, value);

                return;
            } else {
                //int originalLength = this.entries.length;
                //this.entries = GenericArrayHelper.copyArrayWithIncreasedSize(this.entries, originalLength+1);
                //this.entries[originalLength+1] = new Entry<K, V>(key, value);

                int entrieslang=entries.length;
                Entry<K,V>[] oldentries=GenericArrayHelper.copyArray(entries);
                entries=GenericArrayHelper.copyArrayWithIncreasedSize(oldentries, 2*entries.length);
                Entry help1=new Entry(key,value);
                entries[entrieslang]=help1;
                entries[entrieslang] = new Entry<K, V>(key, value);

            }

        }
    } 
    
}
