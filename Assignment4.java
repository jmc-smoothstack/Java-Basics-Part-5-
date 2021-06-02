
public class removeX{
	public static void main(String args[]){

		int len = args.length;

		String[] arr = new String[len];

		for(int x=0; x<len; x++){
			arr[x] = args[x].replace("x","");
		}

		for(String str : arr){
			System.out.println(str);
		}	

	}
}
