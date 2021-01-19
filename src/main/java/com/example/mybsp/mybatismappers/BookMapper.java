package com.example.mybsp.mybatismappers;

import com.example.mybsp.domainpojos.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select max(id) as mxid from books")
    int getMaxId();

    @Select("select * from books")
    List<Book> findAll();

    @Select("select * from books where id = #{id}")
    Book findById(Long id);

    @Insert("insert into books values (#{newId}, #{name}, #{authorName})")
    void insertOne(int newId, String name, String authorName);

    @Update("update books set authorName = #{theValue} where id = #{id}")
    void updateBookAuthor(Long id, String theValue);
}
