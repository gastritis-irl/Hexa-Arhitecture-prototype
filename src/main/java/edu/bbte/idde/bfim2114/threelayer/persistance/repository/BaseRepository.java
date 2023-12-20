package edu.bbte.idde.bfim2114.threelayer.persistance.repository;


import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
