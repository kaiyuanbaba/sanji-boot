package com.sj.boot.common.spring.data;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


/**
 * @author yangrd
 * @date 2019/1/8
 **/
@Getter
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity<E extends AbstractEntity> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
