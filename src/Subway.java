import java.io.*;

public class Subway {
	
	public static void main(String arg[]) throws IOException{
		long startTime = System.currentTimeMillis();
		Graph g = new Graph();
		try {
			BufferedReader br = new BufferedReader(new FileReader(arg[0]));
			
			String str = br.readLine();
			
			while(str.length()!=0){
				g.addVertex(str);
				str = br.readLine();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
			startTime = System.currentTimeMillis();
			str = br.readLine();
			while(str!=null){
				g.addEdge(str);
				str = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		
		
	}

}
