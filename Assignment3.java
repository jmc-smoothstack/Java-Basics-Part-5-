
public class multiplyByTwo{
	public static void main(String args[]){

		int len = args.length;

		float [] arr = new float[len];

		for(int x=0; x<len; x++){
			arr[x] = Float.parseFloat(args[x]);
		}

		for(int x=0; x<len; x++){
			arr[x] *= 2;
		}

		for(float num : arr){
			System.out.println(num);
		}
		

	}
}
