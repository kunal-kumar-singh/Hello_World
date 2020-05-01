//https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/lost-in-city-f6e7f540/description/
import java.util.*;
public class LostInCity {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int s=sc.nextInt()-1;
            

            int[] sweet=new int[n];
            int[] distance=new int[n];
            Arrays.fill(distance,Integer.MAX_VALUE);
            for(int i=0;i<n;i++){
                sweet[i]=sc.nextInt();
            }
            ArrayList[] graph=new ArrayList[n+1];
            for(int i=0;i<m;i++) {
                int start=sc.nextInt()-1;
                int end=sc.nextInt()-1;
                if(Objects.isNull(graph[start])) {
                    graph[start] = new ArrayList<Integer>();
                }
                graph[start].add(end);
            }
            Queue<Integer> p=new LinkedList<Integer>();
            distance[s]=sweet[s];
            p.add(s);
            while(!p.isEmpty()) {
                int temp=p.poll();
                ArrayList<Integer> parent=graph[temp];
                if(parent!=null) {
                    for(int i=0;i<parent.size();i++) {
                        int child=parent.get(i);
                        int value=Math.max(distance[temp], sweet[child]);
                        if(value<distance[child]) {
                            distance[child]=value;
                            p.add(child);
                        }
                    }
                }
            }
            for(int i=0;i<n;i++)
                System.out.print(distance[i]+" ");
            System.out.println();
        }
    }
}
