package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.models.Film;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query("select f from Film f join f.categorySet c where c.categoryId=?1")
    public List<Film> getMoviesByCategoryId(Integer id);

    @Query("SELECT new com.project.GGMovies.dtos.FilmDto(f.filmId, f.title, f.description, f.releaseDate, f.length, f.rating, f.backgorundUrl, f.posterUrl, f.popularity, f.adultOnly) from Film f join f.categorySet c where c.categoryId=?1 order by f.rating desc")
    public List<FilmDto> getTopRatedMoviesByCategoryId(Integer id, Pageable pageable);
//    

    @Query("SELECT new com.project.GGMovies.dtos.FilmDto(f.filmId, f.title, f.description, f.releaseDate, f.length, f.rating, f.backgorundUrl, f.posterUrl, f.popularity, f.adultOnly) from Film f join f.categorySet c where c.categoryId=?1 order by f.popularity desc")
    public List<FilmDto> getMostPopularMoviesByCategoryId(Integer id, Pageable pageable);
//    

    @Query("SELECT new com.project.GGMovies.dtos.FilmDto(f.filmId, f.title, f.description, f.releaseDate, f.length, f.rating, f.backgorundUrl, f.posterUrl, f.popularity, f.adultOnly) from Film f join f.categorySet c where c.categoryId=?1 order by f.releaseDate desc")
    public List<FilmDto> getMostRecentMoviesByCategoryId(Integer id,Pageable pageable);

    @Query("select f from Film f join f.userListSet l where l.user.userId=?1")
    public List<Film> getUserListByUserId(Integer id);

    @Query("select f from Film f where f.title like %?1%")
    public List<Film> getMoviesByTitle(String title);

    @Query("select f from Film f where f.language.languageId=?1")
    public List<Film> getMoviesByLanguageId(Integer id);

    @Query("SELECT new com.project.GGMovies.dtos.FilmDto(f.filmId) from Film f where f.title=?1 and f.description=?2")
    public FilmDto checkFilmByTitleAndDescription(String title, String description);

}
