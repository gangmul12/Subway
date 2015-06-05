import java.util.*;
class Node{
	String id;
	String name;
	String line;
	ArrayList<edge> adj= new ArrayList<edge>();

	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getLine(){
		return line;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Node(Node in){
		this.id = in.id;
		this.name = in.name;
		this.line = in.line;
	}
	public Node(String in){
		String[] strArr = in.split(" ");
		if(strArr.length!=3){
			id = strArr[0];
			return;
		}
		id = strArr[0];
		name = strArr[1];
		line = strArr[2];
	}
	public void addEdge(Node n, int w){
		adj.add(new edge(n, w));
	}
	
}

class edge{
	Node dest = null;
	int weight = 0;
	public edge(Node n, int w){
		dest = n;
		weight = w;
		
	}
	public int getW(){
		return weight;
	}
	public Node getDest(){
		return dest;
	}
}

public class Graph {
	HashMap<String, Integer> idIdxMap = new HashMap<String, Integer>();
	HashMap<String, String> nameIdMap = new HashMap<String, String>();
	ArrayList<Node> adjList = new ArrayList<Node>();
	int vertex = 0;
	public void addVertex(String input){
		String[] arg = input.split(" ");
		idIdxMap.put(arg[0], vertex);
		adjList.add(new Node(input));
		if(nameIdMap.get(arg[1])!=null){
			addEdge(idIdxMap.get(nameIdMap.get(arg[1])), vertex);
			addEdge(vertex, idIdxMap.get(nameIdMap.get(arg[1])));
		}
		nameIdMap.put(arg[1], arg[0]);
		vertex++;
	}
	public void addEdge(String input){
		String[] arg = input.split(" ");
		Node s = adjList.get(idIdxMap.get(arg[0]));
		Node dest = adjList.get(idIdxMap.get(arg[1]));
		int weight = Integer.parseInt(arg[2]);
		s.addEdge(dest, weight);
	}
	public void addEdge(int i, int j){
		Node s = adjList.get(i);
		Node dest = adjList.get(j);
		s.addEdge(dest, 5);
	}

}
