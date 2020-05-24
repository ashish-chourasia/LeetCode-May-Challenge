package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day22_SortCharactersByFrequency {

//	public static String frequencySort(String str) {
//		Map<Character, Integer> map = new HashMap<>();
//		int max = 0; 
//		for(int i=0; i<str.length(); i++) {
//			char ch = str.charAt(i);
//			map.put(ch, map.getOrDefault(ch, 0) + 1);
//		}
//		
//		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
//			System.out.println("key: "+entry.getKey()+"\tvalue: "+entry.getValue());
//		}
//			
//		return null;
//	}
	public static String frequencySort(String s) {
	    if (s == null) {
	        return null;
	    }
	    Map<Character, Integer> map = new HashMap();
	    char[] charArray = s.toCharArray();
	    int max = 0;
	    for (Character c : charArray) {
	        if (!map.containsKey(c)) {
	            map.put(c, 0);
	        }
	        map.put(c, map.get(c) + 1);
	        max = Math.max(max, map.get(c));
	    }

	    List<Character>[] array = buildArray(map, max);

	    return buildString(array);
	}

	private static List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet()) {
	        int count = map.get(c);
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	private static String buildString(List<Character>[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = array.length - 1; i > 0; i--) {
	        List<Character> list = array[i];
	        if (list != null) {
	            for (Character c : list) {
	                for (int j = 0; j < i; j++) {
	                    sb.append(c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		String str = "tree";
		System.out.println(frequencySort(str));
	}
	/*
	 * Input:
		"tree"
		
		Output:
		"eert"
	 */
}
