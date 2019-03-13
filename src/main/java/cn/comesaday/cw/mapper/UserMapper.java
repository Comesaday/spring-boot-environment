package cn.comesaday.cw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.comesaday.cw.domain.User;

@Mapper
@Repository
public interface UserMapper {

	User login(@Param("account") String account, @Param("password") String password);
}
