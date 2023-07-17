package patterns;
//https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java
public class BuilderComputer {
	//required params
	private String RAM;
	private String HDD;
	private String processor;
	
	//optional params
	private boolean isCamPresent;
	private boolean isGraphicsCardEnabled;
	private boolean isBlueToothEnabled;
	
	//private constructor and passing all the attribute values from builder class
	private BuilderComputer(Builder builder) {
		this.RAM = builder.RAM;
		this.HDD = builder.HDD;
		this.processor = builder.processor;
		this.isCamPresent = builder.isCamPresent;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBlueToothEnabled = builder.isBlueToothEnabled;
	}
	
	//construct builder
	public static class Builder {
		//required params
		private String RAM;
		private String HDD;
		private String processor;
		
		//optional params
		private boolean isCamPresent;
		private boolean isGraphicsCardEnabled;
		private boolean isBlueToothEnabled;
		
		public Builder(String RAM, String HDD, String processor) {
			System.out.println("processing required args");
			this.RAM = RAM;
			this.HDD = HDD;
			this.processor = processor;
		}
		
		public Builder setCam() {
			System.out.println("enabling CAM");
			this.isCamPresent = true;
			return this;
		}
		
		//optional setter should return Builder
		public Builder setGraphicsCard() {
			System.out.println("setting up graphics card");
			this.isGraphicsCardEnabled = true;
			return this;
		}
		
		public Builder setBlueTooth() {
			System.out.println("setting up bluetooth");
			this.isBlueToothEnabled = true;
			return this;
		}
		
		//this is the final master stroke to finish the puzzle
		//call the constructor of main class passing Builder obj
		public BuilderComputer build() {
			return new BuilderComputer(this);
		}
	}

}
