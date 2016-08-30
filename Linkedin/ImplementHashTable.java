import java.util.*;

/**
	Implement a hashtable with multithread handler
*/
public class ImplementHashTable<K,V> {
	Entry<K,V>[] entries;
	int capacity;
	int count;
	
	public ImplementHashTable<K, V>(int capacity) {
		this.capacity = capacity;
		this.entries = new Entry<K,V>[capacity];
	}

	public synchronized V put(K key, V value) {
		int h = hash(key);
		int index = h % capacity;
		Entry<K,V> e = null;

		//modify old value
		for(e = entries[index]; e != null; e = e.next) {
			if(e.key == key) {
				V old = e.value;
				e.value = value;
				return old;
			}
		}

		Entry<K, V> newEntry = new Entry<K,V>(key, value);
		newEntry.next = entries[i];
		entries[i] = newEntry;

		count++;
		if(count >= capacity) {
			resize();
		}
	}

	public synchronized V get(K key) {
		int h = hash(key);
		int index = h % capacity;

		Entry<K, V> e = null;
		for(e = entries[index]; e.next != null;) {
			if(e.key.equals(key)) {
				return e.value;
			}
			e = e.next;
		}
		return null;
	}

	public int hash(K key) {
		return key.hashCode();
	}

	public void resize() {
		capacity *= 2;
		Entry<K,V> newEntries = new Entry<K,V>[capacity * 2];
		for(int i = 0; i < entries.length; i++) {
			for(Entry<K, V> old = entries[i]; old != null; ) {
				Entry<K, V> e = old;
				old = old.next;

				int index = e.key % (newEntries.length);
				e.next = newEntries[index];
				newEntries[index] = e;
			}
			
		}

		entries = newEntries;

	}
}

class Entry<K,V> {
	K key;
	V value;
	Entry<K,V> next;

	public Entry<K,V>(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}