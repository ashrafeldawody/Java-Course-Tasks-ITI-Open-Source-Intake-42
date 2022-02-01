import java.util.StringTokenizer;
class IPCutter{
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Invalid Argument");
			System.exit(0);
		}
		String IPAddress = args[0];

		String[] splittedUsingSplit = IPAddress.split("\\.");
		
		if(!isValidIp(IPAddress)){
			System.out.println("Invalid IP, it must consists of 4 parts saperated by dot");
			System.exit(0);
		}
		
		
		System.out.println("Split By Split Function");
		for (String element : splittedUsingSplit) {
			System.out.println(element);
		}
		
		System.out.println("Split By Substring");
		splitBySubstring(IPAddress);
		
		System.out.println("Split By Tokenizer");
		SplitByTokenizer(IPAddress);

	}

	public static void splitBySubstring(String ip){
		int indexOfDot = ip.indexOf('.');

		while (indexOfDot != -1) {
			System.out.println(ip.substring(0, indexOfDot));
			ip = ip.substring(indexOfDot + 1);
			indexOfDot = ip.indexOf('.');
		}
		System.out.println(ip);
	}
	public static void SplitByTokenizer(String ip){
		StringTokenizer st = new StringTokenizer(ip,".");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	public static boolean isValidIp(String ip) {
		String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
		return ip.matches(PATTERN);
	}
}