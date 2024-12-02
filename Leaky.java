/* write a progrm for congestion control using a leaky bucket algorithm using java program*/

import java.io.*;
import java.util.Scanner;
class Leaky
{
public static int min(int x, int y)
{
if(x<y)
return x;
else
return y;
}
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int drop =0, mini,n,cap,count=0,i;
int inp[]=new int[25];
int process;
System.out.println("Enter the bucket Size\n");
cap = sc.nextInt();
System.out.println("Enter the output rate\n");
process = sc.nextInt();
System.out.println("Enter the number of packets\n");
n= sc.nextInt();
System.out.println("Enter the size of packet to be sent: ");
for(i=0;i<n;i++)
{
inp[i]=sc.nextInt();
}
System.out.println("\nSecond|Packet Recieved|Packet Sent|PacketLeft|Packet Dropped|\n");
System.out.println("----------------------------------------------------------------\n");
for(i=0;i<n;i++)
{
count+=inp[i];
if(count>cap)
{
drop=count-cap;
count=cap;
}
System.out.print(i+1);
System.out.print("\t" + inp[i]);
mini = min(count, process);
System.out.print("\t\t" + mini);
count = count-mini;
System.out.print("\t\t" + count);
System.out.println("\t\t" + drop);
drop=0;
}
for(; count!=0; i++)
{
if(count>cap) 
{
drop = count-cap;
count=cap;
}
System.out.print(i+1);
System.out.print("\t0");
mini = min(count, process);
System.out.print("\t\t" + mini);
count = count-mini;
System.out.print("\t\t" + count);
System.out.println("\t\t" + drop);
}
}
}
