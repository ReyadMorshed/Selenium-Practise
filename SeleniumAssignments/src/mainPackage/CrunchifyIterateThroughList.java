package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CrunchifyIterateThroughList {
	public static void main(String[] args) {
        // create list
        List<Integer> crunchifyList = new ArrayList<Integer>();
        // add 4 different values to list
        crunchifyList.add(4);
        crunchifyList.add(5);
        crunchifyList.add(6);
        crunchifyList.add(7);
        int max = 0;
        for(int i = 0;i<crunchifyList.size();i++) {
        	if(crunchifyList.get(i)>max) {
        		max = crunchifyList.get(i);
        	}
        }
        
        System.out.println("Maximum number is " + max);
        
    }
}
