import java.util.Arrays;

public class PaperRollCuttingBottomUp {
	
double price[];
int cuts[];
double optimal[];

boolean check[];

public PaperRollCuttingBottomUp(int n) {
	
if(n<=5) {
	n=6;
}
	price=new double[n+1];
	price[1]=1.2;
	price[2]=3;
	price[3]=5.8;
	price[5]=10.1;
	
	

	 
	
	
	check = new boolean [n+1];
	check[0]=true;
	check[1]=true;
	check[2]=true;
	check[3]=true;
	check[4]=false;
	check[5]=true;
	
	cuts=new int [n+1];
	optimal=new double [n+1];

	
}
public void bottomup(int n) {
	
	double a;
	optimal[0]=0;
	if(n==0) {
	System.out.println("Rod Length is zero bye bye");	
	}else
	for(int j =1;j<=n;j++) {
		a=Integer.MIN_VALUE;
		for(int i=1;i<=j;i++) {
			if(check[i]) {
			if(a<price[i]+optimal[j-1]){
				a=Math.max(a,price[i]+optimal[j-i]);
				cuts[j]=i;
				optimal[j]=a;
				}
			}
			

		}
	}
	System.out.println("prices : " +Arrays.toString(price));
	System.out.println("Optimal Prices : "+Arrays.toString(optimal));
	System.out.println("Cuts : "+Arrays.toString(cuts));
	double maxValue = optimal[0];
	  for(int i=1;i < optimal.length;i++){
	    if(optimal[i] > maxValue){
		  maxValue = optimal[i];
	    }
	  }
	  System.out.println("Maximum Value : "+maxValue);
	
}
	
	public static void main(String[] args) {
		PaperRollCuttingBottomUp p= new PaperRollCuttingBottomUp (5);
		p.bottomup(5);
	}
}


