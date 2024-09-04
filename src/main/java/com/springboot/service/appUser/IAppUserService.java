package com.springboot.service.appUser;

import com.springboot.model.AppUser;
import com.springboot.service.impl.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGenerateService<AppUser>, UserDetailsService {
}