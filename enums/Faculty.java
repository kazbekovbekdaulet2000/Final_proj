package enums;

public enum Faculty {
	FIT("FIT","Faculty of Information Technologies"),
	FGGE("FGGE", "Faculty of Geology and Geological Exploration"),
	FEOGI("FEOGI","Faculty of Energy and Oil & Gas Industry"),
	FGE("FGE","Faculty of General Education"),
	BS("BS","Bussines School"),
	ISE("ISE", "International School of Economics"),
	KMA("KMA","Kazakhstan Maritime Academy"),
	SMC("SMC", "School of Mathematics and Cybernetics"),
	SCE("SCE", "School of Chemical Engineering"),
	CAE("CAE", "Center of Chemical Engineering"),
	SECMSCP("SEC MSCP");
	
	public String name;
	public String decryption;
	
	Faculty(String name) {
		this.name = name;
	}
	
	Faculty(String name, String decryption) {
		this.name = name;
		this.decryption = decryption;
	}
	
	public String toString() {
		if(decryption!=null) {
			return name+ "("+ decryption+")";
		}
		return name;
	}
	
	
}
