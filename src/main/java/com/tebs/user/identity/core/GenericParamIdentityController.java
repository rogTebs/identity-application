package com.tebs.user.identity.core;


import com.tebs.shared.generic_param.GenericParamAdapter;
import com.tebs.user.identity.core.api.GenericParamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity/generic-param")
public class GenericParamIdentityController extends GenericParamController {

    public GenericParamIdentityController(@Autowired(required = false) GenericParamAdapter adapter) {
        super(adapter);
    }
}
