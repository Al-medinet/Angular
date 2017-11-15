package org.musql.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("RE")

@XmlType(name="RE")
public class Retrait extends Operations{

}
