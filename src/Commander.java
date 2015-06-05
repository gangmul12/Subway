
public class Commander {
	String start;
	String dest;
	boolean minTrans=false;
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
		Graph spanTree = new Graph();
		
		
	}
	
	private Graph dijkstra(Graph g, Node n){
		int[] distance = new int[g.vertex];
		Graph S = new Graph();
		for(int i=0; i<g.vertex; i++){
			if(n.adj.)
		}
	}

}
