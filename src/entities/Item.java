package entities;

public class Item {
	
	private String name;
	private String publisher;
	private Double average;

	public Item(String name, String publisher, Double average) {
		this.name = name;
		this.publisher = publisher;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

}
