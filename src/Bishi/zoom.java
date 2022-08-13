package Bishi;

import java.util.*;

public class zoom {

    private static Set<Integer> vis;
    private static char[] color;
    private static char root_color;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strn = sc.nextLine();
        int n = Integer.parseInt(strn);
//        System.out.println(n);
        String s = sc.nextLine();
//        System.out.println(s);
        color = s.toCharArray();
        root_color = color[0];
        int[] arr = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int n1,n2;
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            map.getOrDefault(n1, new LinkedList<>()).add(n2);
            map.getOrDefault(n2, new LinkedList<>()).add(n1);
        }
        vis = new HashSet<>();
        dfs(map, arr, 1, 0);
        long ans = 0;
        for(Integer e:arr){
            System.out.println(e);
            ans+=e;
        }
        System.out.println(ans);

    }
    public static void dfs(Map<Integer, List<Integer>> map, int[] arr, int div, int node){
        arr[node] = Math.abs(div);
        vis.add(node);
        for(Integer n: map.getOrDefault(node, new LinkedList<>())){
            if(!vis.contains(n)){
                vis.add(n);
                int n_div = div + (color[n]==root_color?1:-1);
                dfs(map, arr, n_div, n);
            }
        }
    }
}
