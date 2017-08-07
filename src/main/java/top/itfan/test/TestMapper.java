package top.itfan.test;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ralap on 2017/8/7.
 */
@Mapper
public interface TestMapper {

    @Insert("insert into testuser(user_name,age) values(#{userName},#{age})")
    void save(TestUser user);

    @Select("select * from testuser")
    List<TestUser> getAll();
}
