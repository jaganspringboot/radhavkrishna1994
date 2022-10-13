package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

	//find books based on title
	
	public List<Book> findByTitle(String title);
	
	
	public List<Book> findByTitleLike(String titlePattern);
	
	@Query("from Book b where b.title like :titlepattern")
	public List<Book> getBooksTitlePattern(@Param("titlepattern") String titlePattern);
	
	
	// update stock of books by newstock based on titlepattern
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=b.stock + :newstock where b.title like :titlepattern")
	public int updateBooksStockTitle(@Param("titlepattern") String titlePattern
			,@Param("newstock") Long newStock);
}
