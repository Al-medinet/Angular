package org.musql.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("VE")


@XmlType(name="VE")
public class Versement extends Operations{

	
}
