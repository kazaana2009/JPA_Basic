package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //jpa를 사용하는구나 라고 알아먹는다.
//@Table(name = "USER") //테이블 지정도 가능

public class Member {
    @Id
    private long id;
    //@Column(name = "username")  // VO와 DB테이블의 컬럼이 다르면 이런식으로 맵핑을해준다.
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
