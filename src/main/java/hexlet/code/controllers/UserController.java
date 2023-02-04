package hexlet.code.controllers;

import hexlet.code.dto.UserDto;
import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import hexlet.code.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;



import static hexlet.code.controllers.UserController.USER_CONTROLLER_PATH;

@RestController
@RequestMapping("/api/" + USER_CONTROLLER_PATH)
@AllArgsConstructor
public class UserController {

    public static final String USER_CONTROLLER_PATH = "/users";
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;

    @Operation(summary = "Операция создания пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно создан"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка при создании пользователя")
    })
    @PostMapping("")
    public User createUser(@RequestBody @Valid UserDto userDto) {
        return userService.createNewUser(userDto);
    }

    @Operation(summary = "Операция получения всех пользователей")
    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @Operation(summary = "Операция получения пользователя по id")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) throws NoSuchElementException {
        return userRepository.findById(id).get();
    }

    @Operation(summary = "Операция обновления пользователя по id")
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody @Valid UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @Operation(summary = "Операция удаления пользователя по id")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
