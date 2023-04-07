#include <stdio.h>     /* basic I/O routines.   */
#include <unistd.h>    /* define fork(), etc.   */
#include <sys/types.h> /* define pid_t, etc.    */
#include <sys/wait.h>  /* define wait(), etc.   */
#include <signal.h>    /* define signal(), etc. */
#include <pthread.h>   /* multithreads , etc. */
#include <stdlib.h> /*  standard library of c, etc. */
#include <sys/types.h> /* data type, etc. */
#include <sys/wait.h>  /* declartion for wait, etc. */
#include <unistd.h>   /* standard symbolic constants and types, etc. */
#include <conio.h> 
int main()
{
    int n,
    bt[100],
    wt[100],
    tat[100],
    avwt=0,
    avtat=0,
    i,
    j;
    
    printf("\nFirst Come First Serve \n");
    
    printf("Successfully created 10 processes.\n");
    
    // This is the setter for setting the amount of processes to 10
    n = 10;
 
    printf("Enter Burst time for 10 processes:\n");
 
    // Burst Times
    
    for(i=0;i<n;i++)
    {
        printf("P[%d]:",i+1);
        scanf("%d",&bt[i]);
    }
 
    wt[0]=0;    //waiting time for first process is 0
 
    //calculating waiting time
    for(i=1;i<n;i++)
    {
        wt[i]=0;
        for(j=0;j<i;j++)
            wt[i]+=bt[j];
    }
 
    printf("\nProcess\t\tBurst Time\tWaiting Time\tTurnaround Time");
 
    // Turnaround Time Calculator
    // Repeats the process 3 times
    printf("FCFS Calculation #1:\n");
    
    for(i=0;i<n;i++)
    {
        tat[i]=bt[i]+wt[i];
        avwt+=wt[i];
        avtat+=tat[i];
        printf("\nP[%d]\t\t%d\t\t%d\t\t%d",i+1,bt[i],wt[i],tat[i]);
    }

    avwt/=i;
    avtat/=i;
    printf("\n\nAverage Waiting Time:%d",avwt);
    printf("\nAverage Turnaround Time:%d",avtat);
    
        printf("FCFS Calculation #2:\n");
    
    for(i=0;i<n;i++)
    {
        tat[i]=bt[i]+wt[i];
        avwt+=wt[i];
        avtat+=tat[i];
        printf("\nP[%d]\t\t%d\t\t%d\t\t%d",i+1,bt[i],wt[i],tat[i]);
    }

    avwt/=i;
    avtat/=i;
    printf("\n\nAverage Waiting Time:%d",avwt);
    printf("\nAverage Turnaround Time:%d",avtat);
    
        printf("FCFS Calculation #3:\n");
    
    for(i=0;i<n;i++)
    {
        tat[i]=bt[i]+wt[i];
        avwt+=wt[i];
        avtat+=tat[i];
        printf("\nP[%d]\t\t%d\t\t%d\t\t%d",i+1,bt[i],wt[i],tat[i]);
    }

    avwt/=i;
    avtat/=i;
    printf("\n\nAverage Waiting Time:%d",avwt);
    printf("\nAverage Turnaround Time:%d",avtat);

    return 0;
    
    
}