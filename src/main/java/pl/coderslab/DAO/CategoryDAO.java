package pl.coderslab.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

}
