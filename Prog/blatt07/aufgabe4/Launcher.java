public class Launcher {
    public static void main(String[] args) {
        MutableMap<String, Integer> map = new MutableMap();
        putEntries(map);
        printEntries(map);
        ImmutableMap<String,Integer> immutableMap = map.asImmutableMap();
        printEntries(immutableMap);
    }

    public static void putEntries(WritableMap<String,Integer> writableMap) {
		writableMap.put("sizeInMB",42);
		writableMap.put("version",4);
		writableMap.put("yearOfRelease",2015);
	}
	
	public static void printEntries(ReadableMap<String,Integer> readableMap) {
	
		for(String x : readableMap.keysAsSet()) {
			try {
				System.out.println(x + ":" + readableMap.getOrThrow(x).toString());
			} catch (UnknownKeyException e) {
				System.out.println("Es tritt einen Fehler auf!");
			}
			
		}
		
		
	}
}
