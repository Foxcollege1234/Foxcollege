import java.util.*;

public class crc {
	void div(int a[], int k) {
		int gp[] = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		System.out.print("The divisor is: ");
		
		for(int i=0; i<17; i++) {
			System.out.print(gp[i]+" ");
		}
		System.out.println();
		
		int count=0;
		for(int i=0;i<k;i++) {
			if(a[i]==1) {
				for(int j=i; j<17+i; j++) {
					a[j] = a[j]^gp[count++];
				}
				count=0;
			}
		}
	}
	
	public static void main(String[] args) {
		 int a[] = new int[100];
		 int b[] = new int[100];
		 int len, k;
		 int flag = 0;
		 crc ob = new crc();
		 
		 System.out.println("Transmitter side");
		 System.out.println("-----------------------------------");
		 System.out.println("Enter length of data frame");
		 Scanner sc = new Scanner(System.in);
		 len = sc.nextInt();
		 k=len;
		 System.out.println("Enter the message:");
		 
		 for(int i=0; i<len; i++)
		 {
		 	a[i] = sc.nextInt();
		 }
		 
		 for(int i=0; i<16; i++)
		 {
		 	a[len++] = 0;
		 }
		 
		 for(int i=0; i<len; i++)
		 {
		 	b[i] = a[i];
		 }
		 
		 ob.div(a, k);
		 
		 System.out.print("\nThe CRC at the sender: ");
		 for(int i=k; i<len; i++)
		 	System.out.print(a[i] + " ");
		 System.out.println();
		 
		 for(int i=0; i<len; i++)
		 	a[i] = a[i]^b[i];
		 System.out.print("\n Data to be transmitted: ");
		 
		 for(int i=0;i<len;i++) 
		 {
			System.out.print(a[i]+ " ");
		 }
		 System.out.println();
		 
		 System.out.println("\n\nReciever side ");
		 System.out.println("----------------------------------------------------");
		 System.out.println("Enter the received data:");
		
		 for(int i=0; i<len; i++)
		 {
		 	a[i] = sc.nextInt();
		 }
		 
		 ob.div(a, k);
		 System.out.println();
		 System.out.print("\nThe CRC at the reciever: ");
		 for(int i=k; i<len; i++)
		 	System.out.print(a[i] + " ");
		 System.out.println();
		 
		 for(int i=0; i<len; i++)
		 {
		 	if(a[i]!=0)
		 	{
		 		flag=1;
		 		break;
		 	}
		 }
		 
		 System.out.print("\nResult of CRC error detection: ");
		 if(flag==1)
		 	System.out.println("Error in the data - Resend the data again");
		 else
		  	System.out.println("Data is recieved successfully");
	}
}
