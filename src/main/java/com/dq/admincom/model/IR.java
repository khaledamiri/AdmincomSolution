package com.dq.admincom.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe {

	private static final long serialVersionUID = -7429669529127371116L;

}
