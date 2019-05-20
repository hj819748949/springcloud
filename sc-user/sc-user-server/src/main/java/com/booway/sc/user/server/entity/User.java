package com.booway.sc.user.server.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Entity
@Getter
@Setter
@Table(name = "t_user")
public class User implements Serializable
{
	private static final long serialVersionUID = 3273852407189722785L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int age;
	
}
