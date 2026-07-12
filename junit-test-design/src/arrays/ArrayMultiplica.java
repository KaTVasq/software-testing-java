package arrays;

public class ArrayMultiplica {
	public int [] multiplica( int[] array1,int[]array2) {
		if(array1 == null || array2 == null) {
			return new int[0];
		}
		
		int minLong = Math.min(array1.length,array2.length);
		int maxLong = Math.max(array1.length, array2.length);
		
		int[] outArray= new int[maxLong];
		int[]longArray = (array1.length >array2.length) ? array1:array2;
		
		for(int i = 0;i< minLong;i++) {
			outArray[i]= array1[i]* array2[i];
		}
		
		for (int j = minLong; j < maxLong; j++) {
            outArray[j] = longArray[j];
        }

        return outArray;
	}
}
