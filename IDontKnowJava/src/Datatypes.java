
public class Datatypes {

	public static void main(String[] args) {
		byte b = 100; //implicit conversion
		short s = 30000; //implicit conversion
		int ii = 1000000;
		//Why do we use int datatype even if we are storing a small number
		//for ex: int x = 1;
		//long l = 9223372036854775807L; //explicit conversion

		double d = 999.99;
		float f = 999.99F; //explicit conversion
		
		boolean bool = true;
		
		char c = 'A';
		char c2 = 65; //ASCII
		char c3 = '\u0041'; //Unicode
		char c4 = '\u0905';
		char c5 = 'अ';
		
		//String is not a primitive type, it's an object type
		//For Object, memory is allocated dynamically
		//whereas in case of primitives, memory is fixed
		String str = "\u0041\u0042\u0043";
		System.out.println(str);
		
		String str2 = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println(c4);
		
		int[] arr = new int[5]; //0, 1, 2, 3, 4
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
		int[] arr2 = {100, 200, 300, 400, 500};
		
	}
}
