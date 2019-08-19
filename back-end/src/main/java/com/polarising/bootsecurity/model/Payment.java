package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Payment {
	
	private Long id;
	
	@NotBlank(message="${app.model.message.required}")
	private Transaction transation;

	@NotBlank(message="${app.model.message.required}")
	@Size(min=5, max=5, message="${app.model.message.length} 5")
	private Long entity;

	@NotBlank(message="${app.model.message.required}")
	@Size(min=9, max=9, message="${app.model.message.length} 9")
	private Long reference;

	// Add Payment
	public Payment(Transaction transation, Long entity, Long reference) {
		super();
		this.transation = transation;
		this.entity = entity;
		this.reference = reference;
	}
	
	// Get Payment
	public Payment(Long id, Transaction transation, Long entity, Long reference) {
		super();
		this.id = id;
		this.transation = transation;
		this.entity = entity;
		this.reference = reference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransation() {
		return transation;
	}

	public void setTransation(Transaction transation) {
		this.transation = transation;
	}

	public Long getEntity() {
		return entity;
	}

	public void setEntity(Long entity) {
		this.entity = entity;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}
}
