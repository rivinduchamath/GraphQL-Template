package com.cloudofgoods.authservice.repository.daoImpl;

import com.cloudofgoods.authservice.entity.LoadAllDataWithRoles;
import com.cloudofgoods.authservice.repository.CustomDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomDAOImpl implements CustomDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<LoadAllDataWithRoles> getOrdersInfo() {
        List<Object[]> resultList = entityManager.createNativeQuery("select\n" +
                        "    authuserau0_.auth_user_id as auth_use2_4_0_,\n" +
                        "    authuserau0_.auth_role_id as auth_rol1_4_0_,\n" +
                        "    authuserau0_.auth_role_id as auth_rol1_4_1_,\n" +
                        "    authuserau0_.auth_user_id as auth_use2_4_1_,\n" +
                        "    authuserau0_.created_at as created_3_4_1_,\n" +
                        "    authuserau0_.updated_at as updated_4_4_1_,\n" +
                        "    authrole1_.id as id1_1_2_,\n" +
                        "    authrole1_.created_at as created_2_1_2_,\n" +
                        "    authrole1_.name as name3_1_2_,\n" +
                        "    authrole1_.updated_at as updated_4_1_2_\n" +
                        "from\n" +
                        "    auth_user_auth_role authuserau0_\n" +
                        "        left outer join\n" +
                        "    auth_role authrole1_\n" +
                        "    on authuserau0_.auth_role_id=authrole1_.id")
                .getResultList();
        List<LoadAllDataWithRoles> al = new ArrayList<>();
        for (Object[] cols : resultList) {
            System.out.println(Arrays.toString(cols));
        }
        return al;
    }

/* @Override
    public List<CustomEntity> getOrdersInfo(String query)  {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT O.id, C.customerId, C.name, O.date, SUM(OD.qty * OD.unitPrice) AS Total  FROM Customer C INNER JOIN `Order` O ON C.customerId=O.customerId " +
                "INNER JOIN OrderDetail OD on O.id = OD.orderId WHERE O.id LIKE ?1 OR C.customerId LIKE ?1 OR C.name LIKE ?1 OR O.date LIKE ?1 GROUP BY O.id")
                .setParameter(1, query)
                .getResultList();
        List<CustomEntity> al = new ArrayList<>();
        for (Object[] cols : resultList) {
            al.add(new CustomEntity((int) cols[0], (String) cols[1], (String) cols[2],
                    (Date) cols[3], (Double) cols[4]));
        }
        return al;
    }*/

}
