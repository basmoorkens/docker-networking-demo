package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  long id;
	
	@Column(name = "greetername")
	private String name;
	
    private String greeting;

    public Greeting() {
	
    }

    public Greeting(long id, String name, String greeting) {
        this.id = id;
        this.name = name;
        this.greeting = greeting;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
    	this.id = id;
    }
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
