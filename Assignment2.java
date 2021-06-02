
public class returnRMD{
	public static void main(String args[]){

		int len = args.length;

		String[] arr = new String[len];

		for(int x=0; x<len; x++){
			int num = Integer.parseInt(args[x]);
			arr[x] = Integer.toString(num%10);
		}

		for(String str : arr){
			System.out.println(str);
		}
	}
}
