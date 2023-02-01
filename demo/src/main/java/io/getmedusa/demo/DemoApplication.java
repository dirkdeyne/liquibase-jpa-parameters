package io.getmedusa.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Component
class ParameterValues {
	final ParameterValueRepository parameterValueRepository;

	public ParameterValues(ParameterValueRepository parameterValueRepository) {
		this.parameterValueRepository = parameterValueRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void show(){
		parameterValueRepository.findAll().forEach(System.out::println);
	}
}

@Entity
class ParameterValue {
	@Id
	@Column(name = "p_name")
	private String name;
	@Column(name = "p_value")
	private String value;

	public String getName() {
		return name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ParameterValue{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}

@Repository
interface ParameterValueRepository extends ListCrudRepository<ParameterValue,String>{}
