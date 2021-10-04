package automation.utilities;

public enum TestCases {

	T1("Testing the authentication");
	//T2("Testing profile modification");
	
	private String testCase;
	
	TestCases(String value){
		this.testCase= value;
	}

	public String getTestCase() {
		return testCase;
	}
}
