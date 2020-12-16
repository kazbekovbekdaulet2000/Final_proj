package enums;

public enum Teacher_pos {
	Tutor("Tutor"),
	Lector("Lector"),
	Senior_lector("Senior Lector"),
	Professor("Professor");
	
	private String name;
	
	Teacher_pos(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	public static Teacher_pos fromString(String text) {
		for (Teacher_pos pos : Teacher_pos.values()) {
            if (pos.name.equalsIgnoreCase(text)) {
                return pos;
            }
        }
		return null;
	}
}
