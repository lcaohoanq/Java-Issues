package com.lcaohoanq.demo;

import java.util.Optional;

public interface IUserService {

    void save(User user);
    User isExist(String userId);

}
