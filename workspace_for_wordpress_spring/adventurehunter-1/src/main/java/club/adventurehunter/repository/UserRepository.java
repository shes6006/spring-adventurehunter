package club.adventurehunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import club.adventurehunter.domain.UserBean;



//Repository 是一個索引區
//extends JPA後就會按照JPA的規範把東西生出來

//原本在DAO的地方，會把東西貼上IBSN做上記號 

public interface UserRepository extends JpaRepository<UserBean, String>{
	
//新增修查ＣＲＵＤ自己產生
	
}