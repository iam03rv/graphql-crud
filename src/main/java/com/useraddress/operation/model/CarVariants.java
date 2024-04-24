package com.useraddress.operation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CAR_VARIANTS")
public class CarVariants {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAR_VARIANT_ID")
	private Long id;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "Model")
	private String model;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
	@JsonBackReference
	private Car car;
}
