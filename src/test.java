import java.util.*;
class Nodet{
	String s;
	int k;
	public Nodet(String ss, int kk){
		s=ss;
		k=kk;
	}
	public Nodet(int kk){
		s=null;
		k=kk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + k;
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
		Nodet other = (Nodet) obj;
		if (k != other.k)
			return false;
		return true;
	}
	
}
public class test {
	public static void main(String arg[]){
		/*
		ArrayList<Nodet> al = new ArrayList<Nodet>();
		al.add(new Nodet("wow", 2));
		al.add(new Nodet("double", 4));
		System.out.println(al.indexOf(new Nodet(2)));*/
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("wow", 1);
		h.put("no", 1);
		h.put("wow", 2);
		System.out.println(h.get("pee"));
		
	}

}
