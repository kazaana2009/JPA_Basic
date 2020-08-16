package hellojpa;

import org.hibernate.annotations.common.reflection.XMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //데이터베이스 연결 : hello의 설정된 데이터베이스
        //엔티티 매니저 팩토리는 하나만 생성해서 전체에 공유
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        //엔티티 매니저는 쓰래드간에 공유 x (사용자가 요청 할 때마다 생기고 닫고 해야함)
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx =entityManager.getTransaction();
        tx.begin();
        try {
            //맴버생성
            //Member member = new Member();
            //member.setId(2L);
            //member.setName("helloB");
            //entityManager.persist(member);
            //tx.commit();

            //맴버조회
            //Member findmember = entityManager.find(Member.class, 1L);
            //System.out.println("findmember ID: "+findmember.getId());
            //System.out.println("findmember NAME: "+findmember.getName());

            //맴버삭제
            //entityManager.remove(1L);

            //맴버수정
            //findmember.setName("choijaezhyuk");
            //tx.commit();


            //전체맴버조회
            //객체대상 쿼리 JPQL
            List<Member> result = entityManager.createQuery("select m from Member as m",Member.class).getResultList();

            for (Member member :result){
                System.out.println("member.name :"+member.getName());
                System.out.println("member.id :"+member.getId());
            }

        }catch (Exception e){
            tx.rollback();
        }finally {
            //매니저 닫아준다.
            entityManager.close();
        }

        //팩토리 닫아준다
        entityManagerFactory.close();;

    }
}
