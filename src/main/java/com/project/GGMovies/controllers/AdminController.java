package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.dtos.LanguageDto;
import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.UserRepository;
import com.project.GGMovies.request.AdminSignup;
import com.project.GGMovies.request.SignupRequest;
import com.project.GGMovies.respone.MessageResponse;
import com.project.GGMovies.services.ICategoryService;
import com.project.GGMovies.services.IFilmService;
import com.project.GGMovies.services.ILanguageService;
import com.project.GGMovies.services.IRoleService;
import com.project.GGMovies.services.ITransactionService;
import com.project.GGMovies.services.IUserService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IFilmService iFilmService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IRoleService iRoleService;

    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    ITransactionService iTransactionService;

    @Autowired
    ILanguageService iLanguageService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>> getAllMovies() {
        return ResponseEntity.ok().body(iFilmService.getAllMovies2());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(iCategoryService.getAllCategories());
    }

    @GetMapping("/getCategory/{category_name}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable("category_name") String name) {
        return ResponseEntity.ok().body(iCategoryService.getCategoryByName(name));
    }

    @PostMapping(value = "/insertMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> insertMovie(@RequestBody FilmDto film) {
        if (!iFilmService.filmExists(film.getFilmTitle(), film.getFilmDescription())) {
            iFilmService.insertMovie(film);
            return ResponseEntity.ok().body(film);
        } else {
            return ResponseEntity.badRequest().body(film);
        }
    }

    @PostMapping(value = "/updateMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> updateMovie(@RequestBody FilmDto film) {
        iFilmService.insertMovie(film);
        return ResponseEntity.ok().body(film);
    }

    @GetMapping("/deleteMovie/{film_id}")
    public void deleteMovie(@PathVariable(value = "film_id") Integer id) {
        iFilmService.deleteMovie(id);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(iUserService.getAllUsers());
    }

    @GetMapping("/getRoleById/{role_id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("role_id") Integer id) {
        return ResponseEntity.ok().body(iRoleService.getRoleById(id));
    }

    @GetMapping("/test/name/{name}")
    public ResponseEntity<RoleDto> getRoleByRoleName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(iRoleService.getRoleByRoleName(name));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("user_id") Integer id) {
        return ResponseEntity.ok().body(iUserService.getUserById(id));
    }

    @PostMapping("/insertUser")
    public ResponseEntity<UserDto> insertNewUser(@RequestBody UserDto user) {

        if (!iUserService.isUsedEmail(user.getUserEmail())) {
            iUserService.insertUser(user);
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().body(user);
        }
    }

