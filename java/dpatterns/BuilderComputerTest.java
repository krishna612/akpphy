package patterns;

public class BuilderComputerTest {
	
	public static void main(String[] args) {
		BuilderComputer comp = new BuilderComputer.Builder("16GB","1TB","i5")
								   .setBlueTooth()
								   .setCam()
				                   .build();
	}

}
