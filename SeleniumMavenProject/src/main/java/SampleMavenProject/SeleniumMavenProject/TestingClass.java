package SampleMavenProject.SeleniumMavenProject;

public class TestingClass {

	public static void main(String[] args) {
		String str="Orange, S";
        
		String[] words=str.split(",");
		for(String w:words){  
			System.out.println(w.trim());  
			}  

	}

}
