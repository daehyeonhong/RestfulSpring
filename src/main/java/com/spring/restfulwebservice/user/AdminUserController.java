package com.spring.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.restfulwebservice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        final List<User> users = userDaoService.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    //    @GetMapping("/v1/users/{id}")
//    @GetMapping(value = "/users/{id}", params = "version1")
//    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveUserV1(@PathVariable Integer id) {
        final User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException(String.format("ID[%s] not found", id));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    //    @GetMapping("/v2/users/{id}")
//    @GetMapping(value = "/users/{id}", params = "version2")
//    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveUserV2(@PathVariable Integer id) {
        final User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException(String.format("ID[%s] not found", id));

        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user, userV2);
        userV2.setGrade("VIP");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "password", "grade");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userV2);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}