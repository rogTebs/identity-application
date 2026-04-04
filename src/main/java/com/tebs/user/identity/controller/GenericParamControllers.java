package com.tebs.user.identity.controller;


import com.netflix.graphql.dgs.DgsComponent;
import com.tebs.shared.generic_param.GenericParamAdapter;
import com.tebs.user.identity.core.api.genericparam.IdentityGenericParamController;
import com.tebs.user.identity.core.api.genericparam.IdentityGenericParamGraphql;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class GenericParamControllers {
    @RestController
    @RequestMapping("/identity/generic-param")
    public static class IdentityController extends IdentityGenericParamController {
        public IdentityController(GenericParamAdapter adapter) {
            super(adapter);
        }
    }

    @DgsComponent
    public class KycGenericParamGraph extends IdentityGenericParamGraphql {
        public KycGenericParamGraph(GenericParamAdapter adapter) {
            super(adapter);
        }
    }
}
