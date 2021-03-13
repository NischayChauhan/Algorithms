import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
		long T = scanner.nextLong();

		while(T>0){
			long A = scanner.nextLong();
			long B = scanner.nextLong();
			long C = scanner.nextLong();
			long K = scanner.nextLong();

			System.out.println(helper(A,B,C,K));
			T--;
		}

    }

    private static long f(long a,long b,long c,long x){
    	return (a*x*x) + (b*x) + c;
    }

    private static long helper(long A,long B,long C,long K){
    	if(C>=K)
    		return 0;

    	long left = 1;
    	long right = (int) Math.sqrt(K);

    	long mid = (left+right)/2;

    	while(left<=right){

    		if(f(A,B,C,mid)>= K && f(A,B,C,mid-1)<K){
    			return mid;
    		}

    		if(f(A,B,C,mid)>=K){
    			right = mid-1;
    		}else{
    			left = mid+1;
    		}
			mid = (left+right)/2;
    	}
        if(f(A,B,C,mid)>= K && f(A,B,C,mid-1)<K){
            return mid;
        }

        if(f(A,B,C,mid)>=K){
            return mid-1;
        }else{
            return mid+1;
        }
    	// return mid;
    }
}
