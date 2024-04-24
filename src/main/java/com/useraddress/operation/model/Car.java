package com.useraddress.operation.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "CAR")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAR_ID")
	private long id;

	@Column(name = "CAR_NAME")
	private String name;

//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name ="CAR_ID", referencedColumnName = "CAR_ID")// these two line only  only for OnetoMany
//	mappedBy = "car",
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<CarVariants> carVariant = new ArrayList<CarVariants>();

}
