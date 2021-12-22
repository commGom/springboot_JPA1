package jpabook.jpaitem;

import jpabook.jpaitem.domain.Member;
import jpabook.jpaitem.domain.Order;
import jpabook.jpaitem.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        try {
            Order order=new Order();
            order.addOrderItem(new OrderItem());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}