//    @PostMapping("/updateUser")
//    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
//        if (iUserService.isUsedEmail(user.getUserEmail())) {
//            if (iUserService.getUserDtoByEmail(user.getUserEmail()).getId() == user.getId()) {
//                iUserService.insertUser(user);
//                return ResponseEntity.ok().body(user);
//            } else {
//                return ResponseEntity.badRequest().body(user);
//            }
//        } else {
//            iUserService.insertUser(user);
//            return ResponseEntity.ok().body(user);
//        }
//    }
    @GetMapping("/deleteUser/{user_id}")
    public void deleteUser(@PathVariable(value = "user_id") Integer id) {
        iUserService.deleteUser(id);
    }

    @GetMapping("/topRated/{category_id}")
    public ResponseEntity<List<FilmDto>> topRatedMoviesCategoryId(@PathVariable(value = "category_id") Integer id) {
        return ResponseEntity.ok().body(iFilmService.getTopRatedMoviesByCategoryId(id));
    }

    @GetMapping("/topRatedMovies")
    public ResponseEntity<List<FilmDto>> getTopRatedMovies() {
        return ResponseEntity.ok().body(iFilmService.getTopRatedMovies());
    }

    @GetMapping("/mostPopularMovies")
    public ResponseEntity<List<FilmDto>> getMostPopularMovies() {
        return ResponseEntity.ok().body(iFilmService.getMostPopularMovies());
    }

    @GetMapping("/mostRecentMovies")
    public ResponseEntity<List<FilmDto>> getMostRecentMovies() {
        return ResponseEntity.ok().body(iFilmService.getMostRecentMovies());
    }

    @GetMapping("/getCategories/{film_id}")
    public ResponseEntity<List<CategoryDto>> getCategoryByMovieId(@PathVariable(value = "film_id") Integer id) {

        return ResponseEntity.ok().body(iCategoryService.getCategoryByMovieId(id));
    }

    @GetMapping("/mostPopular/{category_id}")
    public ResponseEntity<List<FilmDto>> mostPopularMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }

    @GetMapping("/mostRecent/{category_id}")
    public ResponseEntity<List<FilmDto>> mostRecentMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }

    @GetMapping("/getUsersByRoleId/{user_id}")
    public ResponseEntity<List<UserDto>> getUsersByRoleId(@PathVariable(value = "user_id") Integer id) {

        return ResponseEntity.ok().body(iUserService.getUsersByRoleId(id));
    }

    @GetMapping("/getAllUsersExeptByRoleId/{user_id}")
    public ResponseEntity<List<UserDto>> getAllUsersExeptByRoleId(@PathVariable(value = "user_id") Integer id) {

        return ResponseEntity.ok().body(iUserService.getAllUsersExeptByRoleId(id));
    }

    @GetMapping("/getAllTransactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> result = iTransactionService.getAllTransactions();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTransactions")
    public ResponseEntity<List<TransactionDto>> getLastTransactions() {

        return ResponseEntity.ok().body(iTransactionService.getLastTransactions());
    }

    @GetMapping("/getMonthlyUserStats")
    public ResponseEntity<List<UserStatsDto>> getUserStats() {
        List<UserStatsDto> result = iUserService.getUserStats();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getMonthlySalesStats")
    public ResponseEntity<List<SalesStatsDto>> getSalesStats() {
        List<SalesStatsDto> result = iTransactionService.getMonthlySalesStats();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoMonthsSales")
    public ResponseEntity<List<SalesStatsDto>> getLastTwoMonthsSales() {
        List<SalesStatsDto> result = iTransactionService.getLastTwoMonthsSales();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoDaysSales")
    public ResponseEntity<List<SalesStatsDto>> getLastTwoDaysSales() {
        List<SalesStatsDto> result = iTransactionService.getLastTwoDaysSales();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoYearsSales")
    public ResponseEntity<List<SalesStatsDto>> getLastTwoYearsSales() {
        List<SalesStatsDto> result = iTransactionService.getLastTwoYearsSales();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoDaysUsers")
    public ResponseEntity<List<UserStatsDto>> getLastTwoDaysUserStats() {
        List<UserStatsDto> result = iUserService.getLastTwoDaysUserStats();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoMonthsUsers")
    public ResponseEntity<List<UserStatsDto>> getLastTwoMonthsUserStats() {
        List<UserStatsDto> result = iUserService.getLastTwoMonthsUserStats();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLastTwoYearsUsers")
    public ResponseEntity<List<UserStatsDto>> getLastTwoYearsUserStats() {
        List<UserStatsDto> result = iUserService.getLastTwoYearsUserStats();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getLanguage/{name}")
    public ResponseEntity<LanguageDto> getLanguageByName(@PathVariable(value = "name") String name) {
        LanguageDto result = iLanguageService.getLanguageByName(name);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getMovieByID/{id}")
    public ResponseEntity<FilmDto> getFilmByID(@PathVariable(value = "id") Integer id) {
        FilmDto film = iFilmService.getMovieById(id);

        return ResponseEntity.ok().body(film);
    }

    @GetMapping("/getLastUsers")
    public ResponseEntity<List<UserDto>> getLastUsers() {

        return ResponseEntity.ok().body(iUserService.getLastUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody AdminSignup adminSignup) {
        if (!iUserService.isUsedEmail(adminSignup.getEmail())) {
            boolean locked = adminSignup.isLocked();
            boolean enabled = adminSignup.isEnabled();
            Role roles = new Role();
            roles.setRoleId(adminSignup.getRoleId());
            Date expires = adminSignup.getExpires();
            User user = new User(adminSignup.getEmail(),
                    encoder.encode(adminSignup.getPassword()),
                    roles, expires, locked, enabled);
            userRepository.save(user);
            return ResponseEntity.ok().body(userRepository.getUserById(adminSignup.getId()));
        } else {
            return ResponseEntity.badRequest().body(userRepository.getUserById(adminSignup.getId()));
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody AdminSignup adminSignup) {
        System.out.println("fdfd");
        if (iUserService.isUsedEmail(adminSignup.getEmail())) {
            if (iUserService.getUserDtoByEmail(adminSignup.getEmail()).getId() == adminSignup.getId()) {
                boolean locked = adminSignup.isLocked();
                boolean enabled = adminSignup.isEnabled();
                Role roles = new Role();
                roles.setRoleId(adminSignup.getRoleId());
                Date expires = adminSignup.getExpires();
                User user = new User(adminSignup.getId(), adminSignup.getEmail(),
                        encoder.encode(adminSignup.getPassword()),
                        roles, expires, locked, enabled);
                userRepository.save(user);
                return ResponseEntity.ok().body(userRepository.getUserById(adminSignup.getId()));
            } else {
                return ResponseEntity.badRequest().body(userRepository.getUserById(adminSignup.getId()));
            }
        } else {
            boolean locked = adminSignup.isLocked();
            boolean enabled = adminSignup.isEnabled();
            Role roles = new Role();
            roles.setRoleId(adminSignup.getRoleId());
            Date expires = adminSignup.getExpires();
            User user = new User();
            if (adminSignup.getPassword() == null) {
                user = new User(adminSignup.getId(), userRepository.findById(adminSignup.getId()).get().getPassword(), adminSignup.getEmail(), roles, expires, locked, enabled);
            } else {
                user = new User(adminSignup.getId(), adminSignup.getEmail(), encoder.encode(adminSignup.getPassword()), roles, expires, locked, enabled);
            }
            userRepository.save(user);
            return ResponseEntity.ok().body(userRepository.getUserById(adminSignup.getId()));
        }
    }

}
