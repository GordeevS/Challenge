package vamk.fi.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vamk.fi.demo.model.License;

@Repository
public interface LicenseRepository extends JpaRepository <License, Integer> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE license SET name=?1 WHERE id=?2 ",nativeQuery = true)        //update the name of the object where name is 1st argument and id is 2nd argument
    int modifyLicenseById(String licenseNae , int id);
}
