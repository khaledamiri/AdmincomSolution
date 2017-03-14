package com.dq.admincom.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe {

}
