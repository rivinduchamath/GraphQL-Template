package com.cloudofgoods.graphql.repository;

import com.cloudofgoods.graphql.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

        /*
      Point point = geometryFactory.createPoint( new Coordinate( 10, 5 ) );
      event.setLocation( point );
----------------------------------
    Polygon window = geometryFactory.createPolygon( coordinates );
      Event event = entityManager.createQuery(
    "select e " +
    "from Event e " +
    "where within(e.location, :window) = true", Event.class)
    .setParameter("window", window)
    .getSingleResult();
* */
}
