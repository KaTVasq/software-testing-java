package arrays;

public class ArrayEnMovimiento {
	public int[] moverUno(int[] inArray) {
        // Caso borde: null o vacío → devolver array vacío
        if (inArray == null || inArray.length == 0) {
            return new int[0];
        }

        int[] outArray = new int[inArray.length];
        outArray[0] = -1;

        // Copiar todos los elementos menos el último desplazándolos una posición
        for (int i = 1; i < inArray.length; i++) {
            outArray[i] = inArray[i - 1];
        }

        return outArray;
    }
}
