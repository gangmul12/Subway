import java.io.*;

public class Subway {
	
	public static void main(String arg[]) throws IOException{
		Graph g = new Graph();
		File file = new File(arg[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
		
		try {	
			String str = br.readLine();
			while(str.length()!=0){
				g.addVertex(str);
				str = br.readLine();
			}
			str = br.readLine();
			while(str!=null){
				g.addEdge(str);
				str = br.readLine();
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		br = new BufferedReader(new InputStreamReader(System.in, "UTF8"));
		
		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("QUIT") == 0)
					break;

				command(input, g);
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		}
		
	}
	public static void command(String input, Graph g){
		Commander cmd = new Commander(input);
		cmd.Work(g);
		
	}

}


