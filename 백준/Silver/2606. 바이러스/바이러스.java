import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count, num, connections;
    static boolean[] visited;
    static List[] computers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        connections = Integer.parseInt(br.readLine());

        visited = new boolean[num+1];
        computers = new List[num+1];

        count = 0;
        
        for (int i=1; i<num+1; i++) {
            computers[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for (int i=0; i<connections; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }

        bfs(1);
        
        System.out.println(count-1);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(!visited[now]) {
                count++;
                visited[now] = true;
                for (int i=0; i<computers[now].size(); i++) {
                    queue.add((int)computers[now].get(i));
                }
            }
        }
    }
}