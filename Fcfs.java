import java.util.Scanner;

class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }
        float avg_wt = 0;
        float avg_tat = 0;
        for (int i = 0; i < n; i++) {
            avg_wt += wt[i];
            avg_tat += tat[i];
            System.out.println("Process " + (i + 1) + ":\nBurst Time: " + bt[i] + "\nWaiting Time: " + wt[i] + "\nTurnaround Time: " + tat[i]);
        }
        System.out.println("Average Waiting Time: " + (avg_wt / n) + "\nAverage Turnaround Time: " + (avg_tat / n));
    }
}