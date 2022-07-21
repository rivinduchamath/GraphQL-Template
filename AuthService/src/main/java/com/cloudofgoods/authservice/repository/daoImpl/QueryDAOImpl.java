package com.cloudofgoods.authservice.repository.daoImpl;

import com.cloudofgoods.authservice.entity.customentity.LoadAllDataWithRoles;
import com.cloudofgoods.authservice.repository.QueryDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<LoadAllDataWithRoles> getOrdersInfo() {
        List<Object[]> resultList;
        resultList = entityManager.createNativeQuery("select\n" +
                        "    authuser.auth_user_id ,\n" +
                        "    authuser.auth_role_id as auth_rol1_4_0_,\n" +
                        "    authuser.created_at as created_3_4_1_,\n" +
                        "    authuser.updated_at as updated_4_4_1_,\n" +
                        "    authrole.id as id1_1_2_,\n" +
                        "    authrole.created_at as created_2_1_2_,\n" +
                        "    authrole.name as name3_1_2_,\n" +
                        "    authrole.updated_at as updated_4_1_2_\n" +
                        "from\n" +
                        "    auth_user_auth_role authuser\n" +
                        "        left outer join\n" +
                        "    auth_role authrole\n" +
                        "    on authuser.auth_role_id=authrole.id")
                .getResultList();
        List<LoadAllDataWithRoles> al = new ArrayList<>();
        for (Object[] cols : resultList) {
            al.add(new LoadAllDataWithRoles((BigInteger)cols[0],(BigInteger)cols[1],(Date) cols[2],(Date)cols[3]
                    ,(String)cols[6],(Date)cols[5],(Date)cols[7]));
        }
        return al;
    }

}
