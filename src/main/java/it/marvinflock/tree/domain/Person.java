package it.marvinflock.tree.domain;

import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@NoArgsConstructor
public class Person {

  @Id
  @GeneratedValue
  private Long id;

  private List<String> lastNames;
  private List<String> firstNames;
  private Long birthday;


  @Relationship(direction = Relationship.UNDIRECTED, type = "PARENT")
  private Set<Person> parents;


}
