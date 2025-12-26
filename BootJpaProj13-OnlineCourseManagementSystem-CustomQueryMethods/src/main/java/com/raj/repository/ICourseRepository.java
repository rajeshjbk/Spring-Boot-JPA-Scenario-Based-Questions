package com.raj.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.raj.entity.Course;

import jakarta.transaction.Transactional;

public interface ICourseRepository extends CrudRepository<Course, Integer> {

	//===================== JPQL SELECT OPERATIONS ================================

	@Query("from Course where available = ?1")
	List<Course> showAllAvailableCourses(boolean active);

	@Query("from Course where instructor = ?1")
	List<Course> findCoursesByInstructor(String instructor);

	@Query("from Course where fee < ?1")
	List<Course> findCoursesFeeLessThan(double fee);

	@Query("SELECT c FROM Course c WHERE c.courseName LIKE %?1%")
	List<Course> searchCoursesByCourseNameLike(String keyword);


	@Query("from Course where duration > ?1")
	List<Course> showCoursesByDurationGreaterThan(int duration);

	@Query("SELECT c FROM Course c WHERE c.instructor = :instructor AND c.available = :status")
	List<Course> showCoursesByInstructorAndAvailable(
			@Param("instructor") String instructor,
			@Param("status") boolean status
			);


	//=================== AGGREGATION QUERIES =======================
	@Query("select distinct count(courseName) from Course where courseName =?1")
	long countTotalCourses(String courseName);

	@Query("select avg(fee) from Course where courseName =?1")
	double averageCourseFee(String courseName);

	@Query("select max(fee) from Course")
	double maximumCourseFee();

	@Query("select distinct count(courseName) from Course where instructor= ?1")
	long totalCoursesOfInstructor(String instructor);

	//================== UPDATE OPERATIONS (@Modifying) =====================
	
	@Query("update Course set fee = ?1 where courseId = ?2")
	@Modifying
	@Transactional
	int updateCourseFeeByCourseId(double newFee,int courseId);
	
	@Query("update Course set fee = (fee+fee*?1/100.0) where duration >=?2")
	@Modifying
	@Transactional
	int increaseCourseFeeByDurartion(double hikePercent,int duration);
	
	@Query("update Course set available=false where fee<= ?1")
	@Modifying
	@Transactional
	int deactivateCoursesByFee(double fee);
	
	//================ DELETE OPERATIONS (@Modifying) ===================
	
	@Query("delete from Course where available=false")
	@Modifying
	@Transactional
	int deleteInactivateCourses();
	
	@Query("delete from Course where instructor= ?1")
	@Modifying
	@Transactional
	int deleteCoursesByIntructor(String instructor);
	
	
	//================ NATIVE QUERY OPERATIONS ==============================
	@Query(value = "select * from Course_Details order by fee desc", nativeQuery = true)
	List<Course> fetchCoursesByDescOrder();

	@Query(value = "SELECT * FROM Course_Details ORDER BY fee DESC LIMIT 3", nativeQuery = true)
	List<Course> fetchTop3HighestFeeCourses();

}
