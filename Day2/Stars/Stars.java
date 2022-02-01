class Stars{
	public static void main(String[] args){
		int n = 6;
		for(int i = 0;i<=n;i++){
			for(int j = 0;j<=i;j++){
				System.out.print("*");
			}
			for(int k = 0;k<=20 - i;k++){
				System.out.print(" ");
			}

			for(int k = n;k>=i;k--){
				System.out.print(" ");
			}
			
            for (int j = 0; j <= i - 1; j++) {
				System.out.print("*");
			}
            for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}