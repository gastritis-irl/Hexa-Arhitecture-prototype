package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository;


import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
