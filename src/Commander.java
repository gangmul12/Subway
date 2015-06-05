import java.util.*;
class relaxInfo{
	int d=200000000;
	Node relax = null;
	public void set(int d, Node n){
		this.d = d;
		relax = n;
	}
	public relaxInfo(){
		d=200000000;
		relax = null;
	}
}


public class Commander {
	String start;
	String dest;
	boolean minTrans=false;
	Graph spanTree = new Graph();
	ArrayDeque<Node> ad = new ArrayDeque<Node>();
	
	public Commander(String input){
		String[] arg = input.split(" ");
		start = arg[0];
		dest = arg[1];
		if(arg.length==3){
			minTrans=true;
		}
		
	}
	public void Work(Graph g){
		if(minTrans)
			minTransfer(g);
		else
			minTime(g);
	}
	private void minTransfer(Graph g){
		
	}
	private void minTime(Graph g){
		dijkstra(g, g.adjList.get(g.idIdxMap.get(g.nameIdMap.get(start))));
		DFS();
		printResult();
		
	}
	
	private void dijkstra(Graph g, Node n){
		relaxInfo[] distance = new relaxInfo[g.vertex];
		boolean[] visited = new boolean[g.vertex];
		for(int i=0; i <g.vertex;i++){
			distance[i] = new relaxInfo();
		}
		for(int i=0; i <g.vertex;i++){
			visited[i] = false;
		}
		distance[g.idIdxMap.get(n.getId())].set(0, n);
		visited[g.idIdxMap.get(n.getId())]=true;
		for(edge i : n.adj){
			distance[g.idIdxMap.get(i.dest.id)].set( i.getW(), n);
		}
		spanTree.addVertex(n);
		int idx;
		for(int j = 1; j<g.vertex; j++){
			idx = smallestIdx(distance, visited);
			visited[idx]=true;
			Node newNode = g.adjList.get(idx);
			spanTree.addVertex(newNode);
			spanTree.addEdge(distance[idx].relax, distance[idx].relax.getConnectEdge(newNode));
			if(newNode.name.equals(dest))
				return;
			for(edge i : newNode.adj){
				int nextIdx = g.idIdxMap.get(i.dest.getId());
				if(visited[nextIdx]){
					continue;
				}
				if(distance[nextIdx].d==-1||distance[nextIdx].d>distance[idx].d+newNode.getConnectEdge(g.adjList.get(nextIdx)).weight){
					distance[nextIdx].d = distance[idx].d+newNode.getConnectEdge(g.adjList.get(nextIdx)).weight;
					distance[nextIdx].relax = newNode;
				}
			}
			
			
			
		}
		
	}
	
	private int smallestIdx(relaxInfo[] input, boolean[] v){
		int result = -1;
		for(int i=0; i<input.length; i++){
			if(v[i]==true)
				continue;
			if(result==-1)
				result=i;
			else if(input[i].d>=0&&input[result].d>input[i].d)
				result=i;
		}
		return result;
	}
	private void DFS(){
		boolean[] visited = new boolean[spanTree.vertex];
		ad.push(spanTree.adjList.get(0));
		visited[0]=true;
		while(!ad.isEmpty()){
			boolean availVertex = false;
			Integer availIdx=null;
			for(edge i : ad.peek().adj){
				if(!visited[spanTree.idIdxMap.get(i.dest.id)]){
					availVertex = true;
					availIdx=spanTree.idIdxMap.get(i.dest.id);
					break;
				}
			}
			if(!availVertex)
				ad.pop();
			else{
				ad.push(spanTree.adjList.get(availIdx));
				visited[availIdx]=true;
				if(ad.peek().name.equals(dest))
					break;
			}
			
		}
		Node lastNode = ad.removeLast();
		while(lastNode.getName().equals(ad.peekLast().getName()))
			lastNode = ad.removeLast();
		ad.addLast(lastNode);
	}
	
	private void printResult(){
		int time = 0;
		Node currNode = ad.removeLast();
		while(ad.size()!=0){
			if(currNode.getName().equals(ad.peekLast().getName())){
				System.out.print("["+currNode.getName()+"] ");
				time +=5;
				currNode = ad.removeLast();
				time+=currNode.getConnectEdge(ad.peekLast()).getW();
				currNode = ad.removeLast();
			}
			else{
				System.out.print(currNode.getName()+" ");
				time += currNode.getConnectEdge(ad.peekLast()).getW();
				currNode = ad.removeLast();
			}
		}
		System.out.println(dest);
		System.out.println(time);
	}

}
